import java.util.ArrayList;
import java.util.List;

public class StudentValidator {

    private final ProgramList programList;

    public StudentValidator(ProgramList programList) {
        this.programList = programList;
    }

    public List<String> validate(ParsedStudent parsed) {

        List<String> errors = new ArrayList<>();

        String name    = parsed.getName();
        String email   = parsed.getEmail();
        String phone   = parsed.getPhone();
        String program = parsed.getProgram();

        if (name.isBlank())
            errors.add("name is required");

        if (email.isBlank() || !email.contains("@"))
            errors.add("email is invalid");

        if (phone.isBlank() || !phone.matches("\\d{10}"))
            errors.add("phone is invalid");

        if (!programList.contains(program))
            errors.add("program is invalid");

        return errors;
    }
}
