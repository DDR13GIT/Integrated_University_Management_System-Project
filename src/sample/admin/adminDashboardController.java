package sample.admin;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.Controller;
import sample.FxmlLoader;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class adminDashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane admindashPane;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Pane adminDashboardpane;

    @FXML
    private ImageView homeBtn;

    @FXML
    private ImageView NotificationBtn;

    @FXML
    private ImageView LogoutBtn;


    @FXML
    private Circle tuserPic;

    @FXML
    void adminClassRoutineAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminRoutine");
        mainPane.setCenter(view);
    }

    @FXML
    void adminCourseAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/Courses");
        mainPane.setCenter(view);
    }

    @FXML
    void adminDashboardAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminHOME");
        mainPane.setCenter(view);
    }

    @FXML
    void adminFacultyAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/facultyInfo");
        mainPane.setCenter(view);
    }

    @FXML
    void adminNoticeAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminNOTICE");
        mainPane.setCenter(view);
    }

    @FXML
    void adminResultAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminRESULT");
        mainPane.setCenter(view);
    }

    @FXML
    void adminStudentAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminUSERPROFILE");
        mainPane.setCenter(view);
    }

    @FXML
    void adminUniversityFundAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminFUND");
        mainPane.setCenter(view);
    }

    @FXML
    void adminhomeBTNAction(ActionEvent event) {

        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("admin/adminHOME");
        mainPane.setCenter(view);
    }

    @FXML
    void adminlogoutBTNAction(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        admindashPane.getChildren().setAll(pane);
    }

    @FXML
    void initialize() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("admin/adminHOME");
        mainPane.setCenter(view);
        String q1 = "SELECT `Picture` FROM admin  WHERE ID = '" + Controller.typedID + "'";
        try {
            ResultSet rs1 = DatabaseHandler.executeQuery(q1, DatabaseHandler.createConnection());
            while (rs1.next()) {
                String userImage = rs1.getString("picture");
                System.out.println(userImage);
                Image img = new Image("" + userImage);
                tuserPic.setFill(new ImagePattern(img));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
