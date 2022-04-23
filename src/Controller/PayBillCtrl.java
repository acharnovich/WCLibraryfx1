package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PayBillCtrl
{
    // FXML attributes
    @FXML
    private Label libraryCardNumLabel;

    @FXML
    private TextField libraryCardNumTextField;

    @FXML
    private Button payBillsSearchButton;

    @FXML
    private Label paymentTypeLabel;

    @FXML
    private RadioButton paymentTypeInFullRadioButton;

    @FXML
    private RadioButton paymentTypeWaiveRadioButton;

    @FXML
    private RadioButton paymentTypePartialPayRadioButton;

    @FXML
    private TextField paymentTypePartialPayTextField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label patronNameLabel;

    @FXML
    private Label accountBalanceLabel;

    @FXML
    private Label accountBalanceAmountLabel;

    @FXML
    private Label itemsCheckedOutLabel;

    @FXML
    private Label itemsCheckedOutNumberLabel;

    @FXML
    private Button payBillsButton;

    @FXML
    private TableView<Bill> payBillsTable;

    @FXML
    private TableColumn<Bill, String> payBillsItemIDColumn;

    @FXML
    private TableColumn<Bill, NormalDate> payBillsDateBilledColumn;

    @FXML
    private TableColumn<Bill, Double> payBillsCurrentBalanceColumn;

    @FXML
    private TableColumn<Bill, String> payBillsDescriptionColumn;

    // Other attributes
    private PatronList patrons;
    private Bill bill;
    private PatronBillList billLists;
    private AllCheckoutLists checkoutLists;


    public void handleSearchClick(javafx.event.ActionEvent actionEvent)
    {
        payBillsSearchButton.setOnMouseClicked(mouseEvent -> {

            patrons = new PatronList();
            billLists = new PatronBillList();
            checkoutLists = new AllCheckoutLists();

            // if the patron's is found in the database
            if (libraryCardNumTextField.getText().isEmpty() == false && patrons.foundCard(libraryCardNumTextField.getText()) == true) {

                // create a temporary Patron object and copy the patron from the json patronlist so information about patron can be displayed
                Patron patronTemp = patrons.getFromJson(libraryCardNumTextField.getText());

                // create a temporary billList object and copy the patron's bill list from the json so information about patron's account balance
                // can be displayed
                PatronBillList billListTemp = billLists.getFromJson(libraryCardNumTextField.getText());

                /**
                 * To do
                 */
                // create a temporary checkout list object and copy the patron's checkout list from the json so information about patron's number
                // of checkouts can be displayed
                //PatronCheckoutList checkoutListTemp = checkoutLists.getFromJson(libraryCardNumTextField.getText());

                // set text of patronNameLabel to the name of the patron currently being viewed
                patronNameLabel.setText(patronTemp.getName());

                // call billListTemp's getAccountBalance method and turn the value into a string representing the account balance of the patron
                accountBalanceAmountLabel.setText("$" + billListTemp.getAccountBalance());




                // enable payment type radio buttons
                paymentTypeInFullRadioButton.setDisable(false);
                paymentTypeWaiveRadioButton.setDisable(false);
                paymentTypePartialPayRadioButton.setDisable(false);

                ObservableList<Bill> billsToDisplay = FXCollections.observableArrayList();

                payBillsItemIDColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("itemID"));
                payBillsDateBilledColumn.setCellValueFactory(new PropertyValueFactory<Bill, NormalDate>("dateBilled"));
                payBillsCurrentBalanceColumn.setCellValueFactory(new PropertyValueFactory<Bill, Double>("amtBilled"));
                payBillsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("description"));

                // this is wrong
                billsToDisplay.addAll(billListTemp.getBills());

                payBillsTable.setItems(billsToDisplay);
                payBillsTable.setDisable(false);

            } else {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Error! Invalid Card Number");
                confirm.setContentText("Invalid card number. Please enter a valid 7-digit library card number.");
                confirm.showAndWait();
            }

        });
    }
}
