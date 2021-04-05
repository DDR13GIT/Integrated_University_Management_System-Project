package sample.admin;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class addMarkController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TextField eee;

    @FXML
    private TextField math;

    @FXML
    private TextField mecha;

    @FXML
    private TextField sdl;

    @FXML
    private TextField oopl;

    @FXML
    private TextField dis;

    @FXML
    private TextField mel;

    @FXML
    private TextField eeel;

    @FXML
    private TextField oop;

    @FXML
    private TextField id;

    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;

    @FXML
    void clear(ActionEvent event) {
        id.setText(null);
        dis.setText(null);
        oop.setText(null);
        eee.setText(null);
        math.setText(null);
        mecha.setText(null);
        sdl.setText(null);
        oopl.setText(null);
        eeel.setText(null);
        mel.setText(null);

    }

    @FXML
    void save(ActionEvent event) {
        connection = DatabaseHandler.createConnection();
        String ID = id.getText();
        int disnum = parseInt(dis.getText());
        int oopnum = parseInt(oop.getText());
        int eeenum = parseInt(eee.getText());
        int mathnum = parseInt(math.getText());
        int mechanum = parseInt(mecha.getText());
        int sdnum = parseInt(sdl.getText());
        int ooplnum = parseInt(oopl.getText());
        int eeelnum = parseInt(eeel.getText());
        int melnum = parseInt(mel.getText());

            getQuery();
            insert();
            Notifications.create()
                    .title("About Us")
                    .text("success")
                    .position(Pos.CENTER)
                    .showInformation();

        }
    private void insert() {
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id.getText());
            preparedStatement.setString(2, dis.getText());
            preparedStatement.setString(3, oop.getText());
            preparedStatement.setString(4, eee.getText());
            preparedStatement.setString(5, math.getText());
            preparedStatement.setString(6, mecha.getText());
            preparedStatement.setString(7, sdl.getText());
            preparedStatement.setString(8, oopl.getText());
            preparedStatement.setString(9, eeel.getText());
            preparedStatement.setString(10, mel.getText());
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void getQuery() {
        query = "INSERT INTO `result`(`ID`,`DISCRETE`,`OOP`,`EEE`,`MATH`,`MECHANICAL`,`Sdlab`,`OOPlab`,`EEElab`,`MECHAlab`) VALUES (?,?,?,?,?,?,?,?,?,?)";

    }

    @FXML
    void initialize() {


    }
}
