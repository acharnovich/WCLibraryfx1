package Controller;

import View.FxLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class SearchCtrl {

    @FXML
    private AnchorPane searchPersonAnchorPane;

    @FXML
    private ScrollPane scrollPersonScrollPane;

    @FXML
    private Button searchPersonIDButton;

    @FXML
    private Button searchPersonNameButton;

    @FXML
    private Button searchPersonDateOfBirthButton;

    @FXML
    private Button searchPersonAddressButton;

    @FXML
    private Button searchPersonEmailButton;

    @FXML
    private Button searchPersonPhoneNumberButton;

    @FXML
    private RadioButton searchPersonRadioButton;

    @FXML
    private RadioButton searchItemRadioButton;

    @FXML
    private BorderPane searchRadioPane;

    @FXML
    private Button searchPersonExitButton;

    @FXML
    private Button searchItemExitButton;

    @FXML
    private Button searchItemSearchButton;

    @FXML
    private Button searchPersonSearchButton;

    @FXML
    private RadioButton searchPersonByNameRadioButton;

    @FXML
    private RadioButton searchPersonByIDRadioButton;

    @FXML
    private RadioButton searchPersonByEmailRadioButton;

    @FXML
    private RadioButton searchItemByTitleRadioButton;

    @FXML
    private RadioButton searchItemByIDRadioButton;

    // Other attributes
    String searchPersonType;
    String searchItemType;

    @FXML
    public void handlePersonRadioButtonClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchItemRadioButton.setSelected(false);
            FxLoader object = new FxLoader();
            Pane content = object.getPage("SearchPerson");
            this.searchRadioPane.setRight(content);

        });

    }

    @FXML
    public void handleItemRadioButtonClick(javafx.event.ActionEvent actionEvent)
    {
        searchItemRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchPersonRadioButton.setSelected(false);
            FxLoader object = new FxLoader();
            Pane content = object.getPage("SearchItem");
            this.searchRadioPane.setRight(content);

        });

    }


    @FXML
    public void handleSearchPersonClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonSearchButton.setOnMouseClicked(mouseEvent ->
        {
            System.out.println("Search is incomplete at this time.");
        });

    }

    @FXML
    public void handleSearchItemClick(javafx.event.ActionEvent actionEvent)
    {
        searchItemSearchButton.setOnMouseClicked(mouseEvent ->
        {
            System.out.println("Search is incomplete at this time.");
        });

    }

    @FXML
    public void handleSearchPersonNameRadioClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonByNameRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchPersonByIDRadioButton.setSelected(false);
            searchPersonByEmailRadioButton.setSelected(false);
            searchPersonType = "By Name";
            System.out.println("Selected search person by name.");
        });
    }

    @FXML
    public void handleSearchPersonIDRadioClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonByIDRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchPersonByNameRadioButton.setSelected(false);
            searchPersonByEmailRadioButton.setSelected(false);
            searchPersonType = "By ID";
            System.out.println("Selected search person by ID number.");
        });
    }

    @FXML
    public void handleSearchPersonEmailRadioClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonByEmailRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchPersonByNameRadioButton.setSelected(false);
            searchPersonByIDRadioButton.setSelected(false);
            searchPersonType = "By Email";
            System.out.println("Selected search person by email.");
        });
    }

    @FXML
    public void handleSearchItemByTitleRadioButtonClick(javafx.event.ActionEvent actionEvent)
    {
        searchItemByTitleRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchItemByIDRadioButton.setSelected(false);
            searchItemType = "By Title";
            System.out.println("Selected search item by title.");
        });
    }

    @FXML
    public void handleSearchItemByIDRadioButtonClick(javafx.event.ActionEvent actionEvent)
    {
        searchItemByIDRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchItemByTitleRadioButton.setSelected(false);
            searchItemType = "By ID";
            System.out.println("Selected search item by ID number.");
        });
    }
}
