package sample.admin;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
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

public class adminFacultyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton fxaddfacultyaction;

    @FXML
    private JFXButton fxrefreshaction;

    @FXML
    private TableView<Faculty> facultytable;

    @FXML
    private TableColumn<Faculty, String> fxname;

    @FXML
    private TableColumn<Faculty, String> fxdepartment;

    @FXML
    private TableColumn<Faculty, String> fxrcourseid;

    @FXML
    private TableColumn<Faculty, String> fxcontactno;

    @FXML
    private TableColumn<Faculty, String> fxpemailadd;

    @FXML
    private TableColumn<Faculty, String> fxpassword;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Faculty Faculty = null ;

    ObservableList<Faculty> facultylist = FXCollections.observableArrayList();


    @FXML
    void addfacultyaction(ActionEvent event)
    {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/addfaculty.fxml"));
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
    void deleteFaculty(ActionEvent event) {
        index = facultytable.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        String from_table=fxname.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from `facultydatabase` where `FACALTY NAME` = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, from_table);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Are you sure?");
            refreshfacultyaction();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    void refreshfacultyaction()
    {
        try {
            facultylist.clear();
            query = "SELECT * FROM facultydatabase";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                facultylist.add(new Faculty(
                        resultSet.getString("FACALTY NAME"),
                        resultSet.getString("DEPARTMENT"), // database column
                        resultSet.getString("RESPECTIVE COURSE ID"),
                        resultSet.getString("CONTACT NO"),
                        resultSet.getString("EMAIL ADDRESS"),
                        resultSet.getString("Password")
                ));
                facultytable.setItems(facultylist);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void facultyloadInfo() {
        System.out.println("testing:::::");
        connection= DatabaseHandler.createConnection();
        refreshfacultyaction();
        fxname.setCellValueFactory(new PropertyValueFactory<>("name"));
        fxdepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        fxrcourseid.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        fxcontactno.setCellValueFactory(new PropertyValueFactory<>("contactno"));/// 1st -> fxid, 2nd -> variable(student class)
        fxpemailadd.setCellValueFactory(new PropertyValueFactory<>("emailadd"));
        fxpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
    }


    @FXML
    void initialize()
    {
        facultyloadInfo();
    }
}

