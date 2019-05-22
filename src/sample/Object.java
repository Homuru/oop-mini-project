package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Object {

    private double mass;
    private double v;
    private double a;
	private Animation animation;


    public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}
	public void setA(double f, double m) {
		this.a = f/m;
	}

	public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }


	public Animation getTransition() {
    	return this.animation;
	}

	public void setAnimation(Animation animation) {
    	this.animation = animation;
	}

	public void play() {
    	this.animation.play();
	}

	public void stop() {
    	this.animation.stop();
	}
}
