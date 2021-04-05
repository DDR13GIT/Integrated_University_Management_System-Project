package sample;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.sql.ResultSet;

public class resultController {
    @FXML
    private Label sidepaneID;

    @FXML
    private Pane GradeSheet;

    @FXML
    private Label ccc;

    @FXML
    private Label cgpa;

    @FXML
    private Label CGPA;

    @FXML
    private Label gpa;

    @FXML
    public Label DMcredit;

    @FXML
    public Label OOPcredit;

    @FXML
    public Label EEEcredit;

    @FXML
    public Label MATHcredit;

    @FXML
    public Label MEcredit;

    @FXML
    public Label SDlabcredit;

    @FXML
    public Label OOPlabcredit;

    @FXML
    public Label EEElabcredit;

    @FXML
    public Label MElabCredit;

    @FXML
    public Label DMgrade;

    @FXML
    public Label OOPgrade;

    @FXML
    public Label EEEgrade;

    @FXML
    public Label MATHgrade;

    @FXML
    public Label MEgrade;

    @FXML
    public Label SDlabgrade;

    @FXML
    public Label OOPlabgrade;

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
    private Label EEElabgrade;

    @FXML
    private Label MElabgrade;

    @FXML
    private Label MElabgp;

    @FXML
    private Circle tinyuserPic;

    @FXML
    private MenuItem sem2_1;

    @FXML
    private MenuButton menuBTN;

    @FXML
    void get2_1(ActionEvent event) {
        menuBTN.setText(sem2_1.getText());
        try {
            updateResult();
        } catch (Exception e) {
            System.out.println(e);
        }

    }



