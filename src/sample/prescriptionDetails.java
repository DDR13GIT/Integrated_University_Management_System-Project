package sample;

import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class prescriptionDetails {
    String title;
    String link;
    Button btn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public prescriptionDetails(String title) {
        this.title = title;
        this.link = link;
        this.btn =  new Button("Open");

        btn.setOnAction(event -> {
            System.out.println("opening pdf");
            File file = new File("C:\\Users\\ddroy\\Desktop\\iums_project\\src\\sample\\images\\pres.jpg");
            if (file.exists())
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else
                    System.out.println("file not exist");
        });
    }
}
