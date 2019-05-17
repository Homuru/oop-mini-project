package sample;

public class Physics {

    static double frictionConst = 0.2;
    static double g = 10;

    public static double getAcceleration(double force, double mass) {
        double a = force / mass;
        return a;
    }

    //quang duong
    public static double getDistance(double v0, double a, double t) {
        double s = v0 * t + 0.5 * a * t * t;
        return s;
    }

    public static double getTime(double v1, double v0, double a) {
        return (v1-v0)/a;
    }

    public static double getDistance2(double v0, double v1, double a, int i) {// i de phan biet vs phuong thuc tren
        double s = (v1 * v1 - v0 * v0) / (2 * a);
        return s;
    }

    public static double getResistanceForce(double m, double v1, double v2, double t) { // v1: van toc trc v/c, v2: van toc sau v/c
        double f = (v1 + v2) / t * m;
        return f;
    }

    //van toc
    public static double getVelocity(double v0, double a, double t) {
        double v = v0 + a * t;
        return v;
    }

    public static double getFrictionForce(double mass) {
        return mass * g * frictionConst;
    }
}
