
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

public class adminUserProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> fxID;

    @FXML
    private TableColumn<Student, String> fxfullname;   //// fxid

    @FXML
    private TableColumn<Student, String> fxsemester;

    @FXML
    private TableColumn<Student, String> fxyearsem;

    @FXML
    private TableColumn<Student, String> fxmail;

    @FXML
    private TableColumn<Student, String> fxcontactno;   //// fxid

    @FXML
    private TableColumn<Student, Integer> fxpassword;

    @FXML
    private TableColumn<Student, String> fxfathername;

    @FXML
    private TableColumn<Student, String> fxdepartment;

    @FXML
    private TableColumn<Student, String> fxprogram;   //// fxid

    @FXML
    private TableColumn<Student, Integer> fxcgpa;

    @FXML
    private TableColumn<Student, String> fxtheorysection;

    @FXML
    private TableColumn<Student, String> fssessionalsection;

    @FXML
    private TableColumn<Student, String> fxadvisor;


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Student student = null;

    ObservableList<Student> StudentList = FXCollections.observableArrayList();

    @FXML
    public void getAddView(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/addStudent.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            refreshView();
        } catch (IOException ex) {
            Logger.getLogger(adminUserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    int index;
    @FXML
    void delete(ActionEvent event) {

        index = studentTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        String from_table=fxfullname.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from databasefile where `Full Name` = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, from_table);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Are you sure?");
            refreshView();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    public void refreshView() {
        try {
            StudentList.clear();
            query = "SELECT * FROM databasefile";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentList.add(new Student(
                        resultSet.getString("ID"),
                        resultSet.getString("Full Name"), // database column
                        resultSet.getString("Semester"),
                        resultSet.getString("Year/Semester"),
                        resultSet.getString("Email"),
                        resultSet.getString("Mobile number"),
                        resultSet.getInt("Password"),
                        resultSet.getString("Father Name"),
                        resultSet.getString("Dept/School"),
                        resultSet.getString("Program"),
                        resultSet.getString("Theory Section"),
                        resultSet.getString("Sessional Section"),
                        resultSet.getString("CGPA"),
                        resultSet.getString("Advisor")
                ));
                studentTable.setItems(StudentList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    public void deleteView(ActionEvent actionEvent) {

    }

    @FXML
    public void printView(ActionEvent actionEvent) {

    }


    private void loadInfo() {
        System.out.println("Loading info");
        connection = DatabaseHandler.createConnection();
        refreshView();
        fxID.setCellValueFactory(new PropertyValueFactory<>("id"));
        fxfullname.setCellValueFactory(new PropertyValueFactory<>("name"));
        fxsemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        fxyearsem.setCellValueFactory(new PropertyValueFactory<>("year_Sem"));/// 1st -> fxid, 2nd -> variable(student class)
        fxmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        fxcontactno.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        fxpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        fxfathername.setCellValueFactory(new PropertyValueFactory<>("father_name"));
        fxdepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        fxprogram.setCellValueFactory(new PropertyValueFactory<>("program"));
        fxcgpa.setCellValueFactory(new PropertyValueFactory<>("cgpa"));

        fxtheorysection.setCellValueFactory(new PropertyValueFactory<>("theory_sec"));
        fssessionalsection.setCellValueFactory(new PropertyValueFactory<>("sessional_sec"));
        fxadvisor.setCellValueFactory(new PropertyValueFactory<>("advisor"));


    }


    @FXML
    void initialize() {
        loadInfo();

    }

}

