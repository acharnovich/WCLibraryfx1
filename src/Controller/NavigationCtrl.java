package Controller;

import Model.*;
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
        importLists();
    }

    private void importLists() {
        Book bookTemp;                                 // temp variable for initializing Book objects before adding to inventory
        Collaborator collabTemp;                       // temp variable for initializing Collaborator objects before adding to collabs
        ArrayList<Collaborator> collabTempList;        // temp variable for initializing Collaborator ArrayLists before adding to
                                                       // an Item

        ArrayList<Collaborator> collabs = new ArrayList<>();

        // create a Collaborator object with temp variable
        collabTemp = new Collaborator("Jason", "Schreier", new ArrayList<Item>(), 1);
        // make an ArrayList of Collaborators to pass to the Item object
        collabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);
        // create Book object and assign value to temp variable
        bookTemp = new Book(9101342, "Press Reset", 2021, "May, 11, 2021", "From the bestselling author " +
                "of Blood, Sweat, and Pixels comes the next definitive, behind-the-scenes account of the video game industry: how "
                + "some of the past decade's most renowned studios fell apart—and the stories, both triumphant and tragic, of " +
                "what happened next.", "Checked In", "Grand Central Publishing", collabTempList, "301 " +
                "pages.", "Non-fiction");
        // add temp Book to inventory list

        itemList.LoadBook(bookTemp);
    }

    public void handleCreateAccount(javafx.event.ActionEvent actionEvent)
    { newAccountBtn.setOnMouseClicked(mouseEvent -> {
        FxLoader object = new FxLoader();
        Pane content = object.getPage("NewAccountUI");
        navBorder.setLeft(content);



    });
    }
}
