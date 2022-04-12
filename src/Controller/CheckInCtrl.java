package Controller;

import Model.CheckOut;
import Model.Item;
import Model.ItemList;
import Model.NormalDate;
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
    private TableView<?> checkInTable;

    @FXML
    private TableColumn<?, ?> checkoutTableDueDate;

    @FXML
    private TableColumn<?, ?> checkoutTableItemID;

    @FXML
    private TableColumn<?, ?> checkoutTableTitle;

    @FXML
    private TableView<?> finesTable;

    @FXML
    private Button finishCheckInButton;

    @FXML
    private Label itemIDLabel;

    @FXML
    private TextField itemIDTextField;

    private int itemCheckIn;

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
