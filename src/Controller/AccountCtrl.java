package Controller;

import View.FxLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
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


    public void patronCreateAccount(javafx.event.ActionEvent actionEvent)
    { patronRBtn.setOnMouseClicked(mouseEvent -> {
        FxLoader object = new FxLoader();
        Pane content = object.getPage("NewPatronUI");
        radioBPane.setRight(content);



    });
    }


}