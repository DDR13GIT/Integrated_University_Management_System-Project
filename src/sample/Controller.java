package sample;  //login ar dashboard er sob code

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {
    public TextField FatherName;
    public TextField FullName;
    public AnchorPane loginpane;
    public JFXRadioButton studentRBtn;
    public JFXRadioButton adminRBtn;
    public JFXButton aboutUS;
    public TextField RequestID;
    public TextField Requestemail;
    public Text statusOfRequest;
    public JFXButton submitReqButton;

    public JFXRadioButton rememberMe;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXTextField IdField;

    @FXML
    private JFXPasswordField PasswordField;

    @FXML
    private JFXButton SigninBtn;

    @FXML
    void editInfo() {
        FatherName.setEditable(true);
        System.out.println("Hi");
    }

    public static String typedID = null;
    String id = null, pass = null;

    @FXML
    void signInCall(ActionEvent event) throws IOException {

        System.out.println("sign in button clicked");
        typedID = IdField.getText();
        String typedPassword = PasswordField.getText();
        if (studentRBtn.isSelected()) {
            String q1 = "SELECT * FROM databasefile  WHERE ID = '" + typedID + "'";

            try {
                ResultSet rs1 = DatabaseHandler.executeQuery(q1, DatabaseHandler.createConnection());

                while (rs1.next()) {
                    id = rs1.getString("ID");
                    pass = rs1.getString("Password");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            if (typedID.equals(id) && typedPassword.equals(pass)) {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("DASHBOARD.fxml"));
                loginpane.getChildren().setAll(pane);


            } else {
                System.out.println("invalid");
                Notifications.create()
                        .title("Warning")
                        .text("Invalid ID/Password")
                        .showError();
            }
        } else if (adminRBtn.isSelected()) {
            String q1 = "SELECT * FROM admin  WHERE ID = '" + typedID + "'";
            id = null;
            pass = null;
            try {
                ResultSet rs1 = DatabaseHandler.executeQuery(q1, DatabaseHandler.createConnection());

                while (rs1.next()) {
                    id = rs1.getString("ID");
                    System.out.println(id);
                    pass = rs1.getString("Password");
                    System.out.println(pass);

                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            if (typedID.equals(id) && typedPassword.equals(pass)) {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("admin/adminDASHBOARD.fxml"));
                loginpane.getChildren().setAll(pane);


            } else {
                System.out.println("invalid");
                Notifications.create()
                        .title("Warning")
                        .text("Invalid ID/Password")
                        .showError();
            }
        }
    }


    @FXML
    void sendReqButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sendRequest.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Open Account in IUMS");
        stage.show();
    }


    @FXML
    void submitRequest() {

        try {
            String q3 = "INSERT INTO newaccountrequest (ID, Email) VALUES (?,?)";
            try {
                PreparedStatement pst = DatabaseHandler.createConnection().prepareStatement(q3);
                pst.setString(1, RequestID.getText());
                pst.setString(2, Requestemail.getText());
                pst.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
            statusOfRequest.setText("Successfully Applied");
        } catch (Exception e) {
            statusOfRequest.setText("Opps! Something is wrong.");
            System.out.println(e);
        }
    }

    @FXML
    void aboutUsPressed() {
        Notifications.create()
                .title("About Us")
                .text("\nIUMS Project For software development lab 2.1\n Debopriya Deb roy(190104065) \n Maisha Musarrat Nabila(190104058) \n Susmoy Ahmed(180104145)\n")
                .position(Pos.CENTER)
                .showInformation();
    }

    @FXML
    void forgotPasswordAction() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FORGETPASS.fxml"));
        loginpane.getChildren().setAll(pane);
    }

    @FXML
    void initialize() throws IOException {


    }


}

