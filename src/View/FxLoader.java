package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FxLoader
{
    private Pane view;
    public Pane getPage(String fileName){
        try
        {
           URL fileURL = getClass().getResource("/View/" + fileName + ".fxml");
           view = new FXMLLoader().load(fileURL);
        } catch (IOException e)
        {
            System.out.println(" No Page");
        }

        return view;
    }

}

