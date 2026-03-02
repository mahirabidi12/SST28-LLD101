public class EvaluationPipeline {

    private final Rubric rubric;
    private final SimilarityChecker similarityChecker;
    private final Grader grader;
    private final ReportOutput reportOutput;


    public EvaluationPipeline(
            Rubric rubric,
            SimilarityChecker similarityChecker,
            Grader grader,
            ReportOutput reportOutput) {
        this.rubric = rubric;
        this.similarityChecker = similarityChecker;
        this.grader = grader;
        this.reportOutput = reportOutput;
    }


    public void evaluate(Submission sub) {

        int plag = similarityChecker.score(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.score(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = reportOutput.writeReport(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
