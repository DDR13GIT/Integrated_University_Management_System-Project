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

public class adminResultController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Subject> subjectTable;
    @FXML
    private TableColumn<Subject, String> fx_id;

    @FXML
    private TableColumn<Subject, Integer> fx_discrete;

    @FXML
    private TableColumn<Subject, Integer> fx_oop;

    @FXML
    private TableColumn<Subject, Integer> fx_eee;

    @FXML
    private TableColumn<Subject, Integer> fx_math;

    @FXML
    private TableColumn<Subject, Integer> fx_mecha;

    @FXML
    private TableColumn<Subject, Integer> fx_sdlab;

    @FXML
    private TableColumn<Subject, Integer> fx_ooplab;

    @FXML
    private TableColumn<Subject, Integer> fx_eeelab;

    @FXML
    private TableColumn<Subject, Integer> fx_mechalab;



    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Subject subject = null;

    ObservableList<Subject> SubjectList = FXCollections.observableArrayList();

    @FXML
    public void refreshView() {
        try {
            SubjectList.clear();
            query = "SELECT * FROM result";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SubjectList.add(new Subject(
                        resultSet.getString("ID"),
                        resultSet.getInt("DISCRETE"), // database column
                        resultSet.getInt("OOP"),
                        resultSet.getInt("EEE"),
                        resultSet.getInt("MATH"),
                        resultSet.getInt("MECHANICAL"),
                        resultSet.getInt("Sdlab"),
                        resultSet.getInt("OOPlab"),
                        resultSet.getInt("EEElab"),
                        resultSet.getInt("MECHAlab")
                ));
                subjectTable.setItems(SubjectList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
int index;
    @FXML
    public void delete(ActionEvent actionEvent) {
        index = subjectTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        String from_table=fx_id.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from `result` where `ID` = ?";
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
    void refresh(ActionEvent event) {
        try {
            SubjectList.clear();
            query = "SELECT * FROM `result`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SubjectList.add(new Subject(
                        resultSet.getString("ID"),
                        resultSet.getInt("DISCRETE"), // database column
                        resultSet.getInt("OOP"),
                        resultSet.getInt("EEE"),
                        resultSet.getInt("MATH"),
                        resultSet.getInt("MECHANICAL"),
                        resultSet.getInt("Sdlab"),
                        resultSet.getInt("OOPlab"),
                        resultSet.getInt("EEElab"),
                        resultSet.getInt("MECHAlab")
                ));
                subjectTable.setItems(SubjectList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @FXML
    void addMark(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/addMarks.fxml"));
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


    private void loadInfo() {
        System.out.println("Loading info");
        connection = DatabaseHandler.createConnection();
        refreshView();
        fx_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        fx_discrete.setCellValueFactory(new PropertyValueFactory<>("discrete_num"));
        fx_oop.setCellValueFactory(new PropertyValueFactory<>("oop_num"));
        fx_eee.setCellValueFactory(new PropertyValueFactory<>("eee_num"));/// 1st -> fxid, 2nd -> variable(student class)
        fx_math.setCellValueFactory(new PropertyValueFactory<>("math_num"));
        fx_mecha.setCellValueFactory(new PropertyValueFactory<>("mecha_num"));
        fx_sdlab.setCellValueFactory(new PropertyValueFactory<>("sdlab_num"));
        fx_ooplab.setCellValueFactory(new PropertyValueFactory<>("ooplab_num"));
        fx_eeelab.setCellValueFactory(new PropertyValueFactory<>("eeelab_num"));
        fx_mechalab.setCellValueFactory(new PropertyValueFactory<>("melab_num"));

    }

    @FXML
    void initialize() {
        loadInfo();
    }
}
