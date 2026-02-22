public class Numbers {

    public static double clamp(double x, double min, double max) {
        return Math.max(min, Math.min(max, x));
    }
}
