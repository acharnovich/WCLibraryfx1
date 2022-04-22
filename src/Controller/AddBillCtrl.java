package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddBillCtrl {

    // FXML attributes

    @FXML
    private ToolBar addBillToolBar;

    @FXML
    private Button addBillSearchButton;

    @FXML
    private Label addBillLabel;

    @FXML
    private TextField addBillCardNumTextField;

    @FXML
    private Button addBillSubmitButton;

    @FXML
    private Label billDetailsAmountLabel;

    @FXML
    private TextField billDetailsAmountTextField;

    @FXML
    private Label billDetailsDescriptionLabel;

    @FXML
    private TextArea billDetailsDescriptionTextArea;

    @FXML
    private Label billDetailsIDLabel;

    @FXML
    private TextField billDetailsIDTextField;

    @FXML
    private Button billDetailsAddBillButton;

    // Other attributes
    private PatronList patrons;
    private NormalDate normalToday;     // variable to hold today's current date
    private ItemList iList;
    private PatronBillList billList;

    public void handleSubmitClick(javafx.event.ActionEvent actionEvent) {
        addBillSubmitButton.setOnMouseClicked(mouseEvent -> {

            patrons = new PatronList();

            // if the patron's is found in the database
            if (addBillCardNumTextField.getText().isEmpty() == false && patrons.foundCard(addBillCardNumTextField.getText()) == true) {

                // enable text fields
                billDetailsAmountTextField.setDisable(false);
                billDetailsDescriptionTextArea.setDisable(false);
                billDetailsIDTextField.setDisable(false);

            } else {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Error! Invalid Card Number");
                confirm.setContentText("Invalid card number. Please enter a valid 7-digit library card number.");
                confirm.showAndWait();
            }

        });
    }

    public void handleAddBillDetailsClick(ActionEvent actionEvent) {
        billDetailsAddBillButton.setOnMouseClicked(mouseEvent ->
        {
            // if the bill amount and bill description fields are filled out...
            if (!(billDetailsAmountTextField.getText().isEmpty()) && !(billDetailsDescriptionTextArea.getText().isEmpty())) {
                double billAmount;              // the amount of the bill to be created
                String description;             // the description of the bill to be created
                String itemID;                  // the item ID for the bill to be created

                iList = new ItemList();
                billList = new PatronBillList();

                // get today's date and assign the value to today
                LocalDate today = LocalDate.now();
                // call today's toString method and assign the value to todayString
                String todayString = today.toString();

                // Create a String array named dateSplit and split todayString where dashes appear
                String[] dateSplit = todayString.split("-", 0);

                // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
                // NormalDate object named dateOut
                normalToday = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

                billAmount = Double.parseDouble(billDetailsAmountTextField.getText());
                description = billDetailsDescriptionTextArea.getText();

                // if the item ID field is filled out
                if (!(billDetailsIDTextField.getText().isEmpty())) {
                    // if the item exists somewhere in the inventory...
                    if (iList.searchBookExact(billDetailsIDTextField.getText()) == true || iList.searchMovieExact(billDetailsIDTextField.getText()) == true
                            || iList.searchAudioExact(billDetailsIDTextField.getText()) == true) {
                        // get the item ID from the text field and assign the value to itemID
                        itemID = billDetailsIDTextField.getText();

                        // create a new bill object with all the data collected
                        Bill bill = new Bill(addBillCardNumTextField.getText(), itemID, normalToday, billAmount, 0.00, description);

                        // send bill as an argument to LoadBills method
                        bill.LoadBills(bill);

                        // update the patron's bill list with the newly added bill
                        billList.updateBillList(addBillCardNumTextField.getText(), bill);

                        billDetailsAddBillButton.getScene().getWindow().hide();

                        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                        confirm.setHeaderText("Bill Successfully Added");
                        confirm.setContentText("Bill has been successfully added to patron account number: " + addBillCardNumTextField.getText());
                        confirm.showAndWait();

                    }

                    // item ID is not in database...
                    else {
                        // display error
                        Alert confirm = new Alert(Alert.AlertType.ERROR);
                        confirm.setHeaderText("Error! Invalid Item ID Number");
                        confirm.setContentText("Invalid item ID number. Please enter a valid 7-digit item ID number.");
                        confirm.showAndWait();
                    }
                }
                // if the item ID field is not filled out...
                else {
                    // create a new bill object with all the data collected
                    Bill bill = new Bill(addBillCardNumTextField.getText(), null, normalToday, billAmount, 0.00, description);

                    // send bill as an argument to LoadBills method
                    bill.LoadBills(bill);

                    // update the patron's bill list with the newly added bill
                    billList.updateBillList(addBillCardNumTextField.getText(), bill);

                    billDetailsAddBillButton.getScene().getWindow().hide();

                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setHeaderText("Bill Successfully Added");
                    confirm.setContentText("Bill has been successfully added to patron account number: " + addBillCardNumTextField.getText());
                    confirm.showAndWait();
                }

            }

            // bill amount and description are not filled out...
            else {
                // display error
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Error! Missing Required Entry");
                confirm.setContentText("Please ensure all data is entered about bill to be created. Item ID is optional.");
                confirm.showAndWait();
            }

        });
    }

}
