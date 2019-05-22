package sample;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationUtils {
    public static TranslateTransition createTranslateTransition(Node object, double s, double time) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(time));
        transition.setNode(object);
        transition.setByX(s);
        return transition;
    }

    public static SequentialTransition createSequentialTransition(Node object, Animation ani1, Animation ani2) {
        SequentialTransition trans =  new SequentialTransition(object,ani1,ani2);
        return trans;
    }
}
