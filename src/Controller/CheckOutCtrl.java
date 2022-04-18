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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class CheckOutCtrl
{

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

    @FXML
    private Label confirmationLabel;

    @FXML
    private Button anotherPatronButton;

    @FXML
    private Button backToNavButton;

    ObservableList<CheckOut> checkouts = FXCollections.observableArrayList();

    ObservableList<Item> items = FXCollections.observableArrayList();

    // other attributes
    private int cardNumberEntered;              // the patron card number entered
    private int itemOut;                        // the item ID number entered
    private AllCheckoutLists allCheckoutLists = new AllCheckoutLists();  // reference to AllCheckoutList object for json
                                                                         // file update method calls
public void checkoutVal(){
    libraryCardNumTextField.setOnKeyPressed(KeyEvent ->
    {
        if (!libraryCardNumTextField.getText().isEmpty())
        {
            beginCheckoutButton.setDisable(false);
        } else
        {
            beginCheckoutButton.setDisable(true);
        }
    });

    itemIDTextField.setOnKeyPressed(KeyEvent ->
    {
        if (!libraryCardNumTextField.getText().isEmpty())
        {
            checkOutItemButton.setDisable(false);
        } else
        {
           checkOutItemButton.setDisable(true);
        }
    });

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

    libraryCardNumTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
}

    public void handleBeginCheckoutClick(javafx.event.ActionEvent actionEvent)
    {
        beginCheckoutButton.setOnMouseClicked(mouseEvent ->
        {

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
                Boolean result = patrons.foundCardExact(libraryCardNumTextField.getText());

                // if the card was not found...
                if (result == false)
                {
                   libraryCardNumTextField.setStyle("-fx-background-color: red");
                }
                // otherwise...
                else
                {
                    if (patrons.foundCardExact(libraryCardNumTextField.getText()) == true)
                    {
                        libraryCardNumTextField.setStyle("-fx-background-color: green");
                        itemIDTextField.setDisable(false);
                    }
                    // get the text from the library card number text field, parse to int, and assign to cardNumberEntered
                    cardNumberEntered = Integer.parseInt(libraryCardNumTextField.getText());
                }
            }

        });

    }

    public void handleCheckOutItemClick(javafx.event.ActionEvent actionEvent)
    {
        checkOutItemButton.setOnMouseClicked(mouseEvent ->
        {

            // if there's nothing in the item ID text field, then...
            if (itemIDTextField.getText().isEmpty())
            {
                // create a new Alert of the AlertType Error named enterItemError
                Alert enterItemError = new Alert(Alert.AlertType.ERROR);
                // set the window title
                enterItemError.setHeaderText("Error!");
                // set the text inside the window
                enterItemError.setContentText("Please enter an Item ID Number to check out items.");
                enterItemError.showAndWait();
            }
            // otherwise...
            else
            {
                ItemList iList = new ItemList();

                if (iList.searchBookExact(itemIDTextField.getText()) == true || iList.searchMovieExact(itemIDTextField.getText()) == true || iList.searchAudioExact(itemIDTextField.getText()) == true)
                {
                    finishAndPrintButton.setDisable(false);
                    finishCheckoutButton.setDisable(false);
                    itemOut = Integer.parseInt(itemIDTextField.getText());
                    if(iList.checkBookCheckoutin(itemIDTextField.getText()) == false){
                    if (iList.bookReturnExact(itemIDTextField.getText()) != null && iList.searchBookExact(itemIDTextField.getText()) == true)
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
                        CheckOut checkoutTemp = new CheckOut(itemOut, cardNumberEntered, dateOut);

                        // update the patron's checkout list to reflect the new checkout
                        allCheckoutLists.updateCheckOutList(Integer.toString(cardNumberEntered), checkoutTemp);
                        // load the checkout to the json
                        checkoutTemp.LoadCheckouts(checkoutTemp);
                        // update the status of the item to checked out in the item list json
                        iList.checkOutItem(itemIDTextField.getText());


                        // display item ID in tableview
                        checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));

                        // display item title in tableview
                        checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));

                        // search for the book and then add it to items
                        items.addAll(iList.bookReturnExact(itemIDTextField.getText()));

                        // display items in the checkout table
                        checkoutTable.setItems(items);

                        // display the item due date
                        checkoutTableDueDate.setCellValueFactory(new PropertyValueFactory<CheckOut, NormalDate>("dueDate"));

                        // add all checkouts
                        checkouts.addAll(checkoutTemp);

                        // add the due dates
                        checkOutDueDateSeparate.setItems(checkouts);

                        // display confirmation that book was checked out
                        Alert bookAdded = new Alert(Alert.AlertType.CONFIRMATION);
                        bookAdded.setHeaderText("Book Added to Checkout");
                        bookAdded.setContentText("Success! Book has been added to Patron Account:" + libraryCardNumTextField.getText());
                        bookAdded.showAndWait();
                        itemIDTextField.clear();


                    }}else {
                        Alert bookAdded = new Alert(Alert.AlertType.ERROR);
                        bookAdded.setHeaderText("Book Already Out!");
                        bookAdded.setContentText("Book has already been checked out or removed from inventory:" + itemIDTextField.getText());
                        bookAdded.showAndWait();
                        itemIDTextField.clear();
                    }
