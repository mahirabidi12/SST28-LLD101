public class DefaultReportOutput implements ReportOutput {

    @Override
    public String writeReport(Submission s, int plagScore, int codeScore) {
        return "report-" + s.roll + ".txt";
    }
}
