import java.util.LinkedHashMap;
import java.util.Map;

public class StudentParser {

    public ParsedStudent parse(String raw) {

        Map<String, String> kv = new LinkedHashMap<>();

        String[] parts = raw.split(";");

        for (String part : parts) {
            String[] token = part.split("=", 2);
            if (token.length == 2) {
                kv.put(token[0].trim(), token[1].trim());
            }
        }

        return new ParsedStudent(
                kv.getOrDefault("name",    ""),
                kv.getOrDefault("email",   ""),
                kv.getOrDefault("phone",   ""),
                kv.getOrDefault("program", "")
        );
    }
}
