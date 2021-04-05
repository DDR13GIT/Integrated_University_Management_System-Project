package sample;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class evaluationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton st;

    @FXML
    private MenuButton S1;

    @FXML
    private MenuItem q1p1;

    @FXML
    private MenuItem q1p2;

    @FXML
    private MenuItem q1p3;

    @FXML
    private MenuButton S2;

    @FXML
    private MenuItem q2p1;

    @FXML
    private MenuItem q2p2;

    @FXML
    private MenuItem q2p3;

    @FXML
    private MenuButton S5;

    @FXML
    private MenuItem q5p1;

    @FXML
    private MenuItem q5p2;

    @FXML
    private MenuItem q5p3;

    @FXML
    private MenuButton S4;

    @FXML
    private MenuItem q4p1;

    @FXML
    private MenuItem q4p2;

    @FXML
    private MenuItem q4p3;

    @FXML
    private MenuButton S3;

    @FXML
    private MenuItem q3p1;

    @FXML
    private MenuItem q3p2;

    @FXML
    private MenuItem q3p3;

    @FXML
    private MenuButton S6;

    @FXML
    private MenuItem q6p1;

    @FXML
    private MenuItem q6p2;

    @FXML
    private MenuItem q6p3;

    @FXML
    private MenuButton S7;

    @FXML
    private MenuItem q7p1;

    @FXML
    private MenuItem q7p2;

    @FXML
    private MenuItem q7p3;

    @FXML
    private MenuButton S8;

    @FXML
    private MenuItem q8p1;

    @FXML
    private MenuItem q8p2;

    @FXML
    private MenuItem q8p3;

    @FXML
    private MenuButton S9;

    @FXML
    private MenuItem q9p1;

    @FXML
    private MenuItem q9p2;

    @FXML
    private MenuItem q9p3;

    @FXML
    private MenuButton S10;

    @FXML
    private MenuItem q10p1;

    @FXML
    private MenuItem q10p2;

    @FXML
    private MenuItem sanzida;

    @FXML
    private MenuItem raqdeer;

    @FXML
    private MenuItem anik;

    @FXML
    private MenuItem samsad;


    @FXML
    private MenuItem q10p3;
    String q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,stc;
    String query = null;
    Connection connection = DatabaseHandler.createConnection();
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;

    @FXML
    void getq1p1(ActionEvent event) {
        S1.setText(q1p1.getText());


    }

    @FXML
    void getq1p2(ActionEvent event) {
        S1.setText(q1p2.getText());

    }

    @FXML
    void getq1p3(ActionEvent event) {
        S1.setText(q1p3.getText());

    }

    @FXML
    void getq2p1(ActionEvent event) {
        S2.setText(q2p1.getText());

    }

    @FXML
    void getq2p2(ActionEvent event) {
        S2.setText(q2p2.getText());

    }

    @FXML
    void getq2p3(ActionEvent event) {
        S2.setText(q2p3.getText());

    }

    @FXML
    void getq3p1(ActionEvent event) {
        S3.setText(q3p1.getText());

    }

    @FXML
    void getq3p2(ActionEvent event) {
        S3.setText(q3p2.getText());

    }

    @FXML
    void getq3p3(ActionEvent event) {
        S3.setText(q3p3.getText());

    }

    @FXML
    void getq4p1(ActionEvent event) {
        S4.setText(q4p1.getText());

    }

    @FXML
    void getq4p2(ActionEvent event) {
        S4.setText(q4p2.getText());

    }

    @FXML
    void getq4p3(ActionEvent event) {
        S4.setText(q4p3.getText());

    }

    @FXML
    void getq5p1(ActionEvent event) {
        S5.setText(q5p1.getText());

    }

    @FXML
    void getq5p2(ActionEvent event) {
        S5.setText(q5p2.getText());

    }

    @FXML
    void getq5p3(ActionEvent event) {
        S5.setText(q5p3.getText());

    }

    @FXML
    void getq6p1(ActionEvent event) {
        S6.setText(q6p1.getText());

    }

    @FXML
    void getq6p2(ActionEvent event) {
        S6.setText(q6p2.getText());

    }

    @FXML
    void getq6p3(ActionEvent event) {
        S6.setText(q6p3.getText());

    }

    @FXML
    void getq7p1(ActionEvent event) {
        S7.setText(q7p1.getText());

    }

    @FXML
    void getq7p2(ActionEvent event) {
        S7.setText(q7p2.getText());

    }

    @FXML
    void getq7p3(ActionEvent event) {
        S7.setText(q7p3.getText());

    }

    @FXML
    void getq8p1(ActionEvent event) {
        S8.setText(q8p1.getText());

    }

    @FXML
    void getq8p2(ActionEvent event) {
        S8.setText(q8p2.getText());

    }

    @FXML
    void getq8p3(ActionEvent event) {
        S8.setText(q8p3.getText());

    }

    @FXML
    void getq9p1(ActionEvent event) {
        S9.setText(q9p1.getText());

    }

    @FXML
    void getq9p2(ActionEvent event) {
        S9.setText(q9p2.getText());

    }

    @FXML
    void getq9p3(ActionEvent event) {
        S9.setText(q9p3.getText());

    }

    @FXML
    void getq10p1(ActionEvent event) {
        S10.setText(q10p1.getText());

    }

    @FXML
    void getq10p2(ActionEvent event) {
        S10.setText(q10p2.getText());

    }

    @FXML
    void getq10p3(ActionEvent event) {
        S10.setText(q10p3.getText());

    }


    @FXML
    void getAnik(ActionEvent event) {
        st.setText(anik.getText());

    }

    @FXML
    void getRaqdeer(ActionEvent event) {
        st.setText(raqdeer.getText());

    }

    @FXML
    void getSamsad(ActionEvent event) {
        st.setText(samsad.getText());

    }

    @FXML
    void getSanzida(ActionEvent event) {
        st.setText(sanzida.getText());

    }

    @FXML
    void submit(ActionEvent event) {
        System.out.println("submit clicked");
        q1=S1.getText();
        q2=S2.getText();
        q3=S3.getText();
        q4=S4.getText();
        q5=S5.getText();
        q6=S6.getText();
        q7=S7.getText();
        q8=S8.getText();
        q9=S9.getText();
        q10=S10.getText();
        stc=st.getText();

        query = "INSERT INTO `evaluationform`(`ID`,`Faculty Name`, `Q1`,`Q2`,`Q3`, `Q4`,`Q5`,`Q6`, `Q7`,`Q8`,`Q9`,`Q10`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Controller.typedID);
            preparedStatement.setString(2, stc);
            preparedStatement.setString(3, q1);
            preparedStatement.setString(4, q2);
            preparedStatement.setString(5, q3);
            preparedStatement.setString(6, q4);
            preparedStatement.setString(7, q5);
            preparedStatement.setString(8, q6);
            preparedStatement.setString(9, q7);
            preparedStatement.setString(10,q8);
            preparedStatement.setString(11, q9);
            preparedStatement.setString(12,q10);
            preparedStatement.execute();

            Notifications.create()
                    .title("About Us")
                    .text("success")
                    .position(Pos.CENTER)
                    .showInformation();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    void initialize() {

    }
}
