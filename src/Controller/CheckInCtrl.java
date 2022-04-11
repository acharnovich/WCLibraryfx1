package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

}
