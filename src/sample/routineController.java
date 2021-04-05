package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class routineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void download(ActionEvent event) {
        try {
            System.out.println("opening pdf");
            File file = new File("F:\\iums_project\\src\\sample\\NoticeMaterials\\SemesterWiseRoutine.pdf");
            if(file.exists())
                if(Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(file);
                }
                else
                    System.out.println("file not exist");
        }catch (Exception e){
            System.out.println(e);
        }



    }

    @FXML
    void initialize() {

    }
}
