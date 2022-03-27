package Controller;

import Model.*;
import View.FxLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

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

    @FXML    private ButtonBar logoutBar;

    private ItemList itemList;
    private StaffList staffList;

    public NavigationCtrl()
    {
        itemList = new ItemList();
        staffList = new StaffList();
        // importLists();
    }

    private void importLists() {
    }

    public void handleCreateAccount(javafx.event.ActionEvent actionEvent)
    {
        newAccountBtn.setOnMouseClicked(mouseEvent -> {
            FxLoader object = new FxLoader();
            Pane content = object.getPage("NewAccountUI");
            navBorder.setLeft(content);
        });
    }

    public void handleAddItem(javafx.event.ActionEvent actionEvent)
    {
        addItemBtn.setOnMouseClicked(mouseEvent -> {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/NewItemUI.fxml"));
                loader.setLocation(getClass().getResource("/View/NewItemUI.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setTitle("WCLibrary Add New Item");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e)
            {}
        });
    }
}