if(iList.checkMovieCheckoutin(itemIDTextField.getText())==false){
                    if (iList.movieReturnExact(itemIDTextField.getText()) != null && iList.searchMovieExact(itemIDTextField.getText()) == true)
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
                        CheckOut checkoutTemp = new CheckOut(itemOut, cardNumberEntered, dateOut);

                        // update the patron's checkout list to reflect the new checkout
                        allCheckoutLists.updateCheckOutList(Integer.toString(cardNumberEntered), checkoutTemp);
                        // load the checkout to the json
                        checkoutTemp.LoadCheckouts(checkoutTemp);
                        // update the status of the item to checked out in the item list json
                        iList.checkOutItem(itemIDTextField.getText());

                        // display item ID to tableview
                        checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));

                        // display item title to tableview
                        checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));

                        // search movie and add it to items
                        items.addAll(iList.movieReturnExact(itemIDTextField.getText()));

                        // add items to the checkout table
                        checkoutTable.setItems(items);

                        // display due date in tableview
                        checkoutTableDueDate.setCellValueFactory(new PropertyValueFactory<CheckOut, NormalDate>("dueDate"));

                        // add all checkouts
                        checkouts.addAll(checkoutTemp);

                        // add the due dates
                        checkOutDueDateSeparate.setItems(checkouts);

                        // display confirmation that movie was checked out
                        Alert movieAdded = new Alert(Alert.AlertType.CONFIRMATION);
                        movieAdded.setHeaderText("Movie Added to Checkout");
                        movieAdded.setContentText("Success! Movie has been added to Patron Account:" + libraryCardNumTextField.getText());
                        movieAdded.showAndWait();
                        itemIDTextField.clear();


                    }}else {
    Alert bookAdded = new Alert(Alert.AlertType.ERROR);
    bookAdded.setHeaderText("Movie Already Out!");
    bookAdded.setContentText("Movie has already been checked out or removed from inventory:" + itemIDTextField.getText());
    bookAdded.showAndWait();
    itemIDTextField.clear();
}
if(iList.checkAudioCheckoutin(itemIDTextField.getText())==false){
if (iList.audioReturnExact(itemIDTextField.getText()) != null && iList.searchAudioExact(itemIDTextField.getText())==true)
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
                        CheckOut checkoutTemp = new CheckOut(itemOut, cardNumberEntered, dateOut);

                        // update the patron's checkout list to reflect the new checkout
                        allCheckoutLists.updateCheckOutList(Integer.toString(cardNumberEntered), checkoutTemp);
                        // load the checkout to the json
                        checkoutTemp.LoadCheckouts(checkoutTemp);
                        // update the status of the item to checked out in the item list json
                        iList.checkOutItem(itemIDTextField.getText());

                        // display the item id to the tableview
                        checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));

                        // display the title to the tableview
                        checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));

                        // search for audiobook and add to items
                        items.addAll(iList.audioReturnExact(itemIDTextField.getText()));

                        // add items to checkout table
                        checkoutTable.setItems(items);

                        // display due date in tableview
                        checkoutTableDueDate.setCellValueFactory(new PropertyValueFactory<CheckOut, NormalDate>("dueDate"));

                        // add all checkouts
                        checkouts.addAll(checkoutTemp);

                        // add due dates
                        checkOutDueDateSeparate.setItems(checkouts);

                        // display confirmation audiobook is checked out
                        Alert audioAdded = new Alert(Alert.AlertType.CONFIRMATION);
                        audioAdded.setHeaderText("Audiobook Added to Checkout");
                        audioAdded.setContentText("Success! Audiobook has been added to Patron Account:" + libraryCardNumTextField.getText());
                        audioAdded.showAndWait();
                        itemIDTextField.clear();

                    }
                } else {   Alert bookAdded = new Alert(Alert.AlertType.ERROR);
    bookAdded.setHeaderText("AudioBook Already Out!");
    bookAdded.setContentText("AudioBook has already been checked out or removed from inventory:" + itemIDTextField.getText());
    bookAdded.showAndWait();
    itemIDTextField.clear();}}
else
                {
                   itemIDTextField.setStyle("-fx-background-color: red");
                }
            }

        });
    }

    public void handleFinishCheckout(javafx.event.ActionEvent actionEvent)
    {
        finishCheckoutButton.setOnMouseClicked(mouseEvent ->
        {
            finishCheckoutButton.getScene().getWindow().hide();

            Parent part = null;
            try {
                part = FXMLLoader.load(getClass().getResource("/View/FinishCheckoutConfirmation.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(part);
                stage.setScene(scene);
                stage.setTitle("Checkout Complete");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void underDevPrint(javafx.event.ActionEvent actionEvent)
    {
        finishAndPrintButton.setOnMouseClicked(mouseEvent ->
        {
            Alert noItemID = new Alert(Alert.AlertType.ERROR);
            noItemID.setHeaderText("Under Development");
            noItemID.setContentText("Will be developed in Sprint 5 along with print functions.");
            noItemID.showAndWait();
        });
    }

    public void handleAnotherPatronClick(javafx.event.ActionEvent actionEvent)
    {
        anotherPatronButton.setOnMouseClicked(mouseEvent ->
        {
            anotherPatronButton.getScene().getWindow().hide();

            Parent part = null;
            try {
                part = FXMLLoader.load(getClass().getResource("/View/CheckOutUI.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(part);
                stage.setScene(scene);
                stage.setTitle("Check Out Items");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void handleBackToNavClick(javafx.event.ActionEvent actionEvent)
    {
        backToNavButton.setOnMouseClicked(mouseEvent ->
        {
            backToNavButton.getScene().getWindow().hide();
        });
    }

}
