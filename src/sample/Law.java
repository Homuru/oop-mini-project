package sample;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

abstract public class Law {
	Object ob = new Object();
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
	 
	 public void reset(Node object) {
		 ob.stop();
		 object.setTranslateX(0);
	 }
	 abstract public void start (Node object, double v, double time, double mass, double force);
	    
}