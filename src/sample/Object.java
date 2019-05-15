package sample;

public class Object {

    private float mass;
    private float v;
    private float a;

    public float getV() {
		return v;
	}

	public void setV(float v) {
		this.v = v;
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}
	public void setA(float f, float m) {
		this.a = f/m;
	}

	public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
