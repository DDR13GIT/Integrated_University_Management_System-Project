package sample;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class addPrescriptionController {

    public TextField insertPresTitle;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField insertNoticeTitle;

    @FXML
    private TextField insertFileLink;

    @FXML
    private JFXButton uploadBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    void choose(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();

            fc.setInitialDirectory(new File("F:\\"));
            File seletedFile = fc.showOpenDialog(null);
            if (seletedFile != null) {
                insertFileLink.setText(seletedFile.getAbsolutePath());
            } else {
                System.out.println("file not valid");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void clear(ActionEvent event) {
        insertPresTitle.setText("");
        insertFileLink.setText("");
    }
    Connection connection;

    @FXML
    void uploadaction(ActionEvent event) {
        connection = DatabaseHandler.createConnection();
        String title = insertPresTitle.getText();
        String link = insertFileLink.getText();


        if ( title.isEmpty() || link.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        } else {
            getQuery();
            insertInfo();
            Notifications.create()
                    .title("About Us")
                    .text("success")
                    .position(Pos.CENTER)
                    .showInformation();

        }
    }
    String query;
    private void insertInfo() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, insertPresTitle.getText());
            preparedStatement.setString(2, (insertFileLink.getText()));
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void getQuery() {
        query = "INSERT INTO `prescription`(`Prescription Title`,`Link`) VALUES (?,?)";

    }

    @FXML
    void initialize() {

    }
}
