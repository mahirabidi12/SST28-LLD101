import java.util.HashMap;
import java.util.Map;

public class FileStore {

    private final Map<String, String> store = new HashMap<>();

    public void save(String name, String content) {
        store.put(name, content);
    }

    public int countLines(String name) {
        String raw = store.getOrDefault(name, "");
        if (raw.isEmpty()) return 0;
        return raw.split("\n").length;
    }
}
