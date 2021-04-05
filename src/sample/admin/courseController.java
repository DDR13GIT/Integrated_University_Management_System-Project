package sample.admin;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class courseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<courseDetails> courseTable;

    @FXML
    private TableColumn<courseDetails, String> courseName;

    @FXML
    private TableColumn<courseDetails, String> courseCode;

    @FXML
    private TableColumn<courseDetails, String> courseCredit;

    @FXML
    private TableColumn<courseDetails, String> department;

    @FXML
    private TableColumn<courseDetails, String> yearSem;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    courseDetails courseDetails = null;
    ObservableList<courseDetails> courseDetailsList = FXCollections.observableArrayList();

    @FXML
    void addCourse(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/addCourse.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(adminUserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    int index;
    @FXML
    void deleteCourse(ActionEvent event) {

        index = courseTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        String from_table=courseName.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from course where Cname = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, from_table);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Are you sure?");
            refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void refresh() {
        try {
            courseDetailsList.clear();
            query = "SELECT * FROM course";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                courseDetailsList.add(new courseDetails(
                        resultSet.getString("Cname"),
                        resultSet.getString("Ccode"),
                        resultSet.getString("Ccredit"),
                        resultSet.getString("Cdept"),
                        resultSet.getString("CY/S")));
                courseTable.setItems(courseDetailsList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void loadCourseInfo() {
        System.out.println("testing:::::");
        //  System.out.println(Controller.typedID);
        //  String qu = "SELECT * FROM databasefile WHERE ID = '" + Controller.typedID + "'";
        connection= DatabaseHandler.createConnection();
        refresh();
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        courseCode.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        courseCredit.setCellValueFactory(new PropertyValueFactory<>("course_credit"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        yearSem.setCellValueFactory(new PropertyValueFactory<>("year_sem"));

    }


    @FXML
    void initialize() {
        loadCourseInfo();

    }
}