    private void updateResult() {
        System.out.println("testing:::::");
        System.out.println(Controller.typedID);
        String qu = "SELECT * FROM result WHERE ID = '" + Controller.typedID + "'";

        try {
            ResultSet rs = DatabaseHandler.executeQuery(qu, DatabaseHandler.createConnection());
            rs.next();
            String id = rs.getString("ID");
            System.out.println("for check");
            System.out.println(id);
            sidepaneID.setText(id);
            int dmcredit = rs.getInt("DISCRETE");
            DMcredit.setText(String.valueOf(dmcredit));
            System.out.println(dmcredit);
            int oopcredit = rs.getInt("OOP");
            OOPcredit.setText(String.valueOf(oopcredit));
            int eeecredit = rs.getInt("EEE");
            EEEcredit.setText(String.valueOf(eeecredit));
            int mathcredit = rs.getInt("MATH");
            MATHcredit.setText(String.valueOf(mathcredit));
            int mechacredit = rs.getInt("MECHANICAL");
            MEcredit.setText(String.valueOf(mechacredit));
            int sdlabcredit = rs.getInt("SDlab");
            SDlabcredit.setText(String.valueOf(sdlabcredit));
            int ooplabcredit = rs.getInt("OOPlab");
            OOPlabcredit.setText(String.valueOf(ooplabcredit));
            int eeelabcredit = rs.getInt("EEElab");
            EEElabcredit.setText(String.valueOf(eeelabcredit));
            int mechalabcredit = rs.getInt("MECHAlab");
            MElabCredit.setText(String.valueOf(mechacredit));
////////////////////////////////////////////////////////////////////////////////Condition for Grade and Grade point/////////////////////////////////////////
            if (dmcredit >= 80) {
                DMgrade.setText("A+");
                DMgp.setText("4.00");
            } else if (dmcredit < 80 && dmcredit >= 75) {
                DMgrade.setText("A");
                DMgp.setText("3.75");
            } else if (dmcredit < 75 && dmcredit >= 70) {
                DMgrade.setText("A-");
                DMgp.setText("3.50");
            } else if (dmcredit < 70 && dmcredit >= 65) {
                DMgrade.setText("B+");
                DMgp.setText("3.25");
            } else if (dmcredit < 65 && dmcredit >= 60) {
                DMgrade.setText("B");
                DMgp.setText("3.00");
            } else if (dmcredit < 60 && dmcredit >= 55) {
                DMgrade.setText("B-");
                DMgp.setText("2.75");
            } else if (dmcredit < 55 && dmcredit >= 50) {
                DMgrade.setText("C+");
                DMgp.setText("2.50");
            } else if (dmcredit < 50 && dmcredit >= 45) {
                DMgrade.setText("C");
                DMgp.setText("2.25");
            } else if (dmcredit < 45 && dmcredit >= 40) {
                DMgrade.setText("D");
                DMgp.setText("2.00");
            } else if (dmcredit < 40) {
                DMgrade.setText("F");
                DMgp.setText("0.00");
            }

            if (oopcredit >= 80) {
                OOPgrade.setText("A+");
                OOPgp.setText("4.00");
            } else if (oopcredit < 80 && oopcredit >= 75) {
                OOPgrade.setText("A");
                OOPgp.setText("3.75");
            } else if (oopcredit < 75 && oopcredit >= 70) {
                OOPgrade.setText("A-");
                OOPgp.setText("3.50");
            } else if (oopcredit < 70 && oopcredit >= 65) {
                OOPgrade.setText("B+");
                OOPgp.setText("3.25");
            } else if (oopcredit < 65 && oopcredit >= 60) {
                OOPgrade.setText("B");
                OOPgp.setText("3.00");
            } else if (oopcredit < 60 && oopcredit >= 55) {
                OOPgrade.setText("B-");
                OOPgp.setText("2.75");
            } else if (oopcredit < 55 && oopcredit >= 50) {
                OOPgrade.setText("C+");
                OOPgp.setText("2.50");
            } else if (oopcredit < 50 && oopcredit >= 45) {
                OOPgrade.setText("C");
                OOPgp.setText("2.25");
            } else if (oopcredit < 45 && oopcredit >= 40) {
                OOPgrade.setText("D");
                OOPgp.setText("2.00");
            } else if (oopcredit < 40) {
                OOPgrade.setText("F");
                OOPgp.setText("0.00");
            }

            if (eeecredit >= 80) {
                EEEgrade.setText("A+");
                EEEgp.setText("4.00");
            } else if (eeecredit < 80 && eeecredit >= 75) {
                EEEgrade.setText("A");
                EEEgp.setText("3.75");
            } else if (eeecredit < 75 && eeecredit >= 70) {
                EEEgrade.setText("A-");
                EEEgp.setText("3.50");
            } else if (eeecredit < 70 && eeecredit >= 65) {
                EEEgrade.setText("B+");
                EEEgp.setText("3.25");
            } else if (eeecredit < 65 && eeecredit >= 60) {
                EEEgrade.setText("B");
                EEEgp.setText("3.00");
            } else if (eeecredit < 60 && eeecredit >= 55) {
                EEEgrade.setText("B-");
                EEEgp.setText("2.75");
            } else if (eeecredit < 55 && eeecredit >= 50) {
                EEEgrade.setText("C+");
                EEEgp.setText("2.50");
            } else if (eeecredit < 50 && eeecredit >= 45) {
                EEEgrade.setText("C");
                EEEgp.setText("2.25");
            } else if (eeecredit < 45 && eeecredit >= 40) {
                EEEgrade.setText("D");
                EEEgp.setText("2.00");
            } else if (eeecredit < 40) {
                EEEgrade.setText("F");
                EEEgp.setText("0.00");
            }

            if (mathcredit >= 80) {
                MATHgrade.setText("A+");
                MATHgp.setText("4.00");
            } else if (mathcredit < 80 && mathcredit >= 75) {
                MATHgrade.setText("A");
                MATHgp.setText("3.75");
            } else if (mathcredit < 75 && mathcredit >= 70) {
                MATHgrade.setText("A-");
                MATHgp.setText("3.50");
            } else if (mathcredit < 70 && mathcredit >= 65) {
                MATHgrade.setText("B+");
                MATHgp.setText("3.25");
            } else if (mathcredit < 65 && mathcredit >= 60) {
                MATHgrade.setText("B");
                MATHgp.setText("3.00");
            } else if (mathcredit < 60 && mathcredit >= 55) {
                MATHgrade.setText("B-");
                MATHgp.setText("2.75");
            } else if (mathcredit < 55 && mathcredit >= 50) {
                MATHgrade.setText("C+");
                MATHgp.setText("2.50");
            } else if (mathcredit < 50 && mathcredit >= 45) {
                MATHgrade.setText("C");
                MATHgp.setText("2.25");
            } else if (mathcredit < 45 && mathcredit >= 40) {
                MATHgrade.setText("D");
                MATHgp.setText("2.00");
            } else if (mathcredit < 40) {
                MATHgrade.setText("F");
                MATHgp.setText("0.00");
            }

            if (mechacredit >= 80) {
                MEgrade.setText("A+");
                MEgp.setText("4.00");
            } else if (mechacredit < 80 && mechacredit >= 75) {
                MEgrade.setText("A");
                MEgp.setText("3.75");
            } else if (mechacredit < 75 && mechacredit >= 70) {
                MEgrade.setText("A-");
                MEgp.setText("3.50");
            } else if (mechacredit < 70 && mechacredit >= 65) {
                MEgrade.setText("B+");
                MEgp.setText("3.25");
            } else if (mechacredit < 65 && mechacredit >= 60) {
                MEgrade.setText("B");
                MEgp.setText("3.00");
            } else if (mechacredit < 60 && mechacredit >= 55) {
                MEgrade.setText("B-");
                MEgp.setText("2.75");
            } else if (mechacredit < 55 && mechacredit >= 50) {
                MEgrade.setText("C+");
                MEgp.setText("2.50");
            } else if (mechacredit < 50 && mechacredit >= 45) {
                MEgrade.setText("C");
                MEgp.setText("2.25");
            } else if (mechacredit < 45 && mechacredit >= 40) {
                MEgrade.setText("D");
                MEgp.setText("2.00");
            } else if (mechacredit < 40) {
                MEgrade.setText("F");
                MEgp.setText("0.00");
            }

            if (sdlabcredit >= 80) {
                SDlabgrade.setText("A+");
                SDlabgp.setText("4.00");
            } else if (sdlabcredit < 80 && sdlabcredit >= 75) {
                SDlabgrade.setText("A");
                SDlabgp.setText("3.75");
            } else if (sdlabcredit < 75 && sdlabcredit >= 70) {
                SDlabgrade.setText("A-");
                SDlabgp.setText("3.50");
            } else if (sdlabcredit < 70 && sdlabcredit >= 65) {
                SDlabgrade.setText("B+");
                SDlabgp.setText("3.25");
            } else if (sdlabcredit < 65 && sdlabcredit >= 60) {
                SDlabgrade.setText("B");
                SDlabgp.setText("3.00");
            } else if (sdlabcredit < 60 && sdlabcredit >= 55) {
                SDlabgrade.setText("B-");
                SDlabgp.setText("2.75");
            } else if (sdlabcredit < 55 && sdlabcredit >= 50) {
                SDlabgrade.setText("C+");
                SDlabgp.setText("2.50");
            } else if (sdlabcredit < 50 && sdlabcredit >= 45) {
                SDlabgrade.setText("C");
                SDlabgp.setText("2.25");
            } else if (sdlabcredit < 45 && sdlabcredit >= 40) {
                SDlabgrade.setText("D");
                SDlabgp.setText("2.00");
            } else if (sdlabcredit < 40) {
                SDlabgrade.setText("F");
                SDlabgp.setText("0.00");
            }

            if (ooplabcredit >= 80) {
                OOPlabgrade.setText("A+");
                OOPlabgp.setText("4.00");
            } else if (ooplabcredit < 80 && ooplabcredit >= 75) {
                OOPlabgrade.setText("A");
                OOPlabgp.setText("3.75");
            } else if (ooplabcredit < 75 && ooplabcredit >= 70) {
                OOPlabgrade.setText("A-");
                OOPlabgp.setText("3.50");
            } else if (ooplabcredit < 70 && ooplabcredit >= 65) {
                OOPlabgrade.setText("B+");
                OOPlabgp.setText("3.25");
            } else if (ooplabcredit < 65 && ooplabcredit >= 60) {
                OOPlabgrade.setText("B");
                OOPlabgp.setText("3.00");
            } else if (ooplabcredit < 60 && ooplabcredit >= 55) {
                OOPlabgrade.setText("B-");
                OOPlabgp.setText("2.75");
            } else if (ooplabcredit < 55 && ooplabcredit >= 50) {
                OOPlabgrade.setText("C+");
                OOPlabgp.setText("2.50");
            } else if (ooplabcredit < 50 && ooplabcredit >= 45) {
                OOPlabgrade.setText("C");
                OOPlabgp.setText("2.25");
            } else if (ooplabcredit < 45 && ooplabcredit >= 40) {
                OOPlabgrade.setText("D");
                OOPlabgp.setText("2.00");
            } else if (ooplabcredit < 40) {
                OOPlabgrade.setText("F");
                OOPlabgp.setText("0.00");
            }

            if (eeelabcredit >= 80) {
                EEElabgrade.setText("A+");
                EEElabgp.setText("4.00");
            } else if (eeelabcredit < 80 && eeelabcredit >= 75) {
                EEElabgrade.setText("A");
                EEElabgp.setText("3.75");
            } else if (eeelabcredit < 75 && eeelabcredit >= 70) {
                EEElabgrade.setText("A-");
                EEElabgp.setText("3.50");
            } else if (eeelabcredit < 70 && eeelabcredit >= 65) {
                EEElabgrade.setText("B+");
                EEElabgp.setText("3.25");
            } else if (eeelabcredit < 65 && eeelabcredit >= 60) {
                EEElabgrade.setText("B");
                EEElabgp.setText("3.00");
            } else if (eeelabcredit < 60 && eeelabcredit >= 55) {
                EEElabgrade.setText("B-");
                EEElabgp.setText("2.75");
            } else if (eeelabcredit < 55 && eeelabcredit >= 50) {
                EEElabgrade.setText("C+");
                EEElabgp.setText("2.50");
            } else if (eeelabcredit < 50 && eeelabcredit >= 45) {
                EEElabgrade.setText("C");
                EEElabgp.setText("2.25");
            } else if (eeelabcredit < 45 && eeelabcredit >= 40) {
                EEElabgrade.setText("D");
                EEElabgp.setText("2.00");
            } else if (eeelabcredit < 40) {
                EEElabgrade.setText("F");
                EEElabgp.setText("0.00");
            }

            if (mechalabcredit >= 80) {
                MElabgrade.setText("A+");
                MElabgp.setText("4.00");
            } else if (mechalabcredit < 80 && mechalabcredit >= 75) {
                MElabgrade.setText("A");
                MElabgp.setText("3.75");
            } else if (mechalabcredit < 75 && mechalabcredit >= 70) {
                MElabgrade.setText("A-");
                MElabgp.setText("3.50");
            } else if (mechalabcredit < 70 && mechalabcredit >= 65) {
                MElabgrade.setText("B+");
                MElabgp.setText("3.25");
            } else if (mechalabcredit < 65 && mechalabcredit >= 60) {
                MElabgrade.setText("B");
                MElabgp.setText("3.00");
            } else if (mechalabcredit < 60 && mechalabcredit >= 55) {
                MElabgrade.setText("B-");
                MElabgp.setText("2.75");
            } else if (mechalabcredit < 55 && mechalabcredit >= 50) {
                MElabgrade.setText("C+");
                MElabgp.setText("2.50");
            } else if (mechalabcredit < 50 && mechalabcredit >= 45) {
                MElabgrade.setText("C");
                MElabgp.setText("2.25");
            } else if (mechalabcredit < 45 && mechalabcredit >= 40) {
                MElabgrade.setText("D");
                MElabgp.setText("2.00");
            } else if (mechalabcredit < 40) {
                MElabgrade.setText("F");
                MElabgp.setText("0.00");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    @FXML
    void initialize() {
       // updateResult();
    }
}




