package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;
    public Pane getPage(String filename) {
        try {

            URL fileUrl = Main.class.getResource("/sample/" + filename + ".fxml");
            if (fileUrl == null) {
                throw new FileNotFoundException("fxml file not found");
            }
            view = FXMLLoader.load(fileUrl);
        } catch (Exception e) {
            System.out.println("no page " + filename + "  please check fxml loader");
        }
        return view;
    }
}


