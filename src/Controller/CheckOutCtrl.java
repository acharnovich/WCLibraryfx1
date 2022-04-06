/**
 * The CheckOutCtrl class is a controller class used to control checking out of items to a patron's account. It is the
 * designated controller class for the CheckOutUI.xml file as well.
 */

package Controller;

import Model.*;
import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class CheckOutCtrl {

    // FXML Components
    @FXML
    private Label libraryCardNumLabel;

    @FXML
    private TextField libraryCardNumTextField;

    @FXML
    private Button beginCheckoutButton;

    @FXML
    private Label itemIDLabel;

    @FXML
    private TextField itemIDTextField;

    @FXML
    private Button checkOutItemButton;

    @FXML
    private TableView checkoutTable;

    @FXML
    private TableColumn checkoutTableItemID;

    @FXML
    private TableColumn checkoutTableTitle;

    @FXML
    private TableColumn checkoutTableDueDate;

    @FXML
    private Button finishCheckoutButton;

    @FXML
    private Button finishAndPrintButton;

    @FXML
    private TableView checkOutDueDateSeparate;

    // other attributes
    private int cardNumberEntered;              // the patron card number entered
    private int itemOut;                        // the item ID number entered


    public void handleBeginCheckoutClick(javafx.event.ActionEvent actionEvent) {
        beginCheckoutButton.setOnMouseClicked(mouseEvent -> {

            // if there's nothing in the library card number text field, then...
            if (libraryCardNumTextField.getText().isEmpty())
            {
                // create a new Alert of the AlertType Error named enterCardError
                Alert enterCardError = new Alert(Alert.AlertType.ERROR);
                // set the window title
                enterCardError.setHeaderText("Error!");
                // set the text inside the window
                enterCardError.setContentText("Please enter a valid library card number to begin checking out items.");
                enterCardError.showAndWait();
            }
            // otherwise...
            else
            {
                // create a temp Patron List named patrons
                PatronList patrons = new PatronList();

                // Get the text entered in the library card number text field, run foundCard method on it, and
                // assign resulting Boolean to Boolean result
                Boolean result = patrons.foundCard(libraryCardNumTextField.getText());

                // if the card was not found...
                if (result == false)
                {
                    // create a new Alert of the AlertType Error named noLibraryCard
                    Alert noLibraryCard = new Alert(Alert.AlertType.ERROR);
                    // set the window title
                    noLibraryCard.setHeaderText("Error!");
                    // set the text inside the window
                    noLibraryCard.setContentText("No library card with that number exists. Please go back and enter a valid card number such as 12345678.");
                    noLibraryCard.showAndWait();
                }
                // otherwise...
                else
                {
                   if (patrons.foundCard(libraryCardNumTextField.getText()) == true){
                       Alert noLibraryCard = new Alert(Alert.AlertType.CONFIRMATION);
                       // set the window title
                       noLibraryCard.setHeaderText("Patron Found");
                       // set the text inside the window
                       noLibraryCard.setContentText("Patron Card Found. Please start adding item ID numbers to the checkout transaction");
                       noLibraryCard.showAndWait();
            itemIDTextField.setDisable(false);
            checkOutItemButton.setDisable(false);
                }
                    // get the text from the library card number text field, parse to int, and assign to cardNumberEntered
                    cardNumberEntered = Integer.parseInt(libraryCardNumTextField.getText());
                }
            }

        });

    }

    public void handleCheckOutItemClick(javafx.event.ActionEvent actionEvent) {
        checkOutItemButton.setOnMouseClicked(mouseEvent -> {

            // if there's nothing in the item ID text field, then...
            if (itemIDTextField.getText().isEmpty())
            {
                // create a new Alert of the AlertType Error named enterItemError
                Alert enterItemError = new Alert(Alert.AlertType.ERROR);
                // set the window title
                enterItemError.setHeaderText("Error!");
                // set the text inside the window
                enterItemError.setContentText("Please enter a Item ID Number to check out items.");
                enterItemError.showAndWait();
            }
            // otherwise...
            else
            {
                ItemList iList = new ItemList();

                if(iList.searchBook(itemIDTextField.getText()) == true || iList.searchMovie(itemIDTextField.getText()) == true || iList.searchAudio(itemIDTextField.getText()) == true)
                {

                    itemOut = Integer.parseInt(itemIDTextField.getText());

                    if (iList.bookReturn(itemIDTextField.getText()) != null)
                    {
                            // get today's date
                            LocalDate today = LocalDate.now();

                            // Call today's toString and assign the value to a String named stringDateOut
                            String stringDateOut = today.toString();

                            // Create a String array named dateSplit and split stringDateOut where dashes appear
                            String[] dateSplit = stringDateOut.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named dateOut
                            NormalDate dateOut = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // create a temp checkout object
                            CheckOut checkoutTemp = new CheckOut(cardNumberEntered, itemOut, dateOut);
                            checkoutTemp.LoadCheckouts(checkoutTemp);

                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                            ObservableList<Item> items = FXCollections.observableArrayList();
                            items.add(iList.bookReturn(itemIDTextField.getText()));
                            checkoutTable.setItems(items);

                            checkoutTableDueDate.setCellValueFactory(new PropertyValueFactory<CheckOut, NormalDate>("dueDate"));
                            ObservableList<CheckOut> checkouts = FXCollections.observableArrayList();
                            checkouts.add(checkoutTemp);
                            checkOutDueDateSeparate.setItems(checkouts);
                        Alert bookAdded = new Alert(Alert.AlertType.CONFIRMATION);
                        bookAdded.setHeaderText("Book Added to Checkout");
                        bookAdded.setContentText("Success! Book has peen added to Patron Accout:" + libraryCardNumTextField.getText());
                        bookAdded.showAndWait();



                        }

                        if (iList.movieReturn(itemIDTextField.getText()) != null)
                        {

                            // get today's date
                            LocalDate today = LocalDate.now();

                            // Call today's toString and assign the value to a String named stringDateOut
                            String stringDateOut = today.toString();

                            // Create a String array named dateSplit and split stringDateOut where dashes appear
                            String[] dateSplit = stringDateOut.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named dateOut
                            NormalDate dateOut = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // create a temp checkout object
                            CheckOut checkoutTemp = new CheckOut(cardNumberEntered, itemOut, dateOut);
                            checkoutTemp.LoadCheckouts(checkoutTemp);

                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                            ObservableList<Item> items = FXCollections.observableArrayList();
                            items.add(iList.movieReturn(itemIDTextField.getText()));
                            checkoutTable.setItems(items);

                            checkoutTableDueDate.setCellValueFactory(new PropertyValueFactory<CheckOut, NormalDate>("dueDate"));
                            ObservableList<CheckOut> checkouts = FXCollections.observableArrayList();
                            checkouts.add(checkoutTemp);
                            checkOutDueDateSeparate.setItems(checkouts);
                            Alert movieAdded = new Alert(Alert.AlertType.CONFIRMATION);
                            movieAdded.setHeaderText("Movie Added to Checkout");
                            movieAdded.setContentText("Success! Movie has peen added to Patron Accout:" + libraryCardNumTextField.getText());
                            movieAdded.showAndWait();


                        }
                        if (iList.audioReturn(itemIDTextField.getText()) != null)
                        {
                            // get today's date
                            LocalDate today = LocalDate.now();

                            // Call today's toString and assign the value to a String named stringDateOut
                            String stringDateOut = today.toString();

                            // Create a String array named dateSplit and split stringDateOut where dashes appear
                            String[] dateSplit = stringDateOut.split("-", 0);

                            // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                            // NormalDate object named dateOut
                            NormalDate dateOut = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                            // create a temp checkout object
                            CheckOut checkoutTemp = new CheckOut(cardNumberEntered, itemOut, dateOut);
                            checkoutTemp.LoadCheckouts(checkoutTemp);

                            checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                            checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                            ObservableList<Item> items = FXCollections.observableArrayList();
                            items.add(iList.audioReturn(itemIDTextField.getText()));
                            checkoutTable.setItems(items);

                            checkoutTableDueDate.setCellValueFactory(new PropertyValueFactory<CheckOut, NormalDate>("dueDate"));
                            ObservableList<CheckOut> checkouts = FXCollections.observableArrayList();
                            checkouts.add(checkoutTemp);
                            checkOutDueDateSeparate.setItems(checkouts);
                            Alert audioAdded = new Alert(Alert.AlertType.CONFIRMATION);
                            audioAdded.setHeaderText("Audio Added");
                            audioAdded.setContentText("Success! Movie has peen added to Patron Accout:" + libraryCardNumTextField.getText());
                            audioAdded.showAndWait();

                        }
                    }
                    else
                    {
                        Alert noItemID = new Alert(Alert.AlertType.ERROR);
                        noItemID.setHeaderText("No Item Found");
                        noItemID.setContentText("No Item found. Please enter a different Item ID Number.");
                        noItemID.showAndWait();
                    }
            }

        });
    }
   public void underDevCheckOut(javafx.event.ActionEvent actionEvent){
finishCheckoutButton.setOnMouseClicked(mouseEvent -> {
    Alert noItemID = new Alert(Alert.AlertType.ERROR);
    noItemID.setHeaderText("Under Development");
    noItemID.setContentText("Will be developed in Sprint 4. No functionality currently");
    noItemID.showAndWait();
});
   }

    public void underDevPrint(javafx.event.ActionEvent actionEvent){
        finishAndPrintButton.setOnMouseClicked(mouseEvent -> {
            Alert noItemID = new Alert(Alert.AlertType.ERROR);
            noItemID.setHeaderText("Under Development");
            noItemID.setContentText("Will be developed in Sprint 4. No functionality currently");
            noItemID.showAndWait();
        });
    }



}
