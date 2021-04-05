package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fundController {

    public AnchorPane mainPane;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton fxnativestudent;

    @FXML
    private JFXButton fxinterstudent;

    @FXML
    private JFXButton fxapplybtn;

    @FXML
    void applycall(ActionEvent event)
    {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/SCHOLARSHIP_APPLY.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(fundController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void interstudentcall(ActionEvent event)
    {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/SCHOLARSHIP_NATIVE.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(fundController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void nativestudentcall(ActionEvent event)
    {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/SCHOLARSHIP_INT.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(fundController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void initialize() {
        
    }
}
