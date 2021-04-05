package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class cgpaCalculatorController {
    @FXML
    private Label cgpaScore;

    @FXML
    private JFXTextField s1;

    @FXML
    private JFXTextField s2;

    @FXML
    private JFXTextField s3;

    @FXML
    private JFXTextField s4;

    @FXML
    private JFXTextField s5;

    @FXML
    private JFXTextField s6;

    @FXML
    private JFXTextField s7;

    @FXML
    private JFXTextField s8;

    @FXML
    private JFXTextField s9;


    @FXML
    void calculateCGPA(ActionEvent event) {

        double d_double = Double.parseDouble(s1.getText());
        double o_double = Double.parseDouble(s2.getText());
        double b_double = Double.parseDouble(s3.getText());
        double m_double = Double.parseDouble(s4.getText());
        double bme_double = Double.parseDouble(s5.getText());
        double sd1_double = Double.parseDouble(s6.getText());
        double ol_double = Double.parseDouble(s7.getText());
        double beeel_double = Double.parseDouble(s8.getText());
        double ed_double = Double.parseDouble(s9.getText());
      double theory = (d_double+o_double+b_double+m_double+bme_double)*3.00;
      double lab = (sd1_double+ol_double+beeel_double)*1.50;
      double mechalab = ed_double*0.75;
      double fulllab = lab+mechalab;
      double result = (theory+fulllab)/20.25;
      double roundOff = Math.round(result*100.00)/100.00;
      cgpaScore.setText(String.valueOf(roundOff));

    }

    @FXML
    void initialize() {

    }
}
