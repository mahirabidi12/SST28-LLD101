import java.nio.charset.StandardCharsets;

public class JsonExporter implements Exporter {

    @Override
    public boolean canHandle(ExportRequest req) {
        return req != null;
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (!canHandle(req)) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        String body = req.body == null ? "" : req.body;
        String json = "{\"title\":\"" + escapeJson(req.title) + "\","
                    + "\"body\":\""   + escapeJson(body)      + "\"}";

        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeJson(String value) {
        if (value == null) return "";
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
