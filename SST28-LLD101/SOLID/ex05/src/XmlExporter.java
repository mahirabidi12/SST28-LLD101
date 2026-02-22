import java.nio.charset.StandardCharsets;

public class XmlExporter implements Exporter {

    @Override
    public boolean canHandle(ExportRequest req) {
        return req != null && req.body != null;
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (!canHandle(req)) {
            throw new IllegalArgumentException("XML export requires a non-null request and body");
        }

        String xml = "<report>"
                   + "<title>" + req.title + "</title>"
                   + "<body>"  + req.body  + "</body>"
                   + "</report>";

        return new ExportResult("application/xml", xml.getBytes(StandardCharsets.UTF_8));
    }
}
