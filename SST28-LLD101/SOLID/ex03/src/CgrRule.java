public class CgrRule implements EligibilityRule {

    private final double threshold;

    public CgrRule(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public String check(StudentProfile profile) {
        if (profile.cgr < threshold) {
            return "CGR below " + threshold;
        }
        return null;
    }
}
