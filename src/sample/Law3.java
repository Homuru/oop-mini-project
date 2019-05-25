package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class Law3 extends Law{

	@Override
	public void start(Node object, double v, double time, double mass, double force) {
		ob.setV(v);
		TranslateTransition trans1 = createTranslateTransition(object, 400, 400 / ob.getV());
        TranslateTransition trans2 = createTranslateTransition(object, -1000, 1000 / ob.getV());
        SequentialTransition transition = createSequentialTransition(object, trans1, trans2);
        ob.setAnimation(transition);
        ob.play();
		
	}

}
