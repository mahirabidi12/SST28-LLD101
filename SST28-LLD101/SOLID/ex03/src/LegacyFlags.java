public class LegacyFlags {

    public static final int NONE      = 0;
    public static final int WARNING   = 1;
    public static final int SUSPENDED = 2;

    public static String nameOf(int flag) {
        return switch (flag) {
            case WARNING   -> "WARNING";
            case SUSPENDED -> "SUSPENDED";
            default        -> "NONE";
        };
    }
}
