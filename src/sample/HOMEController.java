package sample;



import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HOMEController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label NameinDashboard;

    @FXML
    private TableView<Exam> ExamTable;

    @FXML
    private TableColumn<Exam,String > fxExamDate;

    @FXML
    private TableColumn<Exam, String> fxExamTime;

    @FXML
    private TableColumn<Exam, String> fxExamination;

    @FXML
    private TableView<Holiday> HolidayTable;

    @FXML
    private TableColumn<Holiday, String> fxHoliDate;

    @FXML
    private TableColumn<Holiday, String> fxHolidays;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Holiday Holiday = null;
    Exam Exam = null;

    ObservableList<Holiday> holidayList = FXCollections.observableArrayList();
    ObservableList<Exam> examList = FXCollections.observableArrayList();

    public void holidayrefreshView() {
        try {
            holidayList.clear();
            query = "SELECT * FROM holidaysdatabase";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                holidayList.add(new Holiday(
                        resultSet.getString("Date"),
                        resultSet.getString("Holiday")
                ));
                HolidayTable.setItems(holidayList);
            }
        }
        catch (SQLException throwables) { throwables.printStackTrace();}

    }
    public void examrefreshView()
    {
        try {
            examList.clear();
            query = "SELECT * FROM examtimedatabase";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                examList.add(new Exam(
                        resultSet.getString("Date"),
                        resultSet.getString("Time"),
                        resultSet.getString("Exam Name")
                ));
                ExamTable.setItems(examList);
            }
        }
        catch (SQLException throwables) { throwables.printStackTrace();}

    }

    private void loadInfo() {
        System.out.println("Loading info");
        connection = DatabaseHandler.createConnection();
        examrefreshView();
        holidayrefreshView();
        fxExamDate.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        fxExamTime.setCellValueFactory(new PropertyValueFactory<>("examTime"));
        fxExamination.setCellValueFactory(new PropertyValueFactory<>("exam"));
        fxHoliDate.setCellValueFactory(new PropertyValueFactory<>("holiDate"));/// 1st -> fxid, 2nd -> variable(student class)
        fxHolidays.setCellValueFactory(new PropertyValueFactory<>("holiDays"));



    }



    @FXML
    void initialize()
    {
        loadInfo();

    }
}


