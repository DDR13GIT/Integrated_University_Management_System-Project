package sample.admin;
import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class addFacultyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label fxaddfaculty;

    @FXML
    private JFXButton fxSaveButton;

    @FXML
    private JFXButton fxclearbutton;

    @FXML
    private TextField fxname;

    @FXML
    private TextField fxpass;

    @FXML
    private TextField fxcontact;

    @FXML
    private TextField fxmail;

    @FXML
    private TextField fxdept;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Faculty Faculty = null ; //mam said for no change but I did. check this line if not run

    private void getQuery()
    {
        query = "INSERT INTO `facultydatabase`(`FACALTY NAME`,`DEPARTMENT`, `EMAIL ADDRESS`,`CONTACT NO`,`Password`) VALUES (?,?,?,?,?)";

    }


    private void insert()
    {
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fxname.getText());
            preparedStatement.setString(2, fxpass.getText());
            preparedStatement.setString(3, fxcontact.getText());
            preparedStatement.setString(4, fxmail.getText());
            preparedStatement.setString(5, fxdept.getText());
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @FXML
    void clearcall(ActionEvent event)
    {

        fxname.setText(null);
        fxpass.setText(null);
        fxdept.setText(null);
        fxcontact.setText(null);
        fxmail.setText(null);


    }



    @FXML
    void saveincall(ActionEvent event)
    {
        connection = DatabaseHandler.createConnection();
        String name = fxname.getText();
        String password = fxpass.getText(); //int ??
        String department = fxdept.getText();
        String contact = fxcontact.getText();
        String mail = fxmail.getText();

        if (name.isEmpty() || password.isEmpty() || department.isEmpty() || contact.isEmpty() || mail.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        } else {
            getQuery();
            insert();
            Notifications.create()
                    .title("About Us")
                    .text("success")
                    .position(Pos.CENTER)
                    .showInformation(); }
    }

    @FXML
    void initialize() {


    }

}

