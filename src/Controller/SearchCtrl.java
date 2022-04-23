package Controller;

import Model.*;
import View.FxLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.function.UnaryOperator;


public class SearchCtrl {

    @FXML
    private TableColumn<Item, String> DescripCol;

    @FXML
    private TableColumn<Item, NormalDate> dateCol;
    @FXML
    private Button itemDetailsBtn;
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
        personContenTbl.setTableMenuButtonVisible(false);
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

                nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));


                people.addAll(pList.searchEmail(searchPersonTextField.getText()));
                personContenTbl.setDisable(false);
                personContenTbl.setItems(people);
                searchPersonTextField.setStyle("-fx-background-color: white");



            }
                if(sList.foundEmail(searchPersonTextField.getText()) == true){
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
personContenTbl.setDisable(false);
                    people.addAll(sList.searchEmail(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);
                    searchPersonTextField.setStyle("-fx-background-color: white");

                }if(pList.foundEmail(searchPersonTextField.getText()) == false && sList.foundEmail(searchPersonTextField.getText()) == false)
                {
                    searchPersonTextField.setStyle("-fx-background-color: red");
                }
            }{

        }
            if(searchPersonByNameRadioButton.isSelected() == true){
                ObservableList<Person> people = FXCollections.observableArrayList();
                if(pList.foundCard(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    personContenTbl.setDisable(false);
                    people.addAll(pList.searchCard(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);
                    searchPersonTextField.setStyle("-fx-background-color: white");
                }
                if(sList.foundUserID(searchPersonTextField.getText()) == true){
                    System.out.println("Person Found");
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    personContenTbl.setDisable(false);
                    people.addAll(sList.searchUserID(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);
                    searchPersonTextField.setStyle("-fx-background-color: white");

                }if(pList.foundCard(searchPersonTextField.getText()) == false && sList.foundUserID(searchPersonTextField.getText()) == false)
                {searchPersonTextField.setStyle("-fx-background-color: red");}
            }{

        }
            if(searchPersonByPhone.isSelected() == true){
                ObservableList<Person> people = FXCollections.observableArrayList();
                if(pList.foundPhone(searchPersonTextField.getText()) == true){

                    searchPersonTextField.setStyle("-fx-background-color: white");
                    System.out.println("Person Found");
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

                    personContenTbl.setDisable(false);
                        people.addAll(pList.searchPhone(searchPersonTextField.getText()));
                        personContenTbl.setItems(people);
                    }


                if(sList.foundPhone(searchPersonTextField.getText()) == true){
                    searchPersonTextField.setStyle("-fx-background-color: white");
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
                    dobCol.setCellValueFactory(new PropertyValueFactory<Person, NormalDate>("dateofBirth"));
                    addCol.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<Person,PhoneNumber>("phoneNumber"));
                    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
                    personContenTbl.setDisable(false);
                    people.addAll(sList.searchPhone(searchPersonTextField.getText()));
                    personContenTbl.setItems(people);

                }
                if(pList.foundPhone(searchPersonTextField.getText()) == false && sList.foundPhone(searchPersonTextField.getText()) == false)
                {
                    searchPersonTextField.setStyle("-fx-background-color: red");
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
                ObservableList<Item> items = FXCollections.observableArrayList();
                if(iList.searchBook(searchItemTextField.getText()) == true || iList.searchMovie(searchItemTextField.getText()) == true || iList.searchAudio(searchItemTextField.getText()) == true){
                    System.out.println("Item Found");
                    searchItemTextField.setStyle("-fx-background-color: white");
                    if (iList.bookReturn(searchItemTextField.getText()) != null)
                    {
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        itemTbl.setDisable(false);
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
                        itemTbl.setDisable(false);
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
                        itemTbl.setDisable(false);
                        items.addAll(iList.audioReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
                    }
                }
                else
                {
                    searchItemTextField.setStyle("-fx-background-color: red");
                            itemTbl.setDisable(true);
                }
            }
            if(searchItemByTitleRadioButton.isSelected() == true){


                if(iList.searchBook(searchItemTextField.getText()) == true || iList.searchMovie(searchItemTextField.getText()) == true || iList.searchAudio(searchItemTextField.getText()) == true){
                    System.out.println("Item Found");
                    ObservableList<Item> items = FXCollections.observableArrayList();
                    searchItemTextField.setStyle("-fx-background-color: white");
                    if (iList.bookReturn(searchItemTextField.getText()) != null)
                    {
                        idCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
                        titleCol.setCellValueFactory(new PropertyValueFactory<Item,String>("title"));
                        yearCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("yearPublished"));
                        dateCol.setCellValueFactory(new PropertyValueFactory<Item, NormalDate>("datePublished"));
                        DescripCol.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
                        statusCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemStatus"));
                        itemTbl.setDisable(false);
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
                        itemTbl.setDisable(false);
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
                        itemTbl.setDisable(false);
                        items.addAll(iList.audioReturn(searchItemTextField.getText()));
                        itemTbl.setItems(items);
                    }
                }
                else
                {
                 searchItemTextField.setStyle("-fx-background-color: red");
                    itemTbl.setDisable(true);
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


    public void underDevRemoveitem(javafx.event.ActionEvent actionEvent)
    {
        removeItemBtn.setOnMouseClicked(mouseEvent ->
        {
            AddOrRemoveItemCtrl remove = new AddOrRemoveItemCtrl();
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



    public void viewtest(){


searchPersonAnchorPane.setOnMouseMoved(mouseEvent -> {
    if(searchPersonByNameRadioButton.isSelected() == true|| searchPersonByEmailRadioButton.isSelected() == true||searchPersonByPhone.isSelected() == true){
    if(searchPersonByNameRadioButton.isSelected()){
        searchPersonTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[0-9a-zA-Z]*$") && change.getControlNewText().length() <= 9)
                {
                    return change;
                }
                return null;
            }
        }));
        searchPersonTextField.setDisable(false);
    }
    if(searchPersonByPhone.isSelected()){
        searchPersonTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[0-9-]*$") && change.getControlNewText().length() <= 15)
                {
                    return change;
                }
                return null;
            }
        }));
        searchPersonTextField.setDisable(false);
    }
    if(searchPersonByEmailRadioButton.isSelected()){
        searchPersonTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[0-9a-zA-Z'@#!%^&*?'.$]*$") && change.getControlNewText().length() <= 30)
                {
                    return change;
                }
                return null;
            }
        }));
        searchPersonTextField.setDisable(false);
    }}else {searchPersonTextField.setDisable(true);}

});

        searchPersonByPhone.setOnMouseReleased(mouseEvent -> {
            if(searchPersonByNameRadioButton.isSelected() == true|| searchPersonByEmailRadioButton.isSelected() == true||searchPersonByPhone.isSelected() == true){
                if(searchPersonByNameRadioButton.isSelected()){
                    searchPersonTextField.setDisable(false);
                }
                if(searchPersonByPhone.isSelected()){
                    searchPersonTextField.setDisable(false);
                }
                if(searchPersonByEmailRadioButton.isSelected()){
                    searchPersonTextField.setDisable(false);
                }}else {searchPersonTextField.setDisable(true);}

        });

        searchPersonByNameRadioButton.setOnMouseReleased(mouseEvent -> {
            if(searchPersonByNameRadioButton.isSelected() == true|| searchPersonByEmailRadioButton.isSelected() == true||searchPersonByPhone.isSelected() == true){
                if(searchPersonByNameRadioButton.isSelected()){
                    searchPersonTextField.setDisable(false);
                }
                if(searchPersonByPhone.isSelected()){
                    searchPersonTextField.setDisable(false);
                }
                if(searchPersonByEmailRadioButton.isSelected()){
                    searchPersonTextField.setDisable(false);
                }}else {searchPersonTextField.setDisable(true);}

        });
        searchPersonByEmailRadioButton.setOnMouseReleased(mouseEvent -> {
            if(searchPersonByNameRadioButton.isSelected() == true|| searchPersonByEmailRadioButton.isSelected() == true||searchPersonByPhone.isSelected() == true){
                if(searchPersonByNameRadioButton.isSelected()){
                    searchPersonTextField.setDisable(false);
                }
                if(searchPersonByPhone.isSelected()){
                    searchPersonTextField.setDisable(false);
                }
                if(searchPersonByEmailRadioButton.isSelected()){
                    searchPersonTextField.setDisable(false);
                }}else {searchPersonTextField.setDisable(true);}

        });
        personContenTbl.setOnMouseClicked(mouseEvent -> {
            try{
                if(!personContenTbl.getSelectionModel().getSelectedItem().equals(null)){
                    viewBillsBtn.setDisable(false);
                    checkoutsBtn.setDisable(false);
                }else {viewBillsBtn.setDisable(true);
                    checkoutsBtn.setDisable(true);}

            } catch (Exception e)
            {
                Alert indev = new Alert(Alert.AlertType.ERROR);
                indev.setHeaderText("Select a row");
                indev.setContentText("Please select a row.");
                indev.showAndWait();

            }

        });

    searchPersonTextField.setOnKeyPressed(KeyEvent->{
        if (!searchPersonTextField.getText().isEmpty()){
            searchPersonSearchButton.setDisable(false);

        }else {
            searchPersonSearchButton.setDisable(true);}

    });
        searchPersonTextField.setOnKeyReleased(KeyEvent->{
            if (!searchPersonTextField.getText().isEmpty()){
                searchPersonSearchButton.setDisable(false);

            }else {
                searchPersonSearchButton.setDisable(true);}

        });}

    public void viewSelected(){


        viewBillsBtn.setOnMouseClicked(mouseEvent -> {
         {
            personContenTbl.getSelectionModel().getSelectedItem();
            Person test = personContenTbl.getSelectionModel().getSelectedItem();
            Alert indev = new Alert(Alert.AlertType.INFORMATION);
            indev.setHeaderText("Person Details");
            indev.setContentText(test.toString());
            indev.showAndWait();}
        });

    }
    public void viewSelectedCheckout(){
PatronList patronList = new PatronList();
        checkoutsBtn.setOnMouseClicked(mouseEvent -> {
            {
                AllCheckoutLists all = new AllCheckoutLists();
                personContenTbl.getSelectionModel().getSelectedItem();
                Person test = personContenTbl.getSelectionModel().getSelectedItem();

if (patronList.verifyEmail(test.getEmail())){
                Alert indev = new Alert(Alert.AlertType.INFORMATION);
                indev.setHeaderText("Checkouts");
                indev.setContentText(all.searchCheckouts(((Patron)test).getPatronCardNum()));
                indev.showAndWait();}
else {
    Alert indev = new Alert(Alert.AlertType.ERROR);
    indev.setHeaderText("Not a Patron");
    indev.setContentText("Selected person is not a Patron.");
    indev.showAndWait();
}

            }
        });

    }

    public void viewSelectedItem(){
      ItemList item = new ItemList();
        itemDetailsBtn.setOnMouseClicked(mouseEvent -> {
            {
                itemTbl.getSelectionModel().getSelectedItem();
                Item test = itemTbl.getSelectionModel().getSelectedItem();
                Alert indev = new Alert(Alert.AlertType.INFORMATION);
                indev.setHeaderText("Item Details");
                indev.setContentText("Item ID: "+ test.getItemID() +"\n"+"Title: "+
                        test.getTitle() + '\n' +
                        "yearPublished " + test.getYearPublished()+"\n" +
                        "datePublished: " + test.getDatePublished() +"\n"+"\n"+
                        "description: " + test.getDescription() + '\n' +"\n"+
                        "itemStatus: " + test.getItemStatus() + '\n');
                indev.showAndWait();

            }
        });

    }

    public void viewtestItem(){
       searchItemAnchorPane.setOnMouseMoved(mouseEvent -> {
            if(searchItemByIDRadioButton.isSelected() == true|| searchItemByTitleRadioButton.isSelected() == true){
                if(searchItemByTitleRadioButton.isSelected()){
                    searchItemTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
                    {
                        @Override
                        public TextFormatter.Change apply(TextFormatter.Change change)
                        {
                            String value = change.getText();
                            if (change.getText().matches("[/0-9a-zA-Z' !#%^&*()+=@'.$?:;]*") && change.getControlNewText().length() <= 30)
                            {
                                return change;
                            }
                            return null;
                        }
                    }));
                    searchItemTextField.setDisable(false);
                }
                if(searchItemByIDRadioButton.isSelected()){
                    searchItemTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
                    {
                        @Override
                        public TextFormatter.Change apply(TextFormatter.Change change)
                        {
                            String value = change.getText();
                            if (change.getText().matches("^[0-9]*$") && change.getControlNewText().length() <= 10)
                            {
                                return change;
                            }
                            return null;
                        }
                    }));
                    searchItemTextField.setDisable(false);
                }
                }else {searchItemTextField.setDisable(true);}

        });



        searchItemByIDRadioButton.setOnMouseReleased(mouseEvent -> {
            if(searchItemByIDRadioButton.isSelected() == true|| searchItemByTitleRadioButton.isSelected() == true){
                if(searchItemByTitleRadioButton.isSelected()){
                    searchItemTextField.setDisable(false);
                }
                if(searchItemByIDRadioButton.isSelected()){
                    searchItemTextField.setDisable(false);
                }
            }else {searchItemTextField.setDisable(true);}

        });

        searchItemByTitleRadioButton.setOnMouseReleased(mouseEvent -> {
            if(searchItemByIDRadioButton.isSelected() == true|| searchItemByTitleRadioButton.isSelected() == true){
                if(searchItemByTitleRadioButton.isSelected()){
                    searchItemTextField.setDisable(false);
                }
                if(searchItemByIDRadioButton.isSelected()){
                    searchItemTextField.setDisable(false);
                }
            }else {searchItemTextField.setDisable(true);}

        });

        itemTbl.setOnMouseClicked(mouseEvent -> {
            try{
                if(!itemTbl.getSelectionModel().getSelectedItem().equals(null)){
                    removeItemBtn.setDisable(false);
                    itemDetailsBtn.setDisable(false);

                }else {
                    removeItemBtn.setDisable(true);
                    itemDetailsBtn.setDisable(true);

            }} catch (Exception e)
            {
                Alert indev = new Alert(Alert.AlertType.ERROR);
                indev.setHeaderText("Select a row");
                indev.setContentText("Please select a row.");
                indev.showAndWait();

            }

        });

        searchItemTextField.setOnKeyPressed(KeyEvent->{
            if (!searchItemTextField.getText().isEmpty()){
                searchItemSearchButton.setDisable(false);

            }else {
                searchItemSearchButton.setDisable(true);}

        });
        searchItemTextField.setOnKeyReleased(KeyEvent->{
            if (!searchItemTextField.getText().isEmpty()){
                searchItemSearchButton.setDisable(false);

            }else {
                searchItemSearchButton.setDisable(true);}

        });}
}
