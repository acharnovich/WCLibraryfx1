package Controller;

import Model.*;
import View.FxLoader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AccountCtrl
{

    @FXML
    private RadioButton patronRBtn;

    @FXML
    private RadioButton staffRBtn;


    @FXML
    private ChoiceBox<String> positionBx;


    @FXML
    private ChoiceBox<String> statusBx;

    @FXML
    private Button testbtn;

    @FXML
    private AnchorPane areePane;


    @FXML
    private BorderPane radioBPane;


    @FXML
    private AnchorPane patronFillable;

    @FXML
    private Line rdLine;

    @FXML
    private Label addressLbl;

    @FXML
    private Label aptLbl;

    @FXML
    private TextField aptTxt;

    @FXML
    private Label birthLbl;

    @FXML
    private TextField yearTxt;
    @FXML
    private TextField monthTxt;
    @FXML
    private TextField dayTxt;

    @FXML
    private Label cardLbl;

    @FXML
    private TextField cardTxt;

    @FXML
    private Label cityLbl;

    @FXML
    private TextField cityTxt;

    @FXML
    private Button createAccountBtn;

    @FXML
    private TextField emailText;


    @FXML
    private Label nameLbl;

    @FXML
    private TextField nameTxt;

    @FXML
    private Label phoneNumLbl;

    @FXML
    private TextField countryTxt;
    @FXML
    private TextField localTxt;
    @FXML
    private TextField lastFourTxt;
    @FXML
    private TextField areaTxt;


    @FXML
    private Button secAddressBtn;

    @FXML
    private Button secondAddressBtn;

    @FXML
    private Label secondAddressLbl;

    @FXML
    private Label stateLbl;

    @FXML
    private TextField stateTxt;

    @FXML
    private Label streetNameLbl;

    @FXML
    private TextField streetNameTxt;

    @FXML
    private Label streetNumLbl;

    @FXML
    private TextField streetNumTxt;

    @FXML
    private Label typeLBL;

    @FXML
    private TextField typeTxt;

    @FXML
    private Label zipLbl;

    @FXML
    private TextField zipTxt;

    @FXML
    private Label addressLblStaff;

    @FXML
    private Label aptLblStaff;

    @FXML
    private TextField aptTxtStaff;

    @FXML
    private TextField areaTxtStaff;

    @FXML
    private Label birthLblStaff;

    @FXML
    private Label cityLblStaff;

    @FXML
    private TextField cityTxtStaff;

    @FXML
    private TextField countryTxtStaff;

    @FXML
    private Button createAccountBtnStaff;

    @FXML
    private TextField dayTxtStaff;

    @FXML
    private Label emailLblStaff;

    @FXML
    private TextField emailTextStaff;


    @FXML
    private TextField lastFourTxtStaf;

    @FXML
    private TextField localTxtStaff;

    @FXML
    private TextField monthTxtStaff;

    @FXML
    private Label nameLblStaff;

    @FXML
    private TextField nameTxtStaff;

    @FXML
    private AnchorPane staffFillable;

    @FXML
    private Label phoneNumLblStaff;

    @FXML
    private Label pinLbl;

    @FXML
    private TextField pinTxt;

    @FXML
    private Label positionLbl;

    @FXML
    private TextField positionTxt;

    @FXML
    private Button secAddressBtnStaff;

    @FXML
    private Button secondAddressBtnStaff;

    @FXML
    private Label secondAddressLblStaff;

    @FXML
    private DatePicker dateTest;

    @FXML
    private Label staffIDLbl;

    @FXML
    private TextField staffIDTxt;

    @FXML
    private TextField startDayTxt;

    @FXML
    private Label startLbl;

    @FXML
    private TextField startMonthTxt;

    @FXML
    private TextField startYearTxt;

    @FXML
    private Label stateLblStaff;

    @FXML
    private TextField stateTxtStaff;

    @FXML
    private Label statusLbl;

    @FXML
    private TextField statusTxt;

    @FXML
    private Label streetNameLblStaff;

    @FXML
    private TextField streetNameTxtStaff;

    @FXML
    private Label streetNumLblStaff;

    @FXML
    private TextField streetNumTxtStaff;

    @FXML
    private Label typeLBLStaff;

    @FXML
    private TextField typeTxtStaff;

    @FXML
    private TextField yearTxtStaff;

    @FXML
    private Label zipLblStaff;

    @FXML
    private TextField zipTxtStaff;

    @FXML
    private TextField areaTxt2;

    @FXML
    private TextField countryTxt2;

    @FXML
    private TextField lastFourTxt2;

    @FXML
    private TextField localTxt2;


    @FXML
    private Button verifyBtn;

    @FXML
    private Label verifyLbl;

    @FXML
    private AnchorPane verifyPane;

    @FXML
    private TextField verifyTxt;

    PatronList patronList;
    StaffList staffList;

    public AccountCtrl()
    {
        positionBx = new ChoiceBox<>();
        statusBx = new ChoiceBox<>();


    }

    @FXML
    public void patronCreateAccount(javafx.event.ActionEvent actionEvent)
    {
        patronRBtn.setOnMouseClicked(mouseEvent ->
        {
            staffRBtn.setSelected(false);
            FxLoader object = new FxLoader();
            Pane content = object.getPage("NewPatronUI");
            this.radioBPane.setRight(content);


        });

    }

    @FXML
    public void verifyEmail()
    {
        verifyBtn.setOnMouseClicked(mouseEvent ->
        {
            patronList = new PatronList();
            if (patronList.verifyEmail(emailText.getText()) == false)
            {
                emailText.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");

            } else
            {
                emailText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            }

        });


    }

    @FXML
    public void patronAddPhoneNumber(javafx.event.ActionEvent actionEvent)
    {

        secAddressBtn.setOnMouseClicked(mouseEvent ->
        {
            countryTxt2.setVisible(true);
            localTxt2.setVisible(true);
            areaTxt2.setVisible(true);
            lastFourTxt2.setVisible(true);
        });
    }



    @FXML
    public void enablePatron()
    {
        NormalDate temp = new NormalDate(yearTxt.getText(),monthTxt.getText(),dayTxt.getText());

        boolean disabled = (nameTxt.getText().isEmpty() || yearTxt.getText().isEmpty() || monthTxt.getText().isEmpty() && dayTxt.getText().isEmpty() || streetNumTxt.getText().isEmpty() || streetNameTxt.getText().isEmpty() || typeTxt.getText().isEmpty() && cityTxt.getText().isEmpty() || stateTxt.getText().isEmpty() || zipTxt.getText().isEmpty() || countryTxt.getText().isEmpty() || areaTxt.getText().isEmpty() && areaTxt.getText().length() < 3 || localTxt.getText().isEmpty() || lastFourTxt.getText().isEmpty() || emailText.getText().isEmpty() || cardTxt.getText().isEmpty());
        patronFillable.setOnKeyPressed(keyEvent ->
        {
           

            if (disabled == false)
            {
                createAccountBtn.setDisable(false);
            }else {createAccountBtn.setDisable(true);}
        });

        yearTxt.setOnKeyReleased(keyEvent->{
            if(new NormalDate().verifyDate(Integer.valueOf(yearTxt.getText()), Integer.valueOf(monthTxt.getText()),Integer.valueOf(dayTxt.getText())) == true){
                yearTxt.setStyle("-fx-text-fill: orange;");
        }
        else {
                yearTxt.setStyle("-fx-text-fill: black;");}

        });


    yearTxt.setOnKeyReleased(mouseEvent -> {

        if(yearTxt.getText().length() < 4){
            yearTxt.setStyle("-fx-text-fill: red;");
        }else {yearTxt.setStyle("-fx-text-fill: black;");}

    });
    monthTxt.setOnKeyReleased(mouseEvent->{if(monthTxt.getText().length() < 2){
        monthTxt.setStyle("-fx-text-fill: red;");
    }else {monthTxt.setStyle("-fx-text-fill: black;");}});

        dayTxt.setOnKeyReleased(mouseEvent->{if(dayTxt.getText().length() < 2){
            dayTxt.setStyle("-fx-text-fill: red;");
        }else {dayTxt.setStyle("-fx-text-fill: black;");}});

        patronFillable.setOnMouseMoved(mouseEvent ->
        {
            if (disabled == false)
            {
                createAccountBtn.setDisable(false);
            }else {createAccountBtn.setDisable(true);}
        });

        patronFillable.setOnMouseExited(mouseEvent ->
        {
            if (disabled == false)
            {
                createAccountBtn.setDisable(false);
            }else {createAccountBtn.setDisable(true);}
        });
        patronFillable.setOnMouseClicked(mouseEvent ->
        {
            if (disabled == false)
            {
                createAccountBtn.setDisable(false);
            }else {createAccountBtn.setDisable(true);}
        });



        //yearTxt.textProperty().addListener(new ChangeListener<String>()
       // {
          //  @Override
           // public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
           // {
           //     if (!t1.matches("\\d*")) {
             //       yearTxt.setText(t1.replaceAll("[^\\d]", ""));
            //    }
           // }
      //  });
        monthTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*")) {
                    monthTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
        dayTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*")) {
                    dayTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
        countryTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*")) {
                    countryTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        yearTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 4) {
                    return change;}

                return null;
            }
        }));

        monthTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 2) {
                    return change;}
                return null;
            }
        }));

        dayTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 2) {
                    return change;}
                return null;
            }
        }));

        cardTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 8) {
                    return change;}
                return null;
            }
        }));

        streetNumTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 6) {
                    return change;}
                return null;
            }
        }));

        zipTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 5) {
                    return change;}
                return null;
            }
        }));

        stateTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z]*$") && change.getControlNewText().length() <= 2) {
                    return change;}
                return null;
            }
        }));

        lastFourTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 4) {
                    return change;}
                return null;
            }
        }));

        countryTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 1) {
                    return change;}
                return null;
            }
        }));

        localTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 3) {
                    return change;}
                return null;
            }
        }));
        areaTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 3) {

                    return change;}
                return null;
            }
        }));

        areaTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*")) {
                    areaTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });


        lastFourTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*")) {
                    lastFourTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        localTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*")) {
                    localTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });


    }

    @FXML
    public void createPatronAccount(javafx.event.ActionEvent actionEvent)
    {
        NormalDate temp = new NormalDate(yearTxt.getText(),monthTxt.getText(),dayTxt.getText());



        patronList = new PatronList();
        createAccountBtn.setOnMouseClicked(mouseEvent ->
        {
            if(temp.verifyDate(Integer.valueOf(yearTxt.getText()), Integer.valueOf(monthTxt.getText()), Integer.valueOf(dayTxt.getText())) == true){
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Date is in the future");
                confirm.setContentText("Please enter a date that is not in the future");
                confirm.showAndWait();}

            if (patronList.verifyEmail(emailText.getText()) == true)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("User Exists!");
                confirm.setContentText("Patron already exists!");
                confirm.showAndWait();
            }


            if (patronList.verifyEmail(emailText.getText()) == false)
            {
                if (countryTxt.getText().length() + areaTxt.getText().length() + localTxt.getText().length() + lastFourTxt.getText().length() != 11)
                {
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText("Phone Number!");
                    confirm.setContentText("Phone Number is too long or too short!");
                    confirm.showAndWait();
                }
                if (countryTxt2.isVisible() == true && countryTxt2.getText().length() + areaTxt2.getText().length() + localTxt2.getText().length() + lastFourTxt2.getText().length() != 11)
                {
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText(" Second Phone Number!");
                    confirm.setContentText("Second Phone Number is too long or too short!");
                    confirm.showAndWait();
                }


                if (yearTxt.getText().length() != 4 && monthTxt.getText().length() != 2 && dayTxt.getText().length() != 2)
                {
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText("BIRTH DATE!");
                    confirm.setContentText("Check to make sure data is in MM DD YYYY format");
                    confirm.showAndWait();

                }

                if (cardTxt.getText().length() != 8 && patronList.foundCard(cardTxt.getText()) == true)
                {
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText("Card Number!");
                    confirm.setContentText("Check to make sure card number equals 8 and does not already exist. Will be developed auto generate the number in future updates.");
                    confirm.showAndWait();

                }


                if (!emailText.getText().contains("@"))
                {
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText("Email!");
                    confirm.setContentText("Check to make sure email includes a @ character");
                    confirm.showAndWait();

                }

                if (zipTxt.getText().length() != 5)
                {
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText("Zip Code!");
                    confirm.setContentText("Make sure Zip is 5 digits.");
                    confirm.showAndWait();

                } else
                {
                    if (countryTxt2.isVisible() == true && countryTxt2.getText().length() + areaTxt2.getText().length() + localTxt2.getText().length() + lastFourTxt2.getText().length() == 11)
                    {
                        Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(yearTxt.getText(), monthTxt.getText(), dayTxt.getText()), new Address(streetNumTxt.getText(), streetNameTxt.getText(), typeTxt.getText(), cityTxt.getText(), stateTxt.getText(),
                                zipTxt.getText(), aptTxt.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()), Integer.valueOf(areaTxt.getText()), Integer.valueOf(localTxt.getText()), Integer.valueOf(lastFourTxt.getText())), new PhoneNumber(Integer.valueOf(countryTxt2.getText()), Integer.valueOf(areaTxt2.getText()), Integer.valueOf(localTxt2.getText()), Integer.valueOf(lastFourTxt2.getText())))), emailText.getText(), cardTxt.getText(), 0);
                        patronList.LoadPatron(tempPatron);
                        PatronCheckoutList tempList = new PatronCheckoutList(cardTxt.getText(), new ArrayList<CheckOut>());
                        AllCheckoutLists allLists = new AllCheckoutLists();
                        allLists.LoadList(tempList);
                        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                        confirm.setHeaderText("Account Added!");
                        confirm.setContentText("Account has been added");
                        confirm.showAndWait();
                    } else
                    {
                        Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(yearTxt.getText(), monthTxt.getText(), dayTxt.getText()), new Address(streetNumTxt.getText(), streetNameTxt.getText(), typeTxt.getText(), cityTxt.getText(), stateTxt.getText(),
                        zipTxt.getText(), aptTxt.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()), Integer.valueOf(areaTxt.getText()), Integer.valueOf(localTxt.getText()), Integer.valueOf(lastFourTxt.getText())))), emailText.getText(), cardTxt.getText(), 0);
                        patronList.LoadPatron(tempPatron);
                        PatronCheckoutList tempList = new PatronCheckoutList(cardTxt.getText(), new ArrayList<CheckOut>());
                        AllCheckoutLists allLists = new AllCheckoutLists();
                        allLists.LoadList(tempList);
                        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                        confirm.setHeaderText("Account Added!");
                        confirm.setContentText("Account has been added");
                        confirm.showAndWait();
                    }


                }
            }


        });


    }

    @FXML
    public void initialize()
    {
        positionBx.getItems().removeAll(positionBx.getItems());
        positionBx.getItems().addAll("Associate Librarian", "Head Librarian", "Intern");
        positionBx.getSelectionModel().select("Associate Librarian");
        statusBx.getItems().removeAll(statusBx.getItems());
        statusBx.getItems().addAll("Experienced", "Training");
        statusBx.getSelectionModel().select("Training");

    }

    @FXML
    public void staffCreateAccount(javafx.event.ActionEvent actionEvent)
    {
        staffRBtn.setOnMouseClicked(mouseEvent ->
        {

            patronRBtn.setSelected(false);
            FxLoader object = new FxLoader();
            Pane content = object.getPage("NewStaffUI");
            radioBPane.setRight(content);


        });

    }

    public ChoiceBox<String> getPositionBx()
    {
        return positionBx;
    }

    public void setPositionBx(ChoiceBox<String> positionBx)
    {
        this.positionBx = positionBx;
    }

    @FXML
    public void createStaffAccount(javafx.event.ActionEvent actionEvent)
    {
        StaffList staffList = new StaffList();
        createAccountBtnStaff.setOnMouseClicked(mouseEvent ->
        {
            if (staffList.foundUserID(staffIDTxt.getText()) == true)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("User Exists");
                confirm.setContentText("Enter a new user name");
                confirm.showAndWait();

            }

            if (yearTxtStaff.getText().length() != 4 && monthTxtStaff.getText().length() != 2 && dayTxtStaff.getText().length() != 2)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("BIRTH DATE!");
                confirm.setContentText("Check to make sure data is in MM DD YYYY format");
                confirm.showAndWait();

            }

            if (startYearTxt.getText().length() != 4 && startMonthTxt.getText().length() != 2 && startDayTxt.getText().length() != 2)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Start Date!");
                confirm.setContentText("Check to make sure data is in MM DD YYYY format");
                confirm.showAndWait();

            }
            if (pinTxt.getText().length() < 4)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Pin Length");
                confirm.setContentText("Check to make sure pin is longer than 4 numbers");
                confirm.showAndWait();
            }

            if (countryTxtStaff.getText().length() + areaTxtStaff.getText().length() + localTxtStaff.getText().length() + lastFourTxtStaf.getText().length() != 11)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Phone Number!");
                confirm.setContentText("Phone Number is too long or too short!");
                confirm.showAndWait();
            }
            if (zipTxtStaff.getText().length() != 5)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Zip Code!");
                confirm.setContentText("Make sure Zip is 5 digits.");
                confirm.showAndWait();

            }

            if (cityTxtStaff.getText().equals(null))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("City!");
                confirm.setContentText("Make sure City is not empty.");
                confirm.showAndWait();

            }

            if (nameTxtStaff.getText().equals(null))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Name!");
                confirm.setContentText("Make sure Name is not empty.");
                confirm.showAndWait();

            }

            if (streetNameTxtStaff.getText().equals(null))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Street Name!");
                confirm.setContentText("Make sure Street Name is not empty.");
                confirm.showAndWait();

            }
            if (streetNumTxtStaff.getText().equals(null))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Street Number!");
                confirm.setContentText("Make sure Street Number is not empty.");
                confirm.showAndWait();

            }

            if (stateTxtStaff.getText().equals(null))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("State!");
                confirm.setContentText("Make sure State is not empty.");
                confirm.showAndWait();

            }

            if (typeTxtStaff.getText().equals(null))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Street Type");
                confirm.setContentText("Make sure Street Type is not empty.");
                confirm.showAndWait();

            }

            if (!emailTextStaff.getText().contains("@wclibrary.com"))
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Email Address!");
                confirm.setContentText("Make sure the email includes @wclibrary.com");
                confirm.showAndWait();

            }
            if (staffList.foundEmail(emailTextStaff.getText()) == true)
            {
                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Email Address Exists!");
                confirm.setContentText("Please use a new email address");
                confirm.showAndWait();
            } else
            {


                LibraryStaff tempStaff = new LibraryStaff(nameTxtStaff.getText(), new NormalDate(yearTxtStaff.getText(), monthTxtStaff.getText(), dayTxtStaff.getText()), new Address(streetNumTxtStaff.getText(), streetNameTxtStaff.getText(), typeTxtStaff.getText(), cityTxtStaff.getText(), stateTxtStaff.getText(),
                        zipTxtStaff.getText(), aptTxtStaff.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxtStaff.getText()), Integer.valueOf(areaTxtStaff.getText()), Integer.valueOf(localTxtStaff.getText()), Integer.valueOf(lastFourTxtStaf.getText())))), emailTextStaff.getText(),
                        staffIDTxt.getText(), pinTxt.getText(), positionBx.getValue(), statusBx.getValue(), new NormalDate(startYearTxt.getText(), startMonthTxt.getText(), startDayTxt.getText()), 0);

                staffList.LoadStaff(tempStaff);
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setHeaderText("Staff Account Added!");
                confirm.setContentText("Account has been added");
                confirm.showAndWait();


            }

        });
    }


}