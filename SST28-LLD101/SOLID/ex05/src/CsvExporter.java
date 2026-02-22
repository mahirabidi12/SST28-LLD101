import java.nio.charset.StandardCharsets;

public class CsvExporter implements Exporter {

    @Override
    public boolean canHandle(ExportRequest req) {
        return true;
    }

    @Override
    public ExportResult export(ExportRequest req) {
        String body  = req.body == null ? "" : req.body;
        String csv   = "title,body\n"
                     + sanitize(req.title) + ","
                     + sanitize(body);

        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String sanitize(String value) {
        if (value == null) return "";
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}
