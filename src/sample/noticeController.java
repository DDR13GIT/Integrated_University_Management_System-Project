package sample;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class noticeController {

    @FXML
    private ResourceBundle resources;


    @FXML
    private TableView<stdNoticeDetails> noticeTable;

    @FXML
    private TableColumn<stdNoticeDetails, String> noticeNo;

    @FXML
    private TableColumn<stdNoticeDetails, String> noticeTitle;

    @FXML
    private TableColumn<stdNoticeDetails, String> date;


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    stdNoticeDetails stdNoticeDetails = null;
    ObservableList<stdNoticeDetails> stdNoticeDetailsList = FXCollections.observableArrayList();


    @FXML
    void getfresh() {
        try {
            stdNoticeDetailsList.clear();
            query = "SELECT * FROM notice";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                stdNoticeDetailsList.add(new stdNoticeDetails(
                        resultSet.getString("Notice No"),
                        resultSet.getString("Notice Title"),
                        resultSet.getString("Date")));
                noticeTable.setItems(stdNoticeDetailsList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    private void loadNoticeInfo() {
        try {
            System.out.println("testing:::::");

            connection = DatabaseHandler.createConnection();
            getfresh();
            noticeNo.setCellValueFactory(new PropertyValueFactory<>("notice_No")); //variable name
            noticeTitle.setCellValueFactory(new PropertyValueFactory<>("notice_Title"));
            date.setCellValueFactory(new PropertyValueFactory<>("notice_Date"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    int index;

    @FXML
    void openNoticeBtn() throws SQLException, IOException {
        index = noticeTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String from_table = noticeNo.getCellData(index);
        String pdfPath = "";

        String query = "SELECT Link FROM notice WHERE `Notice No`= '" + from_table + "'";
        ResultSet rs1 = DatabaseHandler.executeQuery(query, DatabaseHandler.createConnection());
        while (rs1.next()) {
            pdfPath = rs1.getString("Link");
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

