package sample;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.sql.ResultSet;

public class dashboardController {

    public AnchorPane dashboardPane;
    @FXML
    private BorderPane mainPane;

    @FXML
    private Circle tinyuserPic;

    @FXML
    private Label NameinDashboard;

    @FXML
    void ClassRoutineAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("CLASSROUTINE");
        mainPane.setCenter(view);
    }

    @FXML
    void TeacherAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("Teacher Evaluation");
        mainPane.setCenter(view);
    }


    @FXML
    void DashboardAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("USERPROFILE");
        mainPane.setCenter(view);
    }

    @FXML
    void MedicalSupportAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("MEDICALSUPPORT");
        mainPane.setCenter(view);
    }

    @FXML
    void NoticeAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("NOTICE");
        mainPane.setCenter(view);
    }

    @FXML
    void ResultAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("RESULT");
        mainPane.setCenter(view);
    }

    @FXML
    void UniversityFundAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("FUND");
        mainPane.setCenter(view);
    }

    @FXML
    void CGPACalculatorAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("CGPACALCULATOR");
        mainPane.setCenter(view);

    }
    @FXML
    void locationAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("GoogleMap");
        mainPane.setCenter(view);

    }
    @FXML
    void coursesAction(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("userCourses");
        mainPane.setCenter(view);
    }

    @FXML
    void homeBTNAction(ActionEvent event) {

        FxmlLoader object = new FxmlLoader();
        System.out.println("you clicked me");
        Pane view = object.getPage("HOME");
        mainPane.setCenter(view);

    }


    @FXML
    void logoutBTNAction(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dashboardPane.getChildren().setAll(pane);
    }


    @FXML
    void initialize() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("HOME");
        mainPane.setCenter(view);
        String q1 = "SELECT `Picture` FROM databasefile  WHERE ID = '" + Controller.typedID + "'";
        try {
            ResultSet rs1 = DatabaseHandler.executeQuery(q1, DatabaseHandler.createConnection());
            while (rs1.next()) {
                String userImage = rs1.getString("picture");
                System.out.println(userImage);
                Image img = new Image("" + userImage);
                tinyuserPic.setFill(new ImagePattern(img));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

