import java.util.List;

public class Demo03 {

    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");

        RuleInput config = new RuleInput();

        List<EligibilityRule> rules = List.of(
                new DisciplinaryRule(),
                new CgrRule(config.minCgr),
                new AttendanceRule(config.minAttendance),
                new CreditsRule(config.minCredits)
        );

        StudentProfile student = new StudentProfile(
                "23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE
        );

        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), rules);
        engine.runAndPrint(student);
    }
}
