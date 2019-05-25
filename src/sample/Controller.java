package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Controller {

    Law1 law1 = new Law1();
    Law2 law2 = new Law2();
    Law3 law3 = new Law3();

    @FXML
    private Circle object;
    @FXML
    private Rectangle wall;
    @FXML
    private TextField massInput;
    @FXML
    private TextField forceInput;
    @FXML
    private TextField velocityInput;
    @FXML
    private Label title;
    @FXML
    private Button start;
    @FXML
    private MenuButton menuBtn;
    @FXML
    private TextField timeInput;


    @FXML
    public void initialize() {
        wall.setVisible(false);
        massInput.setDisable(true);
        forceInput.setDisable(true);
        velocityInput.setDisable(true);
        timeInput.setDisable(true);
        start.setDisable(true);
    }

    public void reset() {
        if(getCase() == 1) law1.reset(this.object);
        else if(getCase() == 2) law2.reset(this.object);
        else law3.reset(this.object);
    }

    public int getCase() {
        String s = title.getText();
        if (s.equals("First Law")) return 1;
        else if (s.equals("Second Law")) return 2;
        else if (s.equals("Third Law")) return 3;
        return 0;
    }

    @FXML
    public void start() {
        int choice = getCase();
        if (choice == 1) {
            action1();
        } else if (choice == 2) {
            action2();
        } else if (choice == 3) {
            action3();
        }
    }


    public void law1() {
        title.setText("First Law");
        menuBtn.setText("First Law");
        forceInput.setText("0");
        velocityInput.setDisable(false);
        massInput.setDisable(true);
        forceInput.setDisable(true);
        timeInput.setDisable(true);
        wall.setVisible(false);
        start.setDisable(false);
    }

    public void law2() {
        title.setText("Second Law");
        menuBtn.setText("Second Law");
        velocityInput.setDisable(true);
        forceInput.setDisable(false);
        massInput.setDisable(false);
        timeInput.setDisable(false);
        wall.setVisible(false);
        start.setDisable(false);
    }

    public void law3() {
        title.setText("Third Law");
        menuBtn.setText("Third Law");
        object.setTranslateX(0);
        velocityInput.setDisable(false);
        forceInput.setDisable(true);
        massInput.setDisable(true);
        timeInput.setDisable(true);
        start.setDisable(false);
        wall.setVisible(true);
    }

    public void action1() {
        double v = Double.parseDouble(velocityInput.getText());
        law1.start(this.object, v, 0, 0, 0);
    }

    public void action2() {
        double time = Double.parseDouble(timeInput.getText());
        double m = Double.parseDouble(massInput.getText());
        double force = Double.parseDouble(forceInput.getText());
        law2.start(this.object, 0, time, m, force);
    }

    public void action3() {
        double v = Double.parseDouble(velocityInput.getText());
        law3.start(this.object, v, 0,0,0);
    }
}