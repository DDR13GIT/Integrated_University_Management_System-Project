package sample.admin;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.Controller;
import sample.Holiday;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminHomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label NameinDashboard;

    @FXML
    private Label fxadminShift;

    @FXML
    private Label fxadminid;

    @FXML
    private Label fxadminName;

    @FXML
    private Circle fxuserPic;


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

    ObservableList<Holiday> holidayList = FXCollections.observableArrayList();

    private void updateData() {
        System.out.println("testing:::::");
        System.out.println(Controller.typedID);
        String qu = "SELECT * FROM admin WHERE ID = '" + Controller.typedID + "'";

        try {
            ResultSet rs = DatabaseHandler.executeQuery(qu, DatabaseHandler.createConnection());
            while (rs.next()) {
                String id = rs.getString("ID");
                fxadminid.setText(id);
                String name = rs.getString("Admin Name");
                fxadminName.setText(name);
                NameinDashboard.setText(name);
                String adminworkhour = rs.getString("Adimn Work Hour");
                fxadminShift.setText(adminworkhour);

                String userImage = rs.getString("Image");
                System.out.println(userImage);
                Image img = new Image("" + userImage);
                fxuserPic.setFill(new ImagePattern(img));

                //tinyuserPic.setFill(new ImagePattern(img));



            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
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

    private void loadInfo()
    {
        System.out.println("Loading info");
        connection = DatabaseHandler.createConnection();
        holidayrefreshView();


        fxHoliDate.setCellValueFactory(new PropertyValueFactory<>("holiDate"));/// 1st -> fxid, 2nd -> variable(student class)
        fxHolidays.setCellValueFactory(new PropertyValueFactory<>("holiDays"));



    }
    @FXML
    void initialize() {
        updateData();
        loadInfo();

    }
}
