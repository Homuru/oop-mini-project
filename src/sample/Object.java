package sample;

public class Object {

    private double mass;
    private double v;
    private double a;

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
}
