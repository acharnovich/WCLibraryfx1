package Controller;

import Model.StaffList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginCtrl
{
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
                        loginSuccess.setContentText("Welcome! New in this update, Items and Accounts can now be searched");
                        loginSuccess.showAndWait();
                    } catch (IOException e)
                    {}

                }else {
                    Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                    loginFailed.setHeaderText("Login Failed");
                    loginFailed.setContentText("Wrong user ID or Pin. For testing, try User: ajones Pin:1234");
                    loginFailed.showAndWait();
                }
            }

            // if (staffList.authenticate(loginUI.getUserID().getText(), loginUI.getPin().getText()) == false){
            //   loginUI.showMessage();
        });
        // get the submit button from loginUI and add a mouse listener to it
        //loginUI.getSubmitButton().addMouseListener(new MouseAdapter()

    }

}
