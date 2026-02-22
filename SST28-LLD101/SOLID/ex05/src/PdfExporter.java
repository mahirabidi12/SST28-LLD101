import java.nio.charset.StandardCharsets;

public class PdfExporter implements Exporter {

    private static final int MAX_BODY_LENGTH = 20;

    @Override
    public boolean canHandle(ExportRequest req) {
        return req.body == null || req.body.length() <= MAX_BODY_LENGTH;
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (!canHandle(req)) {
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
        }

        String content = req.body == null ? "" : req.body;
        String fakePdf = "PDF(" + req.title + "):" + content;

        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
