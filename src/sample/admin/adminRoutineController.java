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
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class adminRoutineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton uploadfilebtn;

    @FXML
    private TableView<Routine> fxroutineTable;

    @FXML
    private TableColumn<Routine, String> fxdept;

    @FXML
    private TableColumn<Routine, String> fxsemester;

    @FXML
    private TableColumn<Routine, String> fxsection;

    @FXML
    private TableColumn<Routine, String> fxlink;

    @FXML
    private JFXButton refreshbtn;

    @FXML
    private JFXButton dltbtn;

    int index;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Routine Routine = null;
    ObservableList<Routine> routinelist = FXCollections.observableArrayList();


    @FXML
    void openPres() throws SQLException, IOException
    {
        index = fxroutineTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String from_table = fxdept.getCellData(index);
        String pdfPath = "";

        String query = "SELECT `Link` FROM `routine` WHERE `Department` = '" + from_table + "'";
        ResultSet rs2 = DatabaseHandler.executeQuery(query, DatabaseHandler.createConnection());
        while (rs2.next()) {
            pdfPath = rs2.getString("Link");
        }
        System.out.println("opening pdf");
        File file = new File(pdfPath);
        if (file.exists())
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else
                System.out.println("file not exist");
    }






    @FXML
    void getrefresh()
    {
        try {
            routinelist.clear();
            query = "SELECT * FROM routine";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                routinelist.add(new Routine(
                        resultSet.getString("Department"),
                        resultSet.getString("Semester"), // database column
                        resultSet.getString("Section"),
                        resultSet.getString("Link")

                ));

                fxroutineTable.setItems(routinelist);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void deletePres(ActionEvent event)
    {
        index = fxroutineTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        String from_table=fxdept.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from routine where `Department` = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, from_table);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Are you sure?");
            getrefresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }



    @FXML
    void uploadfile(ActionEvent event)
    {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/addRoutine.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(adminUserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void loadInfo() {
        try {
            System.out.println("testing:::::");

            connection = DatabaseHandler.createConnection();
            getrefresh();
            fxdept.setCellValueFactory(new PropertyValueFactory<>("dept"));
            fxsemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
            fxsection.setCellValueFactory(new PropertyValueFactory<>("section"));
            fxlink.setCellValueFactory(new PropertyValueFactory<>("link"));//variable name
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void initialize()
    {
        loadInfo();

    }
}
