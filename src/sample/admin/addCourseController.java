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

public class addCourseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField insertCname;

    @FXML
    private TextField insertCcode;

    @FXML
    private TextField insertCcredit;

    @FXML
    private TextField insertYearSem;

    @FXML
    private TextField insertDept;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    courseDetails courseDetails = null;

    @FXML
    void clear(ActionEvent event) {
        insertCname.setText(null);
        insertCcode.setText(null);
        insertCcredit.setText(null);
        insertYearSem.setText(null);
        insertDept.setText(null);

    }

    @FXML
    void save(ActionEvent event) {
        connection = DatabaseHandler.createConnection();
        String CourseName = insertCname.getText();
        String CourseCode = insertCcode.getText();
        String CourseCredit = insertCcredit.getText();
        String Department = insertDept.getText();
        String Year_Sem = insertYearSem.getText();

        if (CourseName.isEmpty() || CourseCode.isEmpty() || CourseCredit.isEmpty() || Department.isEmpty() || Year_Sem.isEmpty()) {
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
            preparedStatement.setString(1, insertCname.getText());
            preparedStatement.setString(2, insertCcode.getText());
            preparedStatement.setString(3, insertCcredit.getText());
            preparedStatement.setString(4, insertDept.getText());
            preparedStatement.setString(5, insertYearSem.getText());
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void getQuery() {
        query = "INSERT INTO `course`(`Cname`,`Ccode`, `Ccredit`,`Cdept`,`CY/S`) VALUES (?,?,?,?,?)";

    }

    @FXML
    void initialize() {

    }
}
