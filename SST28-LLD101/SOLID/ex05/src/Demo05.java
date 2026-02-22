public class Demo05 {

    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());

        Exporter pdfExp = new PdfExporter();
        Exporter csvExp = new CsvExporter();
        Exporter jsonExp = new JsonExporter();
        Exporter xmlExp  = new XmlExporter();

        System.out.println("PDF: "  + run(pdfExp,  req));
        System.out.println("CSV: "  + run(csvExp,  req));
        System.out.println("JSON: " + run(jsonExp, req));
        System.out.println("XML: "  + run(xmlExp,  req));
    }

    private static String run(Exporter exporter, ExportRequest req) {
        try {
            ExportResult result = exporter.export(req);
            return "OK bytes=" + result.bytes.length;
        } catch (RuntimeException ex) {
            return "ERROR: " + ex.getMessage();
        }
    }
}
