public interface EligibilityRule {

    // Returns a failure reason string, or null if the student passes this rule
    String check(StudentProfile profile);
}
