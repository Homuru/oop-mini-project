package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class Law1 extends Law{

	@Override
	public void start(Node object, double v, double time, double mass, double force) {
		 	ob.setV(v);
			TranslateTransition transition = createTranslateTransition(object, 1000, 1000 / ob.getV());
	        ob.setAnimation(transition);
	        ob.play();
		
	}

}