package Controller;

import Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

public class CheckInCtrl {

    @FXML
    private Button checkInItemButton;

    @FXML
    private AnchorPane checkInPane;

    @FXML
    private TableView<Item> checkInTable;

    @FXML
    private TableColumn<String, String> checkInTableFines;

    @FXML
    private TableColumn<Item, Integer> checkInTableItemID;

    @FXML
    private TableColumn<Item, Integer> checkInTableTitle;

    @FXML
    private TableView<String> finesTable;

    @FXML
    private Button finishCheckInButton;

    @FXML
    private Label itemIDLabel;

    @FXML
    private TextField itemIDTextField;

    private int itemCheckIn;

    ObservableList<Item> items = FXCollections.observableArrayList();
    Collection<String> finesCollection = new ArrayList<>();
    ObservableList<String> fines = FXCollections.observableArrayList(finesCollection);

    public void checkinVal()
    {
        itemIDTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 12)
                {
                    return change;
                }
                return null;
            }
        }));
        itemIDTextField.setOnKeyReleased(KeyEvent ->
        {
            if (!itemIDTextField.getText().isEmpty())
            {
                checkInItemButton.setDisable(false);
            } else
            {
                checkInItemButton.setDisable(true);
            }
        });
    }


    public void handleCheckInItemClick(javafx.event.ActionEvent actionEvent)
    {
        checkInItemButton.setOnMouseClicked(mouseEvent ->
        {

            // if there's nothing in the item ID text field, then...
            if (itemIDTextField.getText().isEmpty())
            {
                // create a new Alert of the AlertType Error named enterItemError
                Alert enterItemError = new Alert(Alert.AlertType.ERROR);
                // set the window title
                enterItemError.setHeaderText("Error!");
                // set the text inside the window
                enterItemError.setContentText("Please enter an Item ID Number to check in items.");
                enterItemError.showAndWait();
            }
            // otherwise...
            else
            {
                // create a new ItemList object named iList so that ItemList methods can be used
                ItemList iList = new ItemList();

                // create a new CheckOut object named checkoutTransaction to store the checkout transaction if found
                CheckOut checkoutTransaction = new CheckOut();
                PatronBillList billList = new PatronBillList();
                AllCheckoutLists checkoutLists = new AllCheckoutLists();

                // if the item exists somewhere in the inventory...
                if (iList.searchBookExact(itemIDTextField.getText()) == true || iList.searchMovieExact(itemIDTextField.getText()) == true || iList.searchAudioExact(itemIDTextField.getText()) == true)
                {

                    itemIDTextField.setStyle("-fx-background-color: white");
                    // enable the finish check in button
                    finishCheckInButton.setDisable(false);

                    // get the Item ID number from the Item ID text field and convert to integer
                    itemCheckIn = Integer.parseInt(itemIDTextField.getText());

                    // if the item is a book...
if(iList.checkBookCheckoutinVerify(itemIDTextField.getText())==false){
                    if (iList.bookReturnExact(itemIDTextField.getText()) != null &&iList.searchBookExact(itemIDTextField.getText()) == true)
                    {

                        // pull the checkout from the json, then assign the value to the CheckOut object checkoutTransaction
                        checkoutTransaction = checkoutTransaction.searchCheckOut(itemIDTextField.getText());

                        // get today's date
                        LocalDate today = LocalDate.now();

                        // get the due date from checkoutTransaction
                        NormalDate dueDate = checkoutTransaction.getDueDate();
                        // convert dueDate to String
                        String dueDateAsString = dueDate.toString();
                        // parse dueDateAsString to a LocalDate object
                        LocalDate dueDateLocal = LocalDate.parse(dueDateAsString);

                        // compare today to dueDateLocal and assign the value to daysPassed
                        double daysPassed = today.compareTo(dueDateLocal);

                        // if the item is late
                        if (daysPassed > 0)
                        {
                            // display item ID in tableview
                            checkInTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkInTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.bookReturnExact(itemIDTextField.getText()));

                            // Call today's toString and assign the value to a String named stringDueDate
                            String stringToday = today.toString();

                            // Create a String array named dateSplit and split stringToday where dashes appear
                            String[] dateSplit = stringToday.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named normalToday
                            NormalDate normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // calculate fine and assign the resulting value to checkinFine
                            double checkinFine = daysPassed * 0.25;

                            // Create a new Bill object with the patron ID, ite, ID, normalToday, the calculated fine, the amount
                            // paid so far (0.0), and a description
                            Bill lateBill = new Bill(Integer.toString(checkoutTransaction.getPatronID()),
                                                     Integer.toString(checkoutTransaction.getItemID()),
                                                     normalToday, checkinFine, 0.0, "Overdue fine");

                            // send lateBill as an argument to LoadBills method
                            lateBill.LoadBills(lateBill);

                            // update the patron's bill list with the newly added bill
                            billList.updateBillList(Integer.toString(checkoutTransaction.getPatronID()), lateBill);

                            // convert checkinFine to a string with a dollar sign at the beginning, then add to finesCollection
                            finesCollection.add("$" + checkinFine);

                            // display checkinFine in checkInFines column
                            checkInTableFines.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

                            fines.addAll(finesCollection);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                            // change the status of the item to 'Checked In' in the item database
                            iList.checkInItem(Integer.toString(checkoutTransaction.getItemID()));

                            checkInTable.setItems(items);
                            finesTable.setItems(fines);

                        }
                        // otherwise... (item is early or on time)
                        else
                        {
                            // display item ID in tableview
                            checkInTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkInTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.bookReturnExact(itemIDTextField.getText()));

                            // convert checkinFine to a string with a dollar sign at the beginning, then add to finesCollection
                            finesCollection.add("$0.00");

                            // display checkinFine in checkInFines column
                            checkInTableFines.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

                            fines.addAll(finesCollection);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                            // change the status of the item to 'Checked In' in the item database
                            iList.checkInItem(Integer.toString(checkoutTransaction.getItemID()));

                            checkInTable.setItems(items);
                            finesTable.setItems(fines);
                        }

                        itemIDTextField.clear();
                    }}else {

    Alert bookAdded = new Alert(Alert.AlertType.ERROR);
    bookAdded.setHeaderText("Book Already In!");
    bookAdded.setContentText("Book has already been checked in: " + itemIDTextField.getText());
    bookAdded.showAndWait();
    itemIDTextField.clear();
}

                    // if the item is a movie...

                        if (iList.checkMovieCheckoutinVerify(itemIDTextField.getText())==false){
                        if (iList.movieReturnExact(itemIDTextField.getText()) != null &&iList.searchMovieExact(itemIDTextField.getText()) == true)
                    {
                        // pull the checkout from the json, then assign the value to the CheckOut object checkoutTransaction
                        checkoutTransaction = checkoutTransaction.searchCheckOut(itemIDTextField.getText());

                        // get today's date
                        LocalDate today = LocalDate.now();

                        // get the due date from checkoutTransaction
                        NormalDate dueDate = checkoutTransaction.getDueDate();
                        // convert dueDate to String
                        String dueDateAsString = dueDate.toString();
                        // parse dueDateAsString to a LocalDate object
                        LocalDate dueDateLocal = LocalDate.parse(dueDateAsString);

                        // compare today to dueDateLocal and assign the value to daysPassed
                        double daysPassed = today.compareTo(dueDateLocal);

                        // if the item is late
                        if (daysPassed > 0)
                        {
                            // display item ID in tableview
                            checkInTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkInTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.movieReturnExact(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // Call today's toString and assign the value to a String named stringDueDate
                            String stringToday = today.toString();

                            // Create a String array named dateSplit and split stringToday where dashes appear
                            String[] dateSplit = stringToday.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named normalToday
                            NormalDate normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // calculate fine and assign the resulting value to checkinFine
                            double checkinFine = daysPassed * 0.25;

                            // Create a new Bill object with the patron ID, ite, ID, normalToday, the calculated fine, the amount
                            // paid so far (0.0), and a description
                            Bill lateBill = new Bill(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()),
                                    normalToday, checkinFine, 0.0, "Overdue fine");

                            // send lateBill as an argument to LoadBills method
                            lateBill.LoadBills(lateBill);

                            // update the patron's bill list with the newly added bill
                            billList.updateBillList(Integer.toString(checkoutTransaction.getPatronID()), lateBill);

                            // convert checkinFine to a string with a dollar sign at the beginning, then add to finesCollection
                            finesCollection.add("$" + checkinFine);

                            // display checkinFine in checkInFines column
                            checkInTableFines.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

                            fines.addAll(finesCollection);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                            // change the status of the item to 'Checked In' in the item database
                            iList.checkInItem(Integer.toString(checkoutTransaction.getItemID()));

                            checkInTable.setItems(items);
                            finesTable.setItems(fines);



                        }
                        // otherwise... (item is early or on time)
                        else
                        {
                            // display item ID in tableview
                            checkInTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkInTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.movieReturnExact(itemIDTextField.getText()));

                            // convert checkinFine to a string with a dollar sign at the beginning, then add to finesCollection
                            finesCollection.add("$0.00");

                            // display checkinFine in checkInFines column
                            checkInTableFines.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

                            fines.addAll(finesCollection);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                            // change the status of the item to 'Checked In' in the item database
                            iList.checkInItem(Integer.toString(checkoutTransaction.getItemID()));

                            checkInTable.setItems(items);
                            finesTable.setItems(fines);
                        }

                    }}else {
                            Alert bookAdded = new Alert(Alert.AlertType.ERROR);
                            bookAdded.setHeaderText("Movie Already In!");
                            bookAdded.setContentText("Movie has already been checked in: " + itemIDTextField.getText());
                            bookAdded.showAndWait();

                        }

                    // if the item is an audiobook...

                        if (iList.checkAudioCheckoutinVerify(itemIDTextField.getText())==false){
                        if (iList.audioReturnExact(itemIDTextField.getText()) != null &&iList.searchAudioExact(itemIDTextField.getText()) == true)
                    {
                        // pull the checkout from the json, then assign the value to the CheckOut object checkoutTransaction
                        checkoutTransaction = checkoutTransaction.searchCheckOut(itemIDTextField.getText());

                        // get today's date
                        LocalDate today = LocalDate.now();

                        // get the due date from checkoutTransaction
                        NormalDate dueDate = checkoutTransaction.getDueDate();
                        // convert dueDate to String
                        String dueDateAsString = dueDate.toString();
                        // parse dueDateAsString to a LocalDate object
                        LocalDate dueDateLocal = LocalDate.parse(dueDateAsString);

                        // compare today to dueDateLocal and assign the value to daysPassed
                        double daysPassed = today.compareTo(dueDateLocal);

                        // if the item is late
                        if (daysPassed > 0)
                        {
                            // display item ID in tableview
                            checkInTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkInTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.audioReturnExact(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // Call today's toString and assign the value to a String named stringDueDate
                            String stringToday = today.toString();

                            // Create a String array named dateSplit and split stringToday where dashes appear
                            String[] dateSplit = stringToday.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named normalToday
                            NormalDate normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // calculate fine and assign the resulting value to checkinFine
                            double checkinFine = daysPassed * 0.25;

                            // Create a new Bill object with the patron ID, ite, ID, normalToday, the calculated fine, the amount
                            // paid so far (0.0), and a description
                            Bill lateBill = new Bill(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()),
                                    normalToday, checkinFine, 0.0, "Overdue fine");

                            // send lateBill as an argument to LoadBills method
                            lateBill.LoadBills(lateBill);

                            // update the patron's bill list with the newly added bill
                            billList.updateBillList(Integer.toString(checkoutTransaction.getPatronID()), lateBill);

                            // convert checkinFine to a string with a dollar sign at the beginning, then add to finesCollection
                            finesCollection.add("$" + checkinFine);

                            // display checkinFine in checkInFines column
                            checkInTableFines.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

                            fines.addAll(finesCollection);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                            // change the status of the item to 'Checked In' in the item database
                            iList.checkInItem(Integer.toString(checkoutTransaction.getItemID()));

                            checkInTable.setItems(items);
                            finesTable.setItems(fines);



                        }
                        // otherwise... (item is early or on time)
                        else
                        {
                            // display item ID in tableview
                            checkInTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkInTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.audioReturnExact(itemIDTextField.getText()));

                            // convert checkinFine to a string with a dollar sign at the beginning, then add to finesCollection
                            finesCollection.add("$0.00");

                            // display checkinFine in checkInFines column
                            checkInTableFines.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

                            fines.addAll(finesCollection);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                            // change the status of the item to 'Checked In' in the item database
                            iList.checkInItem(Integer.toString(checkoutTransaction.getItemID()));

                            checkInTable.setItems(items);
                            finesTable.setItems(fines);

                        }


                    }}else {
                            Alert bookAdded = new Alert(Alert.AlertType.ERROR);
                            bookAdded.setHeaderText("AudioBook Already In!");
                            bookAdded.setContentText("AudioBook has already been checked in: " + itemIDTextField.getText());
                            bookAdded.showAndWait();
                        }


                    // if the item is some other type - should be impossible to reach th
                }
                else
                {
                    itemIDTextField.setStyle("-fx-background-color: red");
                }
            }

        });
    }

    public void handleFinishCheckInClick(javafx.event.ActionEvent actionEvent)
    {
        finishCheckInButton.setOnMouseClicked(mouseEvent ->
        {
            // hide the check in window
            finishCheckInButton.getScene().getWindow().hide();

        });

    }
}
