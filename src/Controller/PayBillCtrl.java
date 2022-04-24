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
import java.util.function.UnaryOperator;

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
        payBillsSearchButton.setOnMouseClicked(mouseEvent ->
        {

            patrons = new PatronList();
            billLists = new PatronBillList();
            checkoutLists = new AllCheckoutLists();

            // if the patron's is found in the database
            if (libraryCardNumTextField.getText().isEmpty() == false && patrons.foundCardExact(libraryCardNumTextField.getText()) == true)
            {


                // create a temporary Patron object and copy the patron from the json patronlist so information about patron can be displayed
                Patron patronTemp = patrons.getFromJson(libraryCardNumTextField.getText());

                // create a temporary billList object and copy the patron's bill list from the json so information about patron's account balance
                // can be displayed
                PatronBillList billListTemp = billLists.getFromJson(libraryCardNumTextField.getText());

                // create a temporary checkout list object and copy the patron's checkout list from the json so information about patron's number
                // of checkouts can be displayed
                PatronCheckoutList checkoutListTemp = checkoutLists.getFromJson(libraryCardNumTextField.getText());

                // set text of patronNameLabel to the name of the patron currently being viewed
                patronNameLabel.setText(patronTemp.getName());

                // call billListTemp's getAccountBalance method and turn the value into a string representing the account balance of the patron
                accountBalanceAmountLabel.setText("$" + billListTemp.getAccountBalance());

                // call checkoutListTemp's getNumCheckouts method and set the itemsCheckedOutNumberLabel to the String equivalent
                itemsCheckedOutNumberLabel.setText(Integer.toString(checkoutListTemp.getNumOfCheckouts()));


                // enable payment type radio buttons
                paymentTypeInFullRadioButton.setDisable(false);
                paymentTypeWaiveRadioButton.setDisable(false);
                paymentTypePartialPayRadioButton.setDisable(false);

                ObservableList<Bill> billsToDisplay = FXCollections.observableArrayList();

                payBillsItemIDColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("itemID"));
                payBillsDateBilledColumn.setCellValueFactory(new PropertyValueFactory<Bill, NormalDate>("dateBilled"));
                payBillsCurrentBalanceColumn.setCellValueFactory(new PropertyValueFactory<Bill, Double>("amtBilled"));
                payBillsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("description"));

                billsToDisplay.addAll(billListTemp.getBills());
if(!billListTemp.getBills().isEmpty()){
                payBillsTable.setItems(billsToDisplay);
              payBillsTable.setDisable(false);}else {
    Alert confirm = new Alert(Alert.AlertType.ERROR);
    confirm.setHeaderText("No Bills!");
    confirm.setContentText("Currently, this patron has no bills to pay.");
    confirm.showAndWait();
}

        }else {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Error! Invalid Card Number");
                confirm.setContentText("Invalid card number. Please enter a valid 7-digit library card number.");
                confirm.showAndWait();


            }

        });
    }

    public void handlePayInFullRadioClick(javafx.event.ActionEvent actionEvent)
    {
        paymentTypeInFullRadioButton.setOnMouseClicked(mouseEvent ->
        {
            // deselect other radio buttons
            paymentTypeWaiveRadioButton.setSelected(false);
            paymentTypePartialPayRadioButton.setSelected(false);

            // set paymentTypePartialPayTextField to disabled
            paymentTypePartialPayTextField.setDisable(true);

            // enable Pay Bills button
            payBillsButton.setDisable(false);

        });
    }

    public void handleWaiveRadioClick(javafx.event.ActionEvent actionEvent)
    {
        paymentTypeWaiveRadioButton.setOnMouseClicked(mouseEvent ->
        {
            // deselect other radio buttons
            paymentTypeInFullRadioButton.setSelected(false);
            paymentTypePartialPayRadioButton.setSelected(false);

            // set paymentTypePartialPayTextField to disabled
            paymentTypePartialPayTextField.setDisable(true);

            // enable Pay Bills button
            payBillsButton.setDisable(false);

        });
    }

    public void handlePartialPayRadioClick(javafx.event.ActionEvent actionEvent)
    {
        paymentTypePartialPayRadioButton.setOnMouseClicked(mouseEvent ->
        {
            // deselect other radio buttons
            paymentTypeInFullRadioButton.setSelected(false);
            paymentTypeWaiveRadioButton.setSelected(false);

            // set paymentTypePartialPayTextField to enabled
            paymentTypePartialPayTextField.setDisable(false);

            // enable Pay Bills button
            payBillsButton.setDisable(false);

        });
    }

    public void handlePayBillsClick(javafx.event.ActionEvent actionEvent)
    {
        payBillsButton.setOnMouseClicked(mouseEvent ->
        {
            patrons = new PatronList();
            bill = new Bill();
            PatronBillList patronBills = new PatronBillList();

            // if the payment in full radio button is selected...
            if (paymentTypeInFullRadioButton.isSelected())
            {
                // create a temporary String and assign the value of the patron's card number from the text field
                String patronTemp = libraryCardNumTextField.getText();

                // remove the bills from the bills json
                bill.removeAllBills(patronTemp);

                // remove the bills from the patronBillLists json
                patronBills.removeAllBills(patronTemp);

                // display confirmation
                Alert paidInFull = new Alert(Alert.AlertType.CONFIRMATION);
                paidInFull.setHeaderText("Bills Paid");
                paidInFull.setContentText("All bills have been paid in full.");
                paidInFull.showAndWait();
            }
            // else if the waive radio button is selected...
            else if (paymentTypeWaiveRadioButton.isSelected())
            {
                // create a temporary String and assign the value of the patron's card number from the text field
                String patronTemp = libraryCardNumTextField.getText();

                // remove the bills from the bills json
                bill.removeAllBills(patronTemp);

                // remove the bills from the patronBillLists json
                patronBills.removeAllBills(patronTemp);

                // display confirmation
                Alert paidInFull = new Alert(Alert.AlertType.CONFIRMATION);
                paidInFull.setHeaderText("Bills Waived");
                paidInFull.setContentText("All bills have been waived from patron's account.");
                paidInFull.showAndWait();
            }
            // else if partial pay is selected, but no amount in the text field
            else if (paymentTypePartialPayRadioButton.isSelected() && paymentTypePartialPayTextField.getText() == null)
            {
                // display error
                Alert noAmount = new Alert(Alert.AlertType.ERROR);
                noAmount.setHeaderText("Error! No Payment Amount Entered");
                noAmount.setContentText("Please enter an amount to be paid to continue with partial payment.");
                noAmount.showAndWait();
            }
            // else if partial pay is selected, with an amount in the text field
            else
            {
                // create a temporary String and assign the value of the patron's card number from the text field
                String patronTemp = libraryCardNumTextField.getText();

                // create a Double called amountToBePaid
                // convert the value of paymentTypePartialPayTextField to a Double and assign this value to amountToBePaid
                double amountToBePaid = Double.parseDouble(paymentTypePartialPayTextField.getText());

                // call the Bill object partialPay method and send patronTemp and amountToBePaid as parameters
                bill.partialPay(patronTemp, amountToBePaid);

                billLists.partialPay(patronTemp, amountToBePaid);

                // create a temporary billList object and copy the patron's bill list from the json so information about patron's account balance
                // can be displayed
                PatronBillList billListTemp = billLists.getFromJson(libraryCardNumTextField.getText());

                // display confirmation
                Alert partialPay = new Alert(Alert.AlertType.CONFIRMATION);
                partialPay.setHeaderText("Bills Paid Partially");
                partialPay.setContentText("Partial pay complete. New account balance is " + billListTemp.getAccountBalance());
                partialPay.showAndWait();

            }

        });
    }

    public void payBillValidation(){
        boolean disabled = (libraryCardNumTextField.getText().isEmpty());
        libraryCardNumTextField.setOnKeyReleased(keyEvent ->
        {
            if (!disabled)
            {
                payBillsSearchButton.setDisable(false);
            } else
            {
                payBillsSearchButton.setDisable(disabled);
            }

        });

        libraryCardNumTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 10)
                {
                    return change;
                }
                return null;
            }
        }));


    }

}
