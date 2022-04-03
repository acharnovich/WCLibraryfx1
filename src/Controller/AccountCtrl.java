package Controller;

import Model.*;
import View.FxLoader;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountCtrl
{

    @FXML
    private RadioButton patronRBtn;

    @FXML
    private RadioButton staffRBtn;

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
public void  verifyEmail(){
    verifyBtn.setOnMouseClicked(mouseEvent -> {
        patronList = new PatronList();
        if (patronList.verifyEmail(emailText.getText()) == false){
            emailText.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");

        } else{emailText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");}

    });


}

@FXML
    public void patronAddPhoneNumber(javafx.event.ActionEvent actionEvent){
    secAddressBtn.setOnMouseClicked(mouseEvent -> {
    countryTxt2.setVisible(true);
        localTxt2.setVisible(true);
        areaTxt2.setVisible(true);
        lastFourTxt2.setVisible(true);
    });
    }
    @FXML
    public void createPatronAccount(javafx.event.ActionEvent actionEvent)
    {
        patronList = new PatronList();
        createAccountBtn.setOnMouseClicked(mouseEvent ->
        {
            if (patronList.verifyEmail(emailText.getText()) == false)
            {
                if (countryTxt2.isVisible() == true) {
                    Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(yearTxt.getText(), monthTxt.getText(), dayTxt.getText()), new Address(streetNumTxt.getText(), streetNameTxt.getText(), typeTxt.getText(), cityTxt.getText(), stateTxt.getText(),
                            zipTxt.getText(), aptTxt.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()), Integer.valueOf(areaTxt.getText()), Integer.valueOf(localTxt.getText()), Integer.valueOf(lastFourTxt.getText())), new PhoneNumber(Integer.valueOf(countryTxt2.getText()), Integer.valueOf(areaTxt2.getText()), Integer.valueOf(localTxt2.getText()), Integer.valueOf(lastFourTxt2.getText())))), emailText.getText(), cardTxt.getText(), 0);
                    patronList.LoadPatron(tempPatron);
                    PatronCheckoutList tempList = new PatronCheckoutList(cardTxt.getText(), new ArrayList<CheckOut>());
                    AllCheckoutLists allLists = new AllCheckoutLists();
                    allLists.LoadList(tempList);

                }
                else
                {
                    Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(yearTxt.getText(), monthTxt.getText(), dayTxt.getText()), new Address(streetNumTxt.getText(), streetNameTxt.getText(), typeTxt.getText(), cityTxt.getText(), stateTxt.getText(),
                            zipTxt.getText(), aptTxt.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()), Integer.valueOf(areaTxt.getText()), Integer.valueOf(localTxt.getText()), Integer.valueOf(lastFourTxt.getText())))), emailText.getText(), cardTxt.getText(), 0);
                    patronList.LoadPatron(tempPatron);
                    PatronCheckoutList tempList = new PatronCheckoutList(cardTxt.getText(), new ArrayList<CheckOut>());
                    AllCheckoutLists allLists = new AllCheckoutLists();
                    allLists.LoadList(tempList);

                }
            }
            else
            {
                Alert accountExsists = new Alert(Alert.AlertType.ERROR);
                accountExsists.setHeaderText("Email Exists");
                accountExsists.setContentText("Account Exists! Please try a new email or search for Patron");
                accountExsists.showAndWait();
            }

        });


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

    @FXML
    public void createStaffAccount(javafx.event.ActionEvent actionEvent)
    {
        createAccountBtnStaff.setOnMouseClicked(mouseEvent ->
        {

            LibraryStaff tempStaff = new LibraryStaff(nameTxtStaff.getText(), new NormalDate(yearTxtStaff.getText(), monthTxtStaff.getText(), dayTxtStaff.getText()), new Address(streetNumTxtStaff.getText(), streetNameTxtStaff.getText(), typeTxtStaff.getText(), cityTxtStaff.getText(), stateTxtStaff.getText(),
                    zipTxtStaff.getText(), aptTxtStaff.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxtStaff.getText()), Integer.valueOf(areaTxtStaff.getText()), Integer.valueOf(localTxtStaff.getText()), Integer.valueOf(lastFourTxtStaf.getText())))), emailTextStaff.getText(),
                    staffIDTxt.getText(), pinTxt.getText(), positionTxt.getText(), statusTxt.getText(), new NormalDate(startYearTxt.getText(), startMonthTxt.getText(), startDayTxt.getText()), 0);
            StaffList staffList = new StaffList();
            staffList.LoadStaff(tempStaff);


        });
    }




}