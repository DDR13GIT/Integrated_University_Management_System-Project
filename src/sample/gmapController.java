package sample;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class gmapController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView gmap;
    private WebEngine e;

    @FXML
    void initialize() {
        e = gmap.getEngine();
        e.load("https://www.google.com/maps/place/Ahsanullah+University+of+Science+and+Technology/@23.763822,90.4044851,17z/data=!3m1!4b1!4m5!3m4!1s0x3755c77decb5f845:0xc2eadd2f3b867792!8m2!3d23.763822!4d90.4066738");
    }
}
