package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

import java.io.IOException;

public class AddBillCtrl
{
    @FXML
    private ToolBar addBillToolBar;

    @FXML
    private Button addBillSearchButton;

    @FXML
    private Label addBillLabel;

    @FXML
    private TextField addBillCardNumTextField;

    @FXML
    private Button addBillSubmitButton;

    public void handleSubmitClick(javafx.event.ActionEvent actionEvent)
    {
        addBillSubmitButton.setOnMouseClicked(mouseEvent -> {

            Parent part = null;
            try {
                part = FXMLLoader.load(getClass().getResource("/View/AddBillDetailsUI.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(part);
                stage.setScene(scene);
                stage.setTitle("Enter Bill Details");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
