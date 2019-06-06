package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;

public class Law3 implements Law {
    @Override
    public void changeLayout(Controller controller) {
        controller.title.setText("Third Law");
        controller.menuBtn.setText("Third Law");
        controller.object.setTranslateX(0);
        controller.velocityInput.setDisable(false);
        controller.forceInput.setDisable(true);
        controller.massInput.setDisable(true);
        controller.timeInput.setDisable(true);
        controller.start.setDisable(false);
        controller.wall.setVisible(true);
    }

    @Override
    public void play(Controller controller) {
        controller.ob.setV(Double.parseDouble(controller.velocityInput.getText()));
        TranslateTransition trans1 = AnimationUtils.createTranslateTransition(controller.object, 400, 400 / controller.ob.getV());
        TranslateTransition trans2 = AnimationUtils.createTranslateTransition(controller.object, -1000, 1000 / controller.ob.getV());
        SequentialTransition transition = AnimationUtils.createSequentialTransition(controller.object, trans1, trans2);
        controller.ob.setAnimation(transition);
        controller.ob.play();
    }
}
