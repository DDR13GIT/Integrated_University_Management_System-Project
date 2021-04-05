package sample;

import Database.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.controlsfx.control.Notifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileController {

    public Label FullName;
    public Circle userPic;
    public ImageView userPicture;
    public Circle tinyuserPic;
    public JFXButton updateInfoBtn;
    public JFXButton editBtn;
    public JFXButton cancelBtn;
    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;

    @FXML
    private TextField FatherName;

    @FXML
    private TextField MotherName;

    @FXML
    private TextField BirthDate;

    @FXML
    private TextField Gender;

    @FXML
    private TextField Religion;

    @FXML
    private TextField BloodGroup;

    @FXML
    private Label CGPA;

    @FXML
    private Label Advisor;

    @FXML
    private TextField GuardianName;

    @FXML
    private TextField GuardianMobile;

    @FXML
    private TextField GuardianPhone;

    @FXML
    private TextField GuardianEmail;

    @FXML
    private TextField MobileNumber;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField Email;

    @FXML
    private TextArea PresentAddress;

    @FXML
    private TextArea PermanentAddress;

    @FXML
    private Label sidepaneID;

    @FXML
    private Label sidepaneName;

    @FXML
    private Label sidepaneSemester;

    @FXML
    private Label sidepaneYearSemester;

    String IdFromSignIn;

    public void getInfoFromSignInBtn(String Id) {
        IdFromSignIn = Id;

    }

    private void updateData() {
        System.out.println("testing:::::");
        System.out.println(Controller.typedID);
        String qu = "SELECT * FROM databasefile WHERE ID = '" + Controller.typedID + "'";

        try {
            ResultSet rs = DatabaseHandler.executeQuery(qu, DatabaseHandler.createConnection());
            while (rs.next()) {
                String id = rs.getString("ID");
                sidepaneID.setText(id);
                String name = rs.getString("Full Name");
                sidepaneName.setText(name);
                String semester = rs.getString("Semester");
                sidepaneSemester.setText(semester);
                String YearSemester = rs.getString("Year/Semester");
                sidepaneYearSemester.setText(YearSemester);

                String FullNameDB = rs.getString("Full Name");
                FullName.setText(FullNameDB);
                String FirstNameDB = rs.getString("First Name");
                FirstName.setText(FirstNameDB);
                String LastNameDB = rs.getString("Last Name");
                LastName.setText(LastNameDB);
                String FatherNameDB = rs.getString("Father Name");
                FatherName.setText(FatherNameDB);
                System.out.println(FatherNameDB);
                String MotherNameDB = rs.getString("Mother Name");
                MotherName.setText(MotherNameDB);
                String BirthDateDB = rs.getString("Birth Date");
                BirthDate.setText(BirthDateDB);
                String GenderDB = rs.getString("Gender");
                Gender.setText(GenderDB);
                String ReligionDB = rs.getString("Religion");
                Religion.setText(ReligionDB);
                String BloodGroupDB = rs.getString("Blood Group");
                BloodGroup.setText(BloodGroupDB);
                String cgpaDB = rs.getString("CGPA");
                CGPA.setText(cgpaDB);
                String AdvisorDB = rs.getString("Advisor");
                Advisor.setText(AdvisorDB);


                String GuardianNameDB = rs.getString("Guardian Name");
                GuardianName.setText(GuardianNameDB);
                String GuardianMobileDB = rs.getString("Guardian Mobile");
                GuardianMobile.setText(GuardianMobileDB);
                String GuardianPhoneDB = rs.getString("Guardian Phone");
                GuardianPhone.setText(GuardianPhoneDB);
                String GuardianEmailDB = rs.getString("Guardian Email");
                GuardianEmail.setText(GuardianEmailDB);


                String MobileNumberDB = rs.getString("Mobile Number");
                MobileNumber.setText(MobileNumberDB);
                String PhoneNumberDB = rs.getString("Phone Number");
                PhoneNumber.setText(PhoneNumberDB);
                String EmailDB = rs.getString("Email");
                Email.setText(EmailDB);
                String PresentAddressDB = rs.getString("Present Address");
                PresentAddress.setText(PresentAddressDB);
                String PermenantAddressDB = rs.getString("Present Address");
                PermanentAddress.setText(PermenantAddressDB);

                String userImage = rs.getString("picture");
                System.out.println(userImage);
                Image img = new Image("" + userImage);
                userPic.setFill(new ImagePattern(img));
                tinyuserPic.setFill(new ImagePattern(img));


            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void makeEditable() {
        FirstName.setEditable(true);
        LastName.setEditable(true);
        FatherName.setEditable(true);
        MotherName.setEditable(true);
        BirthDate.setEditable(true);
        Gender.setEditable(true);
        Religion.setEditable(true);
        BloodGroup.setEditable(true);
        updateInfoBtn.setVisible(true);
        GuardianName.setEditable(true);
        GuardianMobile.setEditable(true);
        GuardianPhone.setEditable(true);
        GuardianEmail.setEditable(true);
        MobileNumber.setEditable(true);
        PhoneNumber.setEditable(true);
        Email.setEditable(true);
        PermanentAddress.setEditable(true);
        PresentAddress.setEditable(true);
    }

    void makeDisable() {
        FirstName.setEditable(false);
        LastName.setEditable(false);
        FatherName.setEditable(false);
        MotherName.setEditable(false);
        BirthDate.setEditable(false);
        Gender.setEditable(false);
        Religion.setEditable(false);
        BloodGroup.setEditable(false);
        updateInfoBtn.setVisible(false);
        GuardianName.setEditable(false);
        GuardianMobile.setEditable(false);
        GuardianPhone.setEditable(false);
        GuardianEmail.setEditable(false);
        MobileNumber.setEditable(false);
        PhoneNumber.setEditable(false);
        Email.setEditable(false);
        PermanentAddress.setEditable(false);
        PresentAddress.setEditable(false);
    }

    @FXML
    void cancelButton() {
        updateData();
        editBtn.setVisible(true);
        makeDisable();
        cancelBtn.setVisible(false);
        updateInfoBtn.setVisible(false);

        System.out.println("cancel clicked");
    }

    //1 specifies the first parameter in the query i.e. name
    @FXML
    void updateInfoButton(){
        System.out.println("update button clicked");
        Connection con = DatabaseHandler.createConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update databasefile SET `Email`=?,`Mobile number`=?,`Present Address`=?,`Gender`=?,`Blood Group`=?,`Religion`=?,`Father Name`=?,`Mother name`=?,`Phone Number`=?,`Permanent Address`=?,`Guardian Name`=?,`Guardian Mobile`=?,`Guardian Phone`=?,`Guardian Email`=?,`First Name`=?,`Last Name`=?,`Birth Date`=? WHERE ID = '" + Controller.typedID + "'");
            stmt.setString(1, Email.getText());
            stmt.setString(2, MobileNumber.getText());
            stmt.setString(3, PresentAddress.getText());
            stmt.setString(4, Gender.getText());
            stmt.setString(5, BloodGroup.getText());
            stmt.setString(6, Religion.getText());
            stmt.setString(7, FatherName.getText());
            stmt.setString(8, MotherName.getText());
            stmt.setString(9, PhoneNumber.getText());
            stmt.setString(10, PermanentAddress.getText());
            stmt.setString(11, GuardianName.getText());
            stmt.setString(12, GuardianMobile.getText());
            stmt.setString(13, GuardianPhone.getText());
            stmt.setString(14, GuardianEmail.getText());
            stmt.setString(15, FirstName.getText());
            stmt.setString(16, LastName.getText());
            stmt.setString(17, BirthDate.getText());
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");
            Notifications.create()
                    .title("Notification")
                    .text(i + " records updated")
                    .showConfirm();
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }




    }

    @FXML
    void editButton() {
        makeEditable();
        editBtn.setVisible(false);
        cancelBtn.setVisible(true);
        updateInfoBtn.setVisible(true);
        System.out.println("edit clicked");
    }

    @FXML
    void initialize() {
        updateData();
        updateInfoBtn.setVisible(false);
        editBtn.setVisible(true);
        cancelBtn.setVisible(false);
    }
}


