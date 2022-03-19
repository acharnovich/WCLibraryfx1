package Controller;

import View.FxLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;

public class NavigationCtrl {

    @FXML
    private Button addBillBtn;

    @FXML
    private Button addItemBtn;

    @FXML
    private Button checkinBtn;

    @FXML
    private Button checkoutBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private ToolBar menuBar;

    @FXML
    private BorderPane navBorder;

    @FXML
    private AnchorPane navUI;

    @FXML
    private Button newAccountBtn;

    @FXML
    private Button payBillBtn;

    @FXML
    private Button removeItemBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private ButtonBar logoutBar;

    public void handleCreateAccount(javafx.event.ActionEvent actionEvent)
    { newAccountBtn.setOnMouseClicked(mouseEvent -> {
        FxLoader object = new FxLoader();
        Pane content = object.getPage("NewAccountUI");
        navBorder.setLeft(content);



    });
    }
}
