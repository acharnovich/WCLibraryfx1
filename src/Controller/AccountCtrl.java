package Controller;

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
        private TextField birthTxt;

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
        private Label emailTxt;

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
        private TextField phoneTxt;

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


}