public class CreditsRule implements EligibilityRule {

    private final int threshold;

    public CreditsRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public String check(StudentProfile profile) {
        if (profile.earnedCredits < threshold) {
            return "credits below " + threshold;
        }
        return null;
    }
}
