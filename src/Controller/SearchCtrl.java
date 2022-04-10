package Controller;

import Model.*;
import View.FxLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class SearchCtrl {

    @FXML
    private TableColumn<Item, String> DescripCol;

    @FXML
    private TableColumn<Item, NormalDate> dateCol;

    @FXML
    private Button editItemBtn;

    @FXML
    private TableColumn<Item, Integer> idCol;

    @FXML
    private TableView<Item> itemTbl;

    @FXML
    private Button removeItemBtn;

    @FXML
    private AnchorPane searchItemAnchorPane;

    @FXML
    private RadioButton searchItemByIDRadioButton;

    @FXML
    private RadioButton searchItemByTitleRadioButton;

    @FXML
    private Button searchItemExitButton;

    @FXML
    private Button searchItemSearchButton;

    @FXML
    private TextField searchItemTextField;

    @FXML
    private TableColumn<Item, String> statusCol;

    @FXML
    private TableColumn<Item, String> titleCol;

    @FXML
    private TableColumn<Item, Integer> yearCol;
    @FXML
    private TableColumn<Person, Address> addCol;

    @FXML
    private Button checkoutsBtn;

    @FXML
    private TableColumn<Person, NormalDate> dobCol;

    @FXML
    private Button editBtn;

    @FXML
    private TableColumn<Person, String> emailCol;

    @FXML
    private Line menuLn;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableView<Person> personContenTbl;

    @FXML
    private TableColumn<Person, PhoneNumber> phoneCol;

    @FXML
    private Label itemResultsLbl;
    @FXML
    private Label ageLbl;

    @FXML
    private Label ageResults;

    @FXML
    private Label cardNumLbl;



    @FXML
    private Label dobLbl;

    @FXML
    private Label dobResults;



    @FXML
    private Label libraryCardNumResults;



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
    private Label resultsLbl;
    @FXML
    private Label accountLbl;


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
                loginFailed.setContentText("Please select one of the search options before clicking search. ajones or tsmith for ID");
                loginFailed.showAndWait();

            }
            PatronList pList = new PatronList();
            StaffList sList = new StaffList();
            if(searchPersonByEmailRadioButton.isSelected() == true){
                ObservableList<Person> people = FXCollections.observableArrayList();

            if(pList.foundEmail(searchPersonTextField.getText()) == true){
                System.out.println("Person Found");
             // resultsLbl.setText(pList.searchEmail(searchPersonTextField.getText()));
                nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));


                people.addAll(pList.searchEmail(searchPersonTextField.getText()));

                personContenTbl.setItems(people);
            }
                if(sList.foundEmail(searchPersonTextField.getText()) == true){
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

                    people.addAll(sList.searchEmail(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);

                }if(pList.foundEmail(searchPersonTextField.getText()) == false && sList.foundEmail(searchPersonTextField.getText()) == false)
                {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("No Account Found");
                    loginFailed.setContentText("No patron or staff found. Try a different search criteria or create new account.try ajones or tsmith for ID");
                    loginFailed.showAndWait();
                }
            }{

        }
            if(searchPersonByNameRadioButton.isSelected() == true){
                if(pList.foundCard(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    ObservableList<Person> people = FXCollections.observableArrayList();
                    people.add(pList.searchCard(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);
                }
                if(sList.foundUserID(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    ObservableList<Person> people = FXCollections.observableArrayList();
                    people.add(sList.searchUserID(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);

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
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    ObservableList<Person> people = FXCollections.observableArrayList();
                    for (int i = 0; i <= people.size()-1; i++)
                    {
                        people.add(pList.searchPhone(searchPersonTextField.getText()));
                        personContenTbl.setItems(people);
                    }

                }
                if(sList.foundPhone(searchPersonTextField.getText()) == true){
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    ObservableList<Person> people = FXCollections.observableArrayList();
                    people.add(sList.searchPhone(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);

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
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        ObservableList<Item> items = FXCollections.observableArrayList();
                        items.addAll(iList.bookReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
                    }

                    if (iList.movieReturn(searchItemTextField.getText()) != null)
                    {
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        ObservableList<Item> items = FXCollections.observableArrayList();
                        items.addAll(iList.movieReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
                    }
                    if (iList.audioReturn(searchItemTextField.getText()) != null)
                    {
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        ObservableList<Item> items = FXCollections.observableArrayList();
                        items.addAll(iList.audioReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
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
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        ObservableList<Item> items = FXCollections.observableArrayList();
                        items.addAll(iList.bookReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
                    }
                    if (iList.movieReturn(searchItemTextField.getText()) != null)
                    {
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        ObservableList<Item> items = FXCollections.observableArrayList();
                        items.addAll(iList.movieReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
                    }
                    if (iList.audioReturn(searchItemTextField.getText()) != null)
                    {
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        ObservableList<Item> items = FXCollections.observableArrayList();
                        items.addAll(iList.audioReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
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

            searchItemTextField.clear();
            searchItemTextField.setPromptText("1234567");
            searchItemByTitleRadioButton.setSelected(false);
            searchItemType = "By ID";
            System.out.println("Selected search item by ID number.");
        });
    }
    @FXML
    public void viewDetailsButton(javafx.event.ActionEvent actionEvent)
    {
editBtn.setOnMouseClicked(mouseEvent -> {
    System.out.println(personContenTbl.getSelectionModel().selectedItemProperty().get());



});

    }
    public void underDevEdit(javafx.event.ActionEvent actionEvent)
    {
        editBtn.setOnMouseClicked(mouseEvent ->
        {
            Alert indev = new Alert(Alert.AlertType.ERROR);
            indev.setHeaderText("Under Development");
            indev.setContentText("Will be finished in sprint 5");
            indev.showAndWait();
        });
    }
    public void underDevEditItem(javafx.event.ActionEvent actionEvent)
    {
        editItemBtn.setOnMouseClicked(mouseEvent ->
        {
            Alert indev = new Alert(Alert.AlertType.ERROR);
            indev.setHeaderText("Under Development");
            indev.setContentText("Will be finished in sprint 5");
            indev.showAndWait();
        });
    }
    public void underDevRemoveitem(javafx.event.ActionEvent actionEvent)
    {
        removeItemBtn.setOnMouseClicked(mouseEvent ->
        {
            Alert indev = new Alert(Alert.AlertType.ERROR);
            indev.setHeaderText("Under Development");
            indev.setContentText("Will be finished in sprint 5");
            indev.showAndWait();
        });
    }
    public void underDevBills(javafx.event.ActionEvent actionEvent)
    {
        viewBillsBtn.setOnMouseClicked(mouseEvent ->
        {
            Alert indev = new Alert(Alert.AlertType.ERROR);
            indev.setHeaderText("Under Development");
            indev.setContentText("Will be finished in sprint 5");
            indev.showAndWait();
        });
    }
    public void underDevCheckouts(javafx.event.ActionEvent actionEvent)
    {
        checkoutsBtn.setOnMouseClicked(mouseEvent ->
        {
            Alert indev = new Alert(Alert.AlertType.ERROR);
            indev.setHeaderText("Under Development");
            indev.setContentText("Will be finished in sprint 5");
            indev.showAndWait();
        });
    }
}
