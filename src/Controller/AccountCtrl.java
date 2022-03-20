package Controller;

import Model.*;
import View.FxLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountCtrl {

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
        private Label idLbl;

        @FXML
        private TextField idTxt;

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
    public void patronCreateAccount(javafx.event.ActionEvent actionEvent)
    { patronRBtn.setOnMouseClicked(mouseEvent -> {
        FxLoader object = new FxLoader();
        Pane content = object.getPage("NewPatronUI");
        radioBPane.setRight(content);

    });
    }
    @FXML
    public void createPatronAccount(javafx.event.ActionEvent actionEvent)
    {
        createAccountBtn.setOnMouseClicked(mouseEvent -> {

            Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(yearTxt.getText(),monthTxt.getText(),dayTxt.getText()), new Address(streetNumTxt.getText(), streetNameTxt.getText(),typeTxt.getText(),cityTxt.getText(),stateTxt.getText(),
                    zipTxt.getText(), aptTxt.getText()),new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()),Integer.valueOf(areaTxt.getText()),Integer.valueOf(localTxt.getText()),Integer.valueOf(lastFourTxt.getText())))), emailText.getText(),cardTxt.getText(),0);
            PatronList patronList = new PatronList(tempPatron);
            System.out.println(patronList.getPatronimport().get(0).toString());
        });


    }


}