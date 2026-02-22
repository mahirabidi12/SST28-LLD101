public class AttendanceRule implements EligibilityRule {

    private final int threshold;

    public AttendanceRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public String check(StudentProfile profile) {
        if (profile.attendancePct < threshold) {
            return "attendance below " + threshold;
        }
        return null;
    }
}
