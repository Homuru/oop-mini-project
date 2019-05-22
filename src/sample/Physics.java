package sample;

public class Physics {

    static double frictionConst = 0.9;
    static double g = 10;
    static double collisionTime = 0.1;

    public static double getAcceleration(double force, double mass) {
        double a = force / mass;
        System.out.println("a:" + a);
        return a;
    }

    //quang duong
    public static double getDistance(double v0, double a, double t) {
        double s = v0 * t + 0.5 * a * t * t;
        System.out.println("s:" + s);
        return s;
    }

    public static double getTimeByVelocity(double v1, double v0, double a) {
        System.out.println("t:" + (v1 - v0) / a);
        return (v1 - v0) / a;
    }

    public static double getTimeByDistance(double s, double v0, double a) {
        double t = Math.sqrt(2 * (s - v0) / a);
        return t;
    }

    //van toc
    public static double getVelocityByTime(double v0, double a, double t) {
        double v = v0 + a * t;
        System.out.println("v:" + v);
        return v;
    }

    public static double getVelocityByDistance(double s, double v0, double a) {
        double v = Math.sqrt(v0 * v0 + 2 * a * s);
        System.out.println(v);
        return v;
    }


    public static double getFrictionForce(double mass) {
        System.out.println("Friction Force:" + mass * g * frictionConst);
        return mass * g * frictionConst;
    }

    public static double getReverseForce(double mass, double v0, double v1, double time) {
        System.out.println("Reverse Force" + mass * (v1 + v0) / time);
        return mass * (v1 + v0) / time;
    }

}
