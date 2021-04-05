package sample;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.admin.adminUserProfileController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class medicalController {


    @FXML
    private Text tips1;

    @FXML
    private Text tips2;

    @FXML
    private Text tips3;

    @FXML
    private Text tips4;


    @FXML
    private TableView<prescriptionDetails> prescriptontTable;

    @FXML
    private TableColumn<prescriptionDetails, String> tableTitle;


    String medicalTips[] = {"Reduce intake of harmful fats", "Avoid harmful use of alcohol", "Check your blood pressure regularly",
            " Drink only safe water", "Clean your hands properly", "Get enough sleep", "Avoid bright lights before sleep",
            "Take vitamin D3 if you don’t get much sun exposure", "Eat vegetables and fruits"};

    Random r = new Random();

    public void setTips() {
        try {
            int x = 5 - r.nextInt() % 4;
            tips1.setText(medicalTips[x]);
            x = 5 - r.nextInt() % 4;
            tips2.setText(medicalTips[x]);
            x = 5 - r.nextInt() % 4;
            tips3.setText(medicalTips[x]);
            x = 5 - r.nextInt() % 4;
            tips4.setText(medicalTips[x]);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void uploadPresciptonBtn() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/addPrescription.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(adminUserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int index;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    stdNoticeDetails stdNoticeDetails = null;
    ObservableList<prescriptionDetails> prescriptionDetailsObservableList = FXCollections.observableArrayList();


    @FXML
    void getfresh() {
        try {
            prescriptionDetailsObservableList.clear();
            query = "SELECT * FROM prescription";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                prescriptionDetailsObservableList.add(new prescriptionDetails(resultSet.getString("Prescription Title")));
                prescriptontTable.setItems(prescriptionDetailsObservableList);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void openPres() throws SQLException, IOException {
        index = prescriptontTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String from_table = tableTitle.getCellData(index);
        String pdfPath = "";

        String query = "SELECT `Link` FROM `prescription` WHERE `Prescription Title` = '" + from_table + "'";
        ResultSet rs2 = DatabaseHandler.executeQuery(query, DatabaseHandler.createConnection());
        while (rs2.next()) {
            pdfPath = rs2.getString("Link");
        }
        System.out.println("opening pdf");
        File file = new File(pdfPath);
        if (file.exists())
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else
                System.out.println("file not exist");
    }

    private void loadmedicalInfo() {
        try {
            System.out.println("testing:::::");

            connection = DatabaseHandler.createConnection();
            getfresh();
            tableTitle.setCellValueFactory(new PropertyValueFactory<>("title")); //variable name
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deletePres() {
        index = prescriptontTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String from_table = tableTitle.getCellData(index);
        Connection conn;
        PreparedStatement pst;
        conn = DatabaseHandler.createConnection();
        String sql = "delete from prescription where `Prescription Title` = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, from_table);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Are you sure?");
            getfresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void dr1() throws MessagingException {
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

        Message message = prepareMessage(session, myAccountEmail, "190104058@aust.edu");
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String rcpt) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(rcpt));
        message.setSubject("Medical Appointment through IUMS");
        message.setText(String.valueOf("I am sick. Give me appointment."));
        return message;
    }

    @FXML
    void initialize() {
        setTips();
        loadmedicalInfo();
    }

}


