package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PayBillCtrl {

    @FXML
    private Label accountBalFillLbl;

    @FXML
    private Label accountBalLbl;

    @FXML
    private Button beginDuesButton;

    @FXML
    private TableColumn<?, ?> currentBalCol;

    @FXML
    private TableColumn<?, ?> dateBilledCol;

    @FXML
    private Label itemsCheckedFillLbl;

    @FXML
    private Label itemsCheckedLbl;

    @FXML
    private Label libraryCardNumLabel;

    @FXML
    private TextField libraryCardNumTextField;

    @FXML
    private Label nameFillLbl;

    @FXML
    private Label nameLabel;

    @FXML
    private Button payBillsBtn;

    @FXML
    private TableColumn<?, ?> payBillsDescripCol;

    @FXML
    private TableView<?> payBillsDescripTbl;

    @FXML
    private TableView<?> payBillsTable;

    @FXML
    private TableColumn<?, ?> payBillsTableItemID;

}
