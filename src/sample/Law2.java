package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class Law2 extends Law{

	@Override
	public void start(Node object, double v, double time, double mass, double force) {
		 	ob.setMass(mass);
			double frictionForce = Physics.getFrictionForce(ob.getMass());
	        ob.setA(Physics.getAcceleration(force - frictionForce, ob.getMass()));
	        double s1 = Physics.getDistance(0, ob.getA(), time);
	        TranslateTransition trans1 = createTranslateTransition(object, s1, time);
	        double v1 = Physics.getVelocityByTime(0, ob.getA(), time);
	        ob.setA(Physics.getAcceleration(frictionForce, ob.getMass()));
	        double time2 = Physics.getTimeByVelocity(0, v1, -ob.getA());
	        double s2 = Physics.getDistance(v1, -ob.getA(), time2);
	        TranslateTransition trans2 =createTranslateTransition(object, s2, time2);
	        SequentialTransition transition = createSequentialTransition(object, trans1, trans2);
	        ob.setAnimation(transition);
	        ob.play();
		
	}

}