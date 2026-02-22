import java.util.ArrayList;
import java.util.List;

public class EligibilityEngine {

    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<EligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile profile) {
        EligibilityEngineResult result = evaluate(profile);
        new ReportPrinter().print(profile, result);
        store.save(profile.rollNo, result.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile profile) {
        List<String> failures = new ArrayList<>();

        for (EligibilityRule rule : rules) {
            String failure = rule.check(profile);
            if (failure != null) {
                failures.add(failure);
            }
        }

        String status = failures.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, failures);
    }
}
