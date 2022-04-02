package Controller;

import Model.*;
import View.FxLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    private Stage primaryStage;

    private ItemList itemList;
    private StaffList staffList;
    private PatronCheckoutList list;

    public NavigationCtrl()
    {
        itemList = new ItemList();
        staffList = new StaffList();
        list = new PatronCheckoutList();
    }

    private void importLists() {
        list.LoadList(new PatronCheckoutList(45345, new ArrayList<CheckOut>()));
    }

    public void handleCreateAccount(javafx.event.ActionEvent actionEvent)
    {
        importLists();
        newAccountBtn.setOnMouseClicked(mouseEvent -> {
            FxLoader object = new FxLoader();
            Pane content = object.getPage("NewAccountUI");
            navBorder.setLeft(content);
        });

    }

    public void handleSearchClick(javafx.event.ActionEvent actionEvent)
    {
        searchBtn.setOnMouseClicked(mouseEvent -> {
            FxLoader object = new FxLoader();
            Pane content = object.getPage("SearchUI");
            navBorder.setLeft(content);

        });
    }

    public void handleAddItem(javafx.event.ActionEvent actionEvent)
    {
        addItemBtn.setOnMouseClicked(mouseEvent -> {


            Parent part = null;
            try {
                part = FXMLLoader.load(getClass().getResource("/View/NewItemUI.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(part);
                stage.setScene(scene);
                stage.setTitle("Add New Item");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void handleRemoveItemClick(javafx.event.ActionEvent actionEvent)
    {
        removeItemBtn.setOnMouseClicked(mouseEvent -> {


            Parent part = null;
            try {
                part = FXMLLoader.load(getClass().getResource("/View/ArchiveItemUI.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(part);
                stage.setScene(scene);
                stage.setTitle("Remove Item");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void handleCheckoutClick(javafx.event.ActionEvent actionEvent)
    {
        checkoutBtn.setOnMouseClicked(mouseEvent -> {


            Parent part = null;
            try {
                CheckOutCtrl controller = new CheckOutCtrl();
                controller.testCheckOut();

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

    public BorderPane getNavBorder()
    {
        return navBorder;
    }
}
