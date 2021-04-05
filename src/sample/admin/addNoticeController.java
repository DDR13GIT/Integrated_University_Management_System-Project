package sample.admin;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.controlsfx.control.Notifications;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

//import jdk.vm.ci.meta.Local;

public class addNoticeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label insertPulished;

    @FXML
    private TextField insertFileLink;

    @FXML
    private TextField insertNoticeTitle;

    @FXML
    private TextField insertPublished;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    private DatePicker insertDate;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    noticeDetails notieDetails = null;

    @FXML
    void choose(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();

            fc.setInitialDirectory(new File("F:\\iums_project\\src\\sample\\NoticeMaterials"));
            fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
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
        insertDate.setValue(null);
        insertNoticeTitle.setText(null);
        insertPublished.setText(null);
        insertFileLink.setText(null);


    }

    @FXML
    void save(ActionEvent event) {
        connection = DatabaseHandler.createConnection();
        LocalDate date = insertDate.getValue();
        String title = insertNoticeTitle.getText();
        String link = insertFileLink.getText();
        String publish = insertPublished.getText();


        if (title.isEmpty() || link.isEmpty() || publish.isEmpty()) {
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

    private void insertInfo() {
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, insertNoticeTitle.getText());
            preparedStatement.setString(2, (insertDate.getValue().toString()));
            preparedStatement.setString(3, insertFileLink.getText());
            // preparedStatement.setString(0, insertPublished.getText());
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void getQuery() {
        query = "INSERT INTO `notice`(`Notice Title`, `Date`,`Link`) VALUES (?,?,?)";

    }

    @FXML
    void initialize() {

    }
}
