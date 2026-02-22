public class ReportPrinter {

    public void print(StudentProfile student, EligibilityEngineResult result) {
        System.out.println("Student: " + student.name
                + " (CGR="        + String.format("%.2f", student.cgr)
                + ", attendance=" + student.attendancePct
                + ", credits="    + student.earnedCredits
                + ", flag="       + LegacyFlags.nameOf(student.disciplinaryFlag) + ")");

        System.out.println("RESULT: " + result.status);

        for (String reason : result.reasons) {
            System.out.println("- " + reason);
        }
    }
}
