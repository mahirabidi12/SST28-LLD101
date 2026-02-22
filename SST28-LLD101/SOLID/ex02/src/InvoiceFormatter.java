import java.util.List;

public class InvoiceFormatter {

    public static String format(String invoiceId, Menu menu, List<OrderLine> lines,
                                double subtotal, double taxRate, double tax,
                                double discount, double total) {
        StringBuilder sb = new StringBuilder();

        sb.append("Invoice# ").append(invoiceId).append("\n");

        for (OrderLine line : lines) {
            MenuItem item    = menu.getItems().get(line.itemId);
            double lineTotal = item.price * line.qty;
            sb.append(String.format("- %s x%d = %.2f\n", item.name, line.qty, lineTotal));
        }

        sb.append(String.format("Subtotal: %.2f\n",    subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", taxRate, tax));
        sb.append(String.format("Discount: -%.2f\n",   discount));
        sb.append(String.format("TOTAL: %.2f\n",       total));

        return sb.toString();
    }
}
