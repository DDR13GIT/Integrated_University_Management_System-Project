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

public class adminNoticeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<noticeDetails> noticeTable;

    @FXML
    private TableColumn<noticeDetails, String> noticeNo;

    @FXML
    private TableColumn<noticeDetails, String> noticeTitle;

    @FXML
    private TableColumn<noticeDetails, String> date;

    @FXML
    private TableColumn<noticeDetails, String> link;

    @FXML
    private JFXButton addNotice;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    noticeDetails noticeDetails = null;
    ObservableList<noticeDetails> noticeDetailsList = FXCollections.observableArrayList();

    @FXML
    void addNoticeAction(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/addNOTICE.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            getRefresh();
        } catch (IOException ex) {
            Logger.getLogger(adminUserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    int index;
    @FXML
    void deleteNotice(ActionEvent event) {

        index = noticeTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        String from_table=noticeNo.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from `notice` where `Notice No` = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, from_table);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Are you sure?");
            getRefresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void getRefresh() {
        try {
            noticeDetailsList.clear();
            query = "SELECT * FROM notice";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                noticeDetailsList.add(new noticeDetails(
                        resultSet.getString("Notice No"),
                        resultSet.getString("Notice Title"),
                        resultSet.getString("Date"),
                        resultSet.getString("Link")));
                noticeTable.setItems(noticeDetailsList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void loadNoticeInfo() {
        System.out.println("testing:::::");
        //  System.out.println(Controller.typedID);
        //  String qu = "SELECT * FROM databasefile WHERE ID = '" + Controller.typedID + "'";
        connection= DatabaseHandler.createConnection();
        getRefresh();
        noticeNo.setCellValueFactory(new PropertyValueFactory<>("notice_No")); //variable name
        noticeTitle.setCellValueFactory(new PropertyValueFactory<>("notice_Title"));
        date.setCellValueFactory(new PropertyValueFactory<>("notice_Date"));
        link.setCellValueFactory(new PropertyValueFactory<>("notice_Link"));


    }

    @FXML
    void openNotice() throws SQLException, IOException {
        index = noticeTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String from_table = noticeNo.getCellData(index);
        String pdfPath = "";

        String query = "SELECT `Link` FROM `notice` WHERE `Notice No` = '" + from_table + "'";
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
    void initialize() {
        loadNoticeInfo();

    }
}
