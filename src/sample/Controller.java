package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Circle object;
    @FXML
    private Rectangle wall;
    @FXML
    private ToggleButton toggleWallBtn;
    @FXML
    private TextField massInput;
    @FXML
    private TextField forceInput;


    @FXML
    public void initialize() {
        wall.setVisible(false);
    }

    public void toggleWall() {
        if(toggleWallBtn.isSelected()) {
            wall.setVisible(true);
        } else {
            wall.setVisible(false);
        }
    }

    public void applyForce() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setNode(object);
        transition.setByX(100);

        transition.play();
    }
}
