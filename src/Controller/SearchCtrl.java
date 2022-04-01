package Controller;

import Model.ItemList;
import Model.PatronList;
import Model.StaffList;
import View.FxLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class SearchCtrl {
    @FXML
    private Label itemResultsLbl;
    @FXML
    private Label ageLbl;

    @FXML
    private Label ageResults;

    @FXML
    private Label cardNumLbl;

    @FXML
    private Button checkoutsBtn;

    @FXML
    private Label dobLbl;

    @FXML
    private Label dobResults;

    @FXML
    private Button editBtn;

    @FXML
    private Label libraryCardNumResults;

    @FXML
    private Line menuLn;

    @FXML
    private Label nameLbl;

    @FXML
    private Label nameResults;

    @FXML
    private AnchorPane searchPersonAnchorPane;

    @FXML
    private RadioButton searchPersonByEmailRadioButton;

    @FXML
    private RadioButton searchPersonByNameRadioButton;

    @FXML
    private RadioButton searchPersonByPhone;

    @FXML
    private Button searchPersonExitButton;

    @FXML
    private Button searchPersonSearchButton;

    @FXML
    private TextField searchPersonTextField;

    @FXML
    private Button viewBillsBtn;




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
    private Button searchItemExitButton;

    @FXML
    private Button searchItemSearchButton;


    @FXML
    private RadioButton searchItemByTitleRadioButton;

    @FXML
    private RadioButton searchItemByIDRadioButton;

    @FXML
    private Label resultsLbl;
    @FXML
    private Label accountLbl;

    @FXML
    private TextField searchItemTextField;

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
            ItemList test = new ItemList();
            test.searchBook("Grand Central Publishing");
            test.searchMovie("Grand Central Publishing");
            test.searchAudio("Grand Central Publishing");
        });

    }


    @FXML
    public void handleSearchPersonClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonSearchButton.setOnMouseClicked(mouseEvent ->
        {
            if(searchPersonByNameRadioButton.isSelected() == false && searchPersonByEmailRadioButton.isSelected() == false && searchPersonByPhone.isSelected() == false){Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                loginFailed.setHeaderText("Select a Search Field");
                loginFailed.setContentText("Please select one of the search options before clicking search.");
                loginFailed.showAndWait();

            }
            PatronList pList = new PatronList();
            StaffList sList = new StaffList();
            if(searchPersonByEmailRadioButton.isSelected() == true){

            if(pList.foundEmail(searchPersonTextField.getText()) == true){
                System.out.println("Person Found");
              resultsLbl.setText(pList.searchEmail(searchPersonTextField.getText()));

            }
                if(sList.foundEmail(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    resultsLbl.setText(sList.searchEmail(searchPersonTextField.getText()));

                }if(pList.foundEmail(searchPersonTextField.getText()) == false && sList.foundEmail(searchPersonTextField.getText()) == false)
                {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("No Account Found");
                    loginFailed.setContentText("No patron or staff found. Try a different search criteria or create new account.");
                    loginFailed.showAndWait();
                }
            }{

        }
            if(searchPersonByNameRadioButton.isSelected() == true){
                if(pList.foundCard(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    resultsLbl.setText(pList.searchCard(searchPersonTextField.getText()));

                }
                if(sList.foundUserID(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    resultsLbl.setText(sList.searchUserID(searchPersonTextField.getText()));

                }if(pList.foundCard(searchPersonTextField.getText()) == false && sList.foundUserID(searchPersonTextField.getText()) == false)
                {Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("No Account Found");
                    loginFailed.setContentText("No patron or staff found. Try a different search criteria or create new account.");
                    loginFailed.showAndWait();}
            }{

        }
            if(searchPersonByPhone.isSelected() == true){
                if(pList.foundPhone(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    resultsLbl.setText(pList.searchPhone(searchPersonTextField.getText()));

                }
                if(sList.foundPhone(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    resultsLbl.setText(sList.searchPhone(searchPersonTextField.getText()));

                }
                if(pList.foundPhone(searchPersonTextField.getText()) == false && sList.foundPhone(searchPersonTextField.getText()) == false)
                {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("No Account Found");
                    loginFailed.setContentText("No patron or staff found. Try a different search criteria or create new account.");
                    loginFailed.showAndWait();
                }}

        });

    }

    @FXML
    public void handleSearchItemClick(javafx.event.ActionEvent actionEvent)
    {
        searchItemSearchButton.setOnMouseClicked(mouseEvent ->
        {
            if(itemResultsLbl.getText() != null){
                itemResultsLbl.setText("");
            }
            if(searchItemByIDRadioButton.isSelected() == false && searchItemByTitleRadioButton.isSelected() == false){Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                loginFailed.setHeaderText("Select a Search Field");
                loginFailed.setContentText("Please select one of the search options before clicking search.");
                loginFailed.showAndWait();

            }
            ItemList iList = new ItemList();
            if(searchItemByIDRadioButton.isSelected() == true){

                if(iList.searchBook(searchItemTextField.getText()) == true || iList.searchMovie(searchItemTextField.getText()) == true || iList.searchAudio(searchItemTextField.getText()) == true){
                    System.out.println("Item Found");
                    if (iList.bookReturn(searchItemTextField.getText()) != null)
                    {
                        itemResultsLbl.setText(iList.bookReturn(searchItemTextField.getText()));
                    }
                    if (iList.movieReturn(searchItemTextField.getText()) != null)
                    {
                        itemResultsLbl.setText(iList.movieReturn(searchItemTextField.getText()));
                    }
                    if (iList.audioReturn(searchItemTextField.getText()) != null)
                    {
                        itemResultsLbl.setText(iList.audioReturn(searchItemTextField.getText()));
                    }
                }
                else
                {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("No Item Found");
                    loginFailed.setContentText("No Item found. Try a different search criteria or add item to inventory.");
                    loginFailed.showAndWait();
                }
            }
            if(searchItemByTitleRadioButton.isSelected() == true){


                if(iList.searchBook(searchItemTextField.getText()) == true || iList.searchMovie(searchItemTextField.getText()) == true || iList.searchAudio(searchItemTextField.getText()) == true){
                    System.out.println("Item Found");
                    if (iList.bookReturn(searchItemTextField.getText()) != null)
                    {
                        itemResultsLbl.setText(iList.bookReturn(searchItemTextField.getText()));
                    }
                    if (iList.movieReturn(searchItemTextField.getText()) != null)
                    {
                        itemResultsLbl.setText(iList.movieReturn(searchItemTextField.getText()));
                    }
                    if (iList.audioReturn(searchItemTextField.getText()) != null)
                    {
                        itemResultsLbl.setText(iList.audioReturn(searchItemTextField.getText()));
                    }
                }
                else
                {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("No Item Found");
                    loginFailed.setContentText("No Item found. Try a different search criteria or add item to inventory.");
                    loginFailed.showAndWait();
                }
            }

        });

    }

    @FXML
    public void handleSearchPersonNameRadioClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonByNameRadioButton.setOnMouseClicked(mouseEvent ->
        {
            searchPersonTextField.clear();
            searchPersonTextField.setPromptText("John Doe");
            searchPersonByPhone.setSelected(false);
            searchPersonByEmailRadioButton.setSelected(false);
            searchPersonType = "By Name";
            System.out.println("Selected search person by name.");
        });
    }

    @FXML
    public void handleSearchPersonPhoneRadioClick(javafx.event.ActionEvent actionEvent)
    {
        searchPersonByPhone.setOnMouseClicked(mouseEvent ->
        {
            searchPersonTextField.clear();
            searchPersonTextField.setPromptText("0-000-000-0000");
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
            searchPersonTextField.clear();
            searchPersonTextField.setPromptText("example@gmail.com or example@wclibrary.com");
            searchPersonByNameRadioButton.setSelected(false);
            searchPersonByPhone.setSelected(false);
            searchPersonType = "By Email";
            System.out.println("Selected search person by email.");
        });
    }

    @FXML
    public void handleSearchItemByTitleRadioButtonClick(javafx.event.ActionEvent actionEvent)
    {
        searchItemByTitleRadioButton.setOnMouseClicked(mouseEvent ->
        {
            itemResultsLbl.setText("");
            searchItemTextField.clear();
            searchItemTextField.setPromptText("Raiders of the Lost Ark");
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
            itemResultsLbl.setText("");
            searchItemTextField.clear();
            searchItemTextField.setPromptText("1234567");
            searchItemByTitleRadioButton.setSelected(false);
            searchItemType = "By ID";
            System.out.println("Selected search item by ID number.");
        });
    }
}
