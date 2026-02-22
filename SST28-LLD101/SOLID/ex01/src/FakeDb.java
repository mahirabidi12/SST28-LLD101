import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FakeDb implements Database {

    private final List<StudentRecord> rows = new ArrayList<>();

    @Override
    public void save(StudentRecord record) {
        rows.add(record);
    }

    @Override
    public int count() {
        return rows.size();
    }

    @Override
    public List<StudentRecord> all() {
        return Collections.unmodifiableList(rows);
    }
}
