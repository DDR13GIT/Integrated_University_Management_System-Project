package sample.admin;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class addStudentController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField insertID;

    @FXML
    private TextField insertName;

    @FXML
    private TextField insertSemester;

    @FXML
    private TextField insertYearSem;

    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Student student = null;
    private boolean update;
    int studentId;


    @FXML
    void save(ActionEvent actionevent) {
        connection = DatabaseHandler.createConnection();
        String id = insertID.getText();
        String name = insertName.getText();
        String semester = insertSemester.getText();
        String yearSem = insertYearSem.getText();

        if (id.isEmpty() || name.isEmpty() || semester.isEmpty() || yearSem.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        } else {
            getQuery();
            insert();
            Notifications.create()
                    .title("About Us")
                    .text("success")
                    .position(Pos.CENTER)
                    .showInformation();

        }

    }


    private void insert() {
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, insertID.getText());
            preparedStatement.setString(2, insertName.getText());
            preparedStatement.setString(3, insertSemester.getText());
            preparedStatement.setString(4, insertYearSem.getText());
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void getQuery() {
        query = "INSERT INTO `databasefile`(`ID`,`Full Name`, `Semester`,`Year/Semester`) VALUES (?,?,?,?)";

    }
    @FXML
    private void clear(ActionEvent actionevent) {
        insertID.setText(null);
        insertName.setText(null);
        insertSemester.setText(null);
        insertYearSem.setText(null);

    }

    @FXML
    void initialize() {


    }

}





