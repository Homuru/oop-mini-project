package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;

public class Law2 implements Law {
    @Override
    public void changeLayout(Controller controller) {
        controller.title.setText("Second Law");
        controller.menuBtn.setText("Second Law");
        controller.velocityInput.setDisable(true);
        controller.forceInput.setDisable(false);
        controller.massInput.setDisable(false);
        controller.timeInput.setDisable(false);
        controller.wall.setVisible(false);
        controller.start.setDisable(false);
    }

    @Override
    public void play(Controller controller) {
        double time = Double.parseDouble(controller.timeInput.getText());
        controller.ob.setMass(Double.parseDouble(controller.massInput.getText()));
        double frictionForce = Physics.getFrictionForce(controller.ob.getMass());
        double force = Double.parseDouble(controller.forceInput.getText());
        controller.ob.setA(Physics.getAcceleration(force - frictionForce, controller.ob.getMass()));
        double s1 = Physics.getDistance(0, controller.ob.getA(), time);
        TranslateTransition trans1 = AnimationUtils.createTranslateTransition(controller.object, s1, time);
        double v1 = Physics.getVelocityByTime(0, controller.ob.getA(), time);
        controller.ob.setA(Physics.getAcceleration(frictionForce, controller.ob.getMass()));
        double time2 = Physics.getTimeByVelocity(0, v1, -controller.ob.getA());
        double s2 = Physics.getDistance(v1, -controller.ob.getA(), time2);
        TranslateTransition trans2 = AnimationUtils.createTranslateTransition(controller.object, s2, time2);
        SequentialTransition transition = AnimationUtils.createSequentialTransition(controller.object, trans1, trans2);
        controller.ob.setAnimation(transition);
        controller.ob.play();
    }
}
