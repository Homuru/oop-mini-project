package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Controller {

    private Object ob = new Object();

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
    private TextArea output;
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
        output.setDisable(true);
        timeInput.setDisable(true);
        start.setDisable(true);
    }

    public void reset() {
        ob.stop();
        output.setText(null);
        object.setTranslateX(0);
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
        wall.setVisible(false);
        start.setDisable(false);
    }

    public void law3() {
        title.setText("Third Law");
        menuBtn.setText("Third Law");
        velocityInput.setDisable(false);
        forceInput.setDisable(true);
        massInput.setDisable(true);
        timeInput.setDisable(true);
        start.setDisable(false);
        wall.setVisible(true);
    }

    public void action1() {
        ob.setV(Double.parseDouble(velocityInput.getText()));
        output.setText("\n" + "v0 = " + velocityInput.getText());
        TranslateTransition transition = AnimationUtils.createTranslateTransition(this.object, 1000, 1000 / ob.getV());
        ob.setAnimation(transition);
        ob.play();
    }

    public void action2() {    //check lai
        double time = Double.parseDouble(timeInput.getText());
        ob.setMass(Double.parseDouble(massInput.getText()));
        double frictionForce = Physics.getFrictionForce(ob.getMass());
        double force = Double.parseDouble(forceInput.getText());
        double acc1 = Physics.getAcceleration(force - frictionForce, ob.getMass());
        double s1 = Physics.getDistance(0, acc1, time);
        TranslateTransition trans1 = AnimationUtils.createTranslateTransition(this.object, s1, time);
        double v1 = Physics.getVelocityByTime(0, acc1, time);
        double acc2 = Physics.getAcceleration(frictionForce, ob.getMass());
        double time2 = Physics.getTimeByVelocity(0, v1, -acc2);
        double s2 = Physics.getDistance(v1, -acc2, time2);
        TranslateTransition trans2 = AnimationUtils.createTranslateTransition(this.object, s2, time2);
        SequentialTransition transition = AnimationUtils.createSequentialTransition(this.object, trans1, trans2);
        ob.setAnimation(transition);
        ob.play();
    }

    public void action3() {
        ob.setV(Double.parseDouble(velocityInput.getText()));
        TranslateTransition trans1 = AnimationUtils.createTranslateTransition(this.object, 400, 400 / ob.getV());
        TranslateTransition trans2 = AnimationUtils.createTranslateTransition(this.object, -1000, 1000 / ob.getV());
        SequentialTransition transition = AnimationUtils.createSequentialTransition(this.object, trans1, trans2);
        ob.setAnimation(transition);
        ob.play();
    }
}

