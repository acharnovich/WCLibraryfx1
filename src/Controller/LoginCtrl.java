package Controller;

import Model.StaffList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LoginCtrl {
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




    public LoginCtrl()
    {
        stafflist = new StaffList();
    }

    @FXML
    public void LoginBtnClicked()
    {
        submitBtn.setOnMouseClicked((event) -> {

        {
            // attempt to authenticate user credentials
            if (stafflist.authenticate(userid.getText(), pin.getText()) == true)
            {

                // if credentials are correct...
                submitBtn.getScene().getWindow().hide();
                try{
               FXMLLoader loader = new FXMLLoader(getClass().getResource("src/View/NavUI.fxml"));
               loader.setLocation(getClass().getResource("src/View/NavUI.fxml"));
               Scene scene = new Scene(loader.load(), 600,400);
               Stage stage = new Stage();
               stage.setTitle("test");
               stage.setScene(scene);
               stage.show();}
                catch (IOException e){}





               // navCtrl.getNavUI().setVisible(true);       // make Navigation UI visible
                //loginUI.setVisible(false);                 // make Login UI not visible
                //loginUI.dispose();                         // get rid of Login UI
            }}

           // if (staffList.authenticate(loginUI.getUserID().getText(), loginUI.getPin().getText()) == false){
             //   loginUI.showMessage();
            });
        // get the submit button from loginUI and add a mouse listener to it
        //loginUI.getSubmitButton().addMouseListener(new MouseAdapter()


    }

}
