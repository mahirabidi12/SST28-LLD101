public interface Exporter {

    // Returns true if this exporter can handle the given request
    boolean canHandle(ExportRequest req);

    ExportResult export(ExportRequest req);
}
