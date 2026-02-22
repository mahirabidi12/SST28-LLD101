import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BillCalculator {

    private final Map<String, MenuItem> menu;

    public BillCalculator(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public Invoice calculate(String invoiceId, String customerType, List<OrderLine> lines) {

        List<String> lineItems = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine line : lines) {
            MenuItem item      = menu.get(line.itemId);
            double lineTotal   = item.price * line.qty;
            subtotal          += lineTotal;
            lineItems.add(String.format("- %s x%d = %.2f", item.name, line.qty, lineTotal));
        }

        double taxPct    = TaxRules.taxPercent(customerType);
        double taxAmount = subtotal * (taxPct / 100.0);
        double discount  = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        double total     = subtotal + taxAmount - discount;

        return new Invoice(invoiceId, lineItems, subtotal, taxPct, taxAmount, discount, total);
    }
}
