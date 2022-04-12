package Controller;

import Model.CheckOut;
import Model.Item;
import Model.ItemList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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

                // if the item exists somewhere in the inventory...
                if (iList.searchBook(itemIDTextField.getText()) == true || iList.searchMovie(itemIDTextField.getText()) == true || iList.searchAudio(itemIDTextField.getText()) == true)
                {
                    // enable the finish check in button
                    finishCheckInButton.setDisable(false);

                    // get the Item ID number from the Item ID text field and convert to integer
                    itemCheckIn = Integer.parseInt(itemIDTextField.getText());

                    if (iList.bookReturn(itemIDTextField.getText()) != null)
                    {

                        // pull the checkout from the json, then assign the value to the CheckOut object checkoutTransaction
                        checkoutTransaction = checkoutTransaction.searchCheckOut(itemIDTextField.getText());

                        checkoutTableItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        checkoutTableTitle.setCellValueFactory(new PropertyValueFactory<Item, Integer>("title"));

                        // display item title in tableview

                        items.addAll(iList.bookReturn(itemIDTextField.getText()));
                        checkInTable.setItems(items);

                        System.out.println(checkoutTransaction.toString());

                    }

                    if (iList.movieReturn(itemIDTextField.getText()) != null)
                    {
                        checkoutTransaction = checkoutTransaction.searchCheckOut(itemIDTextField.getText());
                        System.out.println(checkoutTransaction.toString());
                    }
                    if (iList.audioReturn(itemIDTextField.getText()) != null)
                    {
                        checkoutTransaction = checkoutTransaction.searchCheckOut(itemIDTextField.getText());
                        System.out.println(checkoutTransaction.toString());
                    }
                } else
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
