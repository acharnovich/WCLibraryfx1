package Controller;

import Model.NormalDate;
import Model.StaffList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginCtrl
{
    @FXML
    private Label changeUserLbl;
    @FXML
    private Button changeSubmitBtn;

    @FXML
    private TextField changeUserTxt;

    @FXML
    private Label newPinLbl;

    @FXML
    private TextField newPinTxt;

    @FXML
    private Label oldPinLbl;

    @FXML
    private TextField oldPinTxt;

    @FXML
    private Label retypePinLbl;

    @FXML
    private TextField retypePinTxt;
    private final StaffList stafflist;
    @FXML
    private Label idLbl;

    @FXML
    private PasswordField pin;

    @FXML
    private Label pinLbl;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField userid;

    @FXML
    private Label welcomeLbl;

    @FXML
    private ImageView wcLogo;

    @FXML
    private AnchorPane changePinPanel;


    private Stage stage;


    public LoginCtrl()
    {
        stafflist = new StaffList();
    }

    @FXML
    public void LoginBtnClicked()
    {
        submitBtn.setOnMouseClicked((event) ->
        {

            {


                // attempt to authenticate user credentials
                if (stafflist.authenticate(userid.getText(), pin.getText()) == true)
                {
                    // if credentials are correct...
                    submitBtn.getScene().getWindow().hide();
                    try
                    {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/NavUI.fxml"));
                        loader.setLocation(getClass().getResource("/View/NavUI.fxml"));
                        Scene scene = new Scene(loader.load());
                        stage = new Stage();
                        stage.setTitle("WCLibrary Main Menu");
                        stage.setScene(scene);
                        stage.show();

                        Alert loginSuccess = new Alert(Alert.AlertType.CONFIRMATION);
                        loginSuccess.setHeaderText("Login Success: " + userid.getText());
                        loginSuccess.setContentText("Sprint 5 Updates:" +
                                                    "\n- Paybill/AddBill is what's new in sprint 5" +
                                                    "\n- Change pin is now a feature for staff to change pins" +
                                                    "\n- Updated Validation across the app.");
                        loginSuccess.showAndWait();
                    } catch (IOException e)
                    {}

                }else {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("Login Failed");
                    loginFailed.setContentText("Wrong user ID or Pin. For testing, try\n\nUser: ajones\nPIN:1234\n If you forgot your password, please contact a system administrator.");
                    loginFailed.showAndWait();
                }
            }

            // if (staffList.authenticate(loginUI.getUserID().getText(), loginUI.getPin().getText()) == false){
            //   loginUI.showMessage();
        });
        // get the submit button from loginUI and add a mouse listener to it
        //loginUI.getSubmitButton().addMouseListener(new MouseAdapter()

    }

    public void changePin(javafx.event.ActionEvent actionEvent){
        changeSubmitBtn.setOnMouseClicked(mouseEvent -> {
            if(stafflist.authenticate(changeUserTxt.getText(),oldPinTxt.getText()) == true && newPinTxt.getText().length() >=4 &&newPinTxt.getText().equals(retypePinTxt.getText())){
            stafflist.changePin(changeUserTxt.getText(), newPinTxt.getText());
                Alert loginFailed = new Alert(Alert.AlertType.CONFIRMATION);
                loginFailed.setHeaderText("Success!");
                loginFailed.setContentText("Pin Changed.");
                loginFailed.showAndWait();
                changeUserTxt.clear();
                newPinTxt.clear();
                oldPinTxt.clear();
                retypePinTxt.clear();

            }
            else {if (stafflist.authenticate(changeUserTxt.getText(),oldPinTxt.getText()) == false){
                Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                loginFailed.setHeaderText("Wrong Old Pin or User ID");
                loginFailed.setContentText("Wrong user ID or Pin. If you forgot your pin, please contact a system administrator.");
                loginFailed.showAndWait();
            }
            if(!newPinTxt.getText().equals(retypePinTxt.getText())){
                Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                loginFailed.setHeaderText("New Pin does not match!");
                loginFailed.setContentText("Please retype your new pin to make sure they match and is at least 4 characters long.");
                loginFailed.showAndWait();

            }
                if(newPinTxt.getText().length()<4){
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("Pin Length!");
                    loginFailed.setContentText("Please retype your new pin to make sure they match and is at least 4 characters long.");
                    loginFailed.showAndWait();
                }
            }
        });


    }

}
