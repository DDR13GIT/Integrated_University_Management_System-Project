package sample;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class usercourseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<usercourseDetails> usercourseTable;

    @FXML
    private TableColumn<usercourseDetails, String> courseName;

    @FXML
    private TableColumn<usercourseDetails, String> courseCode;

    @FXML
    private TableColumn<usercourseDetails, String> courseCredit;

    @FXML
    private TableColumn<usercourseDetails, String> department;

    @FXML
    private TableColumn<usercourseDetails, String> yearSem;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    ObservableList<usercourseDetails> usercourseDetailsList = FXCollections.observableArrayList();

    @FXML
    void refresh() {
        try {
            usercourseDetailsList.clear();
            query = "SELECT * FROM course";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                usercourseDetailsList.add(new usercourseDetails(
                        resultSet.getString("Cname"),
                        resultSet.getString("Ccode"),
                        resultSet.getString("Ccredit"),
                        resultSet.getString("Cdept"),
                        resultSet.getString("CY/S")));
                usercourseTable.setItems(usercourseDetailsList);
            }


        } catch (Exception ex) {
            System.out.println(ex);;
        }

    }

    private void loadCourseInfo() {
        System.out.println("testing:::::");
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
