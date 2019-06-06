package sample;

import javafx.animation.TranslateTransition;

public class Law1 implements Law {
    @Override
    public void changeLayout(Controller controller) {
        controller.title.setText("First Law");
        controller.menuBtn.setText("First Law");
        controller.forceInput.setText("0");
        controller.velocityInput.setDisable(false);
        controller.massInput.setDisable(true);
        controller.forceInput.setDisable(true);
        controller.timeInput.setDisable(true);
        controller.wall.setVisible(false);
        controller.start.setDisable(false);
    }

    public void play(Controller controller) {
        controller.ob.setV(Double.parseDouble(controller.velocityInput.getText()));
        TranslateTransition transition = AnimationUtils.createTranslateTransition(controller.object, 1000, 1000 / controller.ob.getV());
        controller.ob.setAnimation(transition);
        controller.ob.play();
    }
}
