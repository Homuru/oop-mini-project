package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Controller {

    private Object ob = new Object();
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
    private TextField velocityInput;
    @FXML
    private TextArea output;
    @FXML
    private Label title;
    @FXML
    private Button start;
    @FXML
    private MenuButton menuBtn;
    @FXML
    private TextField timeInput;

    private TranslateTransition transition = new TranslateTransition();


    @FXML
    public void initialize() {
        wall.setVisible(false);
        massInput.setDisable(true);
        forceInput.setDisable(true);
        velocityInput.setDisable(true);
        output.setDisable(true);
        timeInput.setDisable(true);
        start.setDisable(true);
    }

    @FXML
    public void toggleWall() {
        if (toggleWallBtn.isSelected()) {
            wall.setVisible(true);
        } else {
            wall.setVisible(false);
        }
    }

    public void move(Node object, double s, double time) {
        this.transition.setDuration(Duration.seconds(time));
        this.transition.setNode(object);
        this.transition.setByX(s);
        this.transition.play();
    }

    public void action1() {
        double v = Double.parseDouble(velocityInput.getText());
        ob.setV(v);
        output.setText("\n" + "v0 = " + velocityInput.getText());
        toggleWallBtn.setDisable(true);
        if (wall.isVisible())
            move(this.object, 400, 400 / ob.getV());
        else move(this.object, 600, 600 / ob.getV());
    }

    @FXML
    public void start() {
        if (laws() == 1) {
            action1();
        } else if (laws() == 2) {
            action2();
        } else if (laws() == 3) {
            action3();
        }
    }

    public void reset() {
        toggleWallBtn.setDisable(false);
        output.setText(null);
        transition.stop();
        object.setTranslateX(0);
    }

    public void law1() {
        title.setText("First Law");
        menuBtn.setText("First Law");
        forceInput.setText("0");
        velocityInput.setDisable(false);
        start.setDisable(false);
        output.setDisable(false);
    }

    public void law2() {
        title.setText("Second Law");
        menuBtn.setText("Second Law");
        velocityInput.setDisable(true);
        forceInput.setDisable(false);
        massInput.setDisable(false);
        timeInput.setDisable(false);
        start.setDisable(false);
    }

    public void law3() {
        title.setText("Third Law");
        menuBtn.setText("Third Law");
        velocityInput.setDisable(true);
        forceInput.setDisable(false);
        massInput.setDisable(false);
        timeInput.setDisable(false);
        start.setDisable(false);
        wall.setVisible(true);
    }


    public int laws() {
        String s = title.getText();
        if (s.equals("First Law")) return 1;
        else if (s.equals("Second Law")) return 2;
        else if (s.equals("Third Law")) return 3;
        return 0;
    }

    public void action2() {    //check lai

        double time = Double.parseDouble(timeInput.getText());
        double mass = Double.parseDouble(massInput.getText());
        double frictionForce = Physics.getFrictionForce(mass);

        ob.setMass(mass);
        double force = Double.parseDouble(forceInput.getText());
        double acc = Physics.getAcceleration(force - frictionForce, mass);
        double s1 = Physics.getDistance(0, acc, time);
        this.move(this.object, s1, time);

        double v1 = Physics.getVelocity(0, acc, time);
        double acc2 = Physics.getAcceleration(frictionForce, mass);
        double time2 = Physics.getTime(0, v1, -acc2);
        System.out.println(time2);
        double s2 = Physics.getDistance(v1, -acc2, time2);
        this.move(this.object, s2, time2);

    }

    public void action3() {
        double time = Double.parseDouble(timeInput.getText());
        double mass = Double.parseDouble(massInput.getText());
        double frictionForce = Physics.getFrictionForce(mass);
        double force = Double.parseDouble(forceInput.getText());
        double acc = Physics.getAcceleration(force - frictionForce, mass);
        double s1 = Physics.getDistance(0, acc, time);
        System.out.println(s1);
        double v1 = Physics.getVelocity(0, acc, time);
        double acc2 = Physics.getAcceleration(frictionForce, mass);
        double time2 = Physics.getTime(0, v1, -acc2);
        double s2 = Physics.getDistance(v1, -acc2, time2);

        System.out.println(s2);

        if(s1+s2 > 400) {
            this.move(this.object,400,time);
        } else {
            this.move(this.object,s1+s2,time);
        }
    }
}

