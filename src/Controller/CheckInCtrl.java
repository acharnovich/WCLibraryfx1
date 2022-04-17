package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class CheckInCtrl {

    @FXML
    private Button checkInItemButton;

    @FXML
    private AnchorPane checkInPane;

    @FXML
    private TableView<Item> checkInTable;

    @FXML
    private TableColumn<?, ?> checkoutTableDueDate;

    @FXML
    private TableColumn<Item, Integer> checkoutTableItemID;

    @FXML
    private TableColumn<Item, Integer> checkoutTableTitle;

    @FXML
    private TableView<?> finesTable;

    @FXML
    private Button finishCheckInButton;

    @FXML
    private Label itemIDLabel;

    @FXML
    private TextField itemIDTextField;

    private int itemCheckIn;

    ObservableList<CheckOut> checkins = FXCollections.observableArrayList();

    ObservableList<Item> items = FXCollections.observableArrayList();

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
                        float daysPassed = today.compareTo(dueDateLocal);

                        // if the item is late
                        if (daysPassed > 0)
                        {
                            // display item ID in tableview
                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.bookReturn(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // Call today's toString and assign the value to a String named stringDueDate
                            String stringToday = today.toString();

                            // Create a String array named dateSplit and split stringToday where dashes appear
                            String[] dateSplit = stringToday.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named normalToday
                            NormalDate normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // Create a new Bill object with the patron ID, ite, ID, normalToday, the calculated fine, the amount
                            // paid so far (0.0), and a description
                            Bill lateBill = new Bill(Integer.toString(checkoutTransaction.getPatronID()),
                                                     Integer.toString(checkoutTransaction.getItemID()),
                                                     normalToday, (daysPassed * 0.25), 0.0, "Overdue fine");

                            // send lateBill as an argument to LoadBills method
                            lateBill.LoadBills(lateBill);

                            // update the patron's bill list with the newly added bill
                            billList.updateBillList(Integer.toString(checkoutTransaction.getPatronID()), lateBill);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));

                        }
                        // otherwise... (item is early or on time)
                        else
                        {
                            // display item ID in tableview
                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.bookReturn(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));
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
                        float daysPassed = today.compareTo(dueDateLocal);

                        // if the item is late
                        if (daysPassed > 0)
                        {
                            // display item ID in tableview
                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.movieReturn(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // Call today's toString and assign the value to a String named stringDueDate
                            String stringToday = today.toString();

                            // Create a String array named dateSplit and split stringToday where dashes appear
                            String[] dateSplit = stringToday.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named normalToday
                            NormalDate normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // Create a new Bill object with the patron ID, ite, ID, normalToday, the calculated fine, the amount
                            // paid so far (0.0), and a description
                            Bill lateBill = new Bill(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()),
                                    normalToday, (daysPassed * 0.25), 0.0, "Overdue fine");

                            // send lateBill as an argument to LoadBills method
                            lateBill.LoadBills(lateBill);

                            // update the patron's bill list with the newly added bill
                            billList.updateBillList(Integer.toString(checkoutTransaction.getPatronID()), lateBill);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));



                        }
                        // otherwise... (item is early or on time)
                        else
                        {
                            // display item ID in tableview
                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.movieReturn(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));
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
                        float daysPassed = today.compareTo(dueDateLocal);

                        // if the item is late
                        if (daysPassed > 0)
                        {
                            // display item ID in tableview
                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.audioReturn(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // Call today's toString and assign the value to a String named stringDueDate
                            String stringToday = today.toString();

                            // Create a String array named dateSplit and split stringToday where dashes appear
                            String[] dateSplit = stringToday.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named normalToday
                            NormalDate normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // Create a new Bill object with the patron ID, ite, ID, normalToday, the calculated fine, the amount
                            // paid so far (0.0), and a description
                            Bill lateBill = new Bill(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()),
                                    normalToday, (daysPassed * 0.25), 0.0, "Overdue fine");

                            // send lateBill as an argument to LoadBills method
                            lateBill.LoadBills(lateBill);

                            // update the patron's bill list with the newly added bill
                            billList.updateBillList(Integer.toString(checkoutTransaction.getPatronID()), lateBill);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));



                        }
                        // otherwise... (item is early or on time)
                        else
                        {
                            // display item ID in tableview
                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            // display item title in tableview
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                            items.addAll(iList.audioReturn(itemIDTextField.getText()));
                            checkInTable.setItems(items);

                            // delete checkout object
                            checkoutTransaction.checkIn(Integer.toString(checkoutTransaction.getItemID()));

                            // delete checkout from patron's checkout list
                            checkoutLists.removeFromCheckOutList(Integer.toString(checkoutTransaction.getPatronID()),
                                    Integer.toString(checkoutTransaction.getItemID()));
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
}
