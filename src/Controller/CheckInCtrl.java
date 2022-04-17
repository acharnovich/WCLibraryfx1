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

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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
                if (iList.searchBook(itemIDTextField.getText()) == true || iList.searchMovie(itemIDTextField.getText()) == true || iList.searchAudio(itemIDTextField.getText()) == true)
                {
                    // enable the finish check in button
                    finishCheckInButton.setDisable(false);

                    // get the Item ID number from the Item ID text field and convert to integer
                    itemCheckIn = Integer.parseInt(itemIDTextField.getText());

                    // if the item is a book...
                    if (iList.bookReturn(itemIDTextField.getText()) != null)
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

                            items.addAll(iList.bookReturn(itemIDTextField.getText()));

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

                            items.addAll(iList.bookReturn(itemIDTextField.getText()));

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


                    }

                    // if the item is a movie...
                    else if (iList.movieReturn(itemIDTextField.getText()) != null)
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

                            items.addAll(iList.movieReturn(itemIDTextField.getText()));
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

                            items.addAll(iList.movieReturn(itemIDTextField.getText()));

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

                    }

                    // if the item is an audiobook...
                    else if (iList.audioReturn(itemIDTextField.getText()) != null)
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

                            items.addAll(iList.audioReturn(itemIDTextField.getText()));
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

                            items.addAll(iList.audioReturn(itemIDTextField.getText()));

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


                    }

                    // if the item is some other type - should be impossible to reach this
                    else
                    {
                        Alert noItemID = new Alert(Alert.AlertType.ERROR);
                        noItemID.setHeaderText("Fatal Error");
                        noItemID.setContentText("It shouldn't be possible to reach this message, but if you do, congrats!");
                        noItemID.showAndWait();
                    }
                }
                else
                {
                    Alert noItemID = new Alert(Alert.AlertType.ERROR);
                    noItemID.setHeaderText("No Item Found");
                    noItemID.setContentText("No item found. Please enter a different Item ID Number.");
                    noItemID.showAndWait();
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
