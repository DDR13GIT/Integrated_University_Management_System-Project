package sample.admin;

import Database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class adminResultDetailedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ccc;

    @FXML
    private Label cgpa;

    @FXML
    private Label CGPA;

    @FXML
    private Label gpa;

    @FXML
    private Label DMgp;

    @FXML
    private Label OOPgp;

    @FXML
    private Label EEEgp;

    @FXML
    private Label MATHgp;

    @FXML
    private Label MEgp;

    @FXML
    private Label SDlabgp;

    @FXML
    private Label OOPlabgp;

    @FXML
    private Label EEElabgp;

    @FXML
    private Label MElabgp;

    @FXML
    private ImageView studentimage;

    private void updateResult() {
        System.out.println("testing:::::");
        System.out.println(Controller.typedID);
        String qu = "SELECT * FROM result WHERE ID = '" + Controller.typedID + "'";

        try {
            ResultSet rs = DatabaseHandler.executeQuery(qu, DatabaseHandler.createConnection());
            rs.next();


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @FXML
    void initialize() {

    }
}
