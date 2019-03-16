package Utils;

public class Rounder {
    public static double round(double a) {
        a = Math.round(a * 100);
        return a / 100;
    }

}
