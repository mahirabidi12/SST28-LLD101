import java.util.ArrayList;

public class ProgramList {

    private final ArrayList<String> programs = new ArrayList<>();

    public void add(String program) {
        programs.add(program);
    }

    public boolean contains(String program) {
        return programs.contains(program);
    }
}
