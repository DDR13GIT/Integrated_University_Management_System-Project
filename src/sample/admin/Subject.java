package sample.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Subject {
    String id;
    int discrete_num;
    int oop_num;
    int eee_num;
    int math_num;
    int mecha_num;
    int sdlab_num;
    int ooplab_num;
    int eeelab_num;
    int melab_num;
    Button btn;

    public Subject(String id, int discrete_num, int oop_num, int eee_num, int math_num, int mecha_num, int sdlab_num, int ooplab_num, int eeelab_num, int melab_num) {
        this.id = id;
        this.oop_num = oop_num;
        this.discrete_num = discrete_num;
        this.eee_num = eee_num;
        this.math_num = math_num;
        this.mecha_num = mecha_num;
        this.sdlab_num = sdlab_num;
        this.ooplab_num = ooplab_num;
        this.eeelab_num = eeelab_num;
        this.melab_num = melab_num;
        this.btn = new Button("Detailed View");

        btn.setOnAction(event -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/sample/admin/adminResultDetailed.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
    }

    public String getId() {
        return id;
    }

    public int getDiscrete_num() {
        return discrete_num;
    }

    public void setDiscrete_num(int discrete_num) {
        this.discrete_num = discrete_num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOop_num() {
        return oop_num;
    }

    public void setOop_num(int oop_num) {
        this.oop_num = oop_num;
    }

    public int getEee_num() {
        return eee_num;
    }

    public void setEee_num(int eee_num) {
        this.eee_num = eee_num;
    }

    public int getMath_num() {
        return math_num;
    }

    public void setMath_num(int math_num) {
        this.math_num = math_num;
    }

    public int getMecha_num() {
        return mecha_num;
    }

    public void setMecha_num(int mecha_num) {
        this.mecha_num = mecha_num;
    }

    public int getSdlab_num() {
        return sdlab_num;
    }

    public void setSdlab_num(int sdlab_num) {
        this.sdlab_num = sdlab_num;
    }

    public int getOoplab_num() {
        return ooplab_num;
    }

    public void setOoplab_num(int ooplab_num) {
        this.ooplab_num = ooplab_num;
    }

    public int getEeelab_num() {
        return eeelab_num;
    }

    public void setEeelab_num(int eeelab_num) {
        this.eeelab_num = eeelab_num;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public int getMelab_num() {
        return melab_num;
    }

    public void setMelab_num(int melab_num) {
        this.melab_num = melab_num;
    }
}
