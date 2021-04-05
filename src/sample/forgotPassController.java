package sample;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Notifications;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class forgotPassController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane forgetmainPane;

    @FXML
    private Pane forgotPassPane;

    @FXML
    private TextField recipientEmail;

    @FXML
    private JFXButton sendOTP;

    @FXML
    private Pane resetPassPane;

    @FXML
    private TextField newPass;

    @FXML
    private JFXButton passUpdate;

    @FXML
    private TextField conPass;

    @FXML
    private TextField typedOTP;

    @FXML
    private JFXButton passUpdate1;

    @FXML
    private TextField Uid;

    @FXML
    private JFXButton back2LoginBtn;


    @FXML
    void passUpdateBtn(ActionEvent event) {
        System.out.println("update button clicked");
        Connection con = DatabaseHandler.createConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update `databasefile` SET `Password`=? WHERE `ID` = '" + Uid.getText() + "'");
            stmt.setString(1, newPass.getText());
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");
            Notifications.create()
                    .title("Notification")
                    .text(i + " records updated")
                    .showConfirm();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    int RandomOTP;
    String recipient;
    @FXML
    void sendOTPBtn() throws MessagingException {
        recipient = recipientEmail.getText();
        Random r = new Random();
        RandomOTP = r.nextInt(99999);
        sendEmail();
    }

    void sendEmail() throws MessagingException {
        forgotPassPane.setVisible(false);
        resetPassPane.setVisible(true);
        System.out.println("Sending processing::::");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "";
        String password = "";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recipient, RandomOTP);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String rcpt, int RandomOTP) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(rcpt));
        message.setSubject("OTP from IUMS Account Creation Widzard");
        message.setText(String.valueOf(RandomOTP));
        return message;
    }

    @FXML
    void verifyBtn() {
        if (RandomOTP == parseInt(typedOTP.getText())) {
            newPass.setDisable(false);
            conPass.setDisable(false);
            Uid.setDisable(false);
        }
    }


    @FXML
    void back2LoginAction() {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("LOGIN.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        forgetmainPane.getChildren().setAll(pane);
    }
}
