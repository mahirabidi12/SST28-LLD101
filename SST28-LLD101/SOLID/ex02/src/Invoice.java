import java.util.List;

public class Invoice {

    public final String id;
    public final List<String> lineItems;
    public final double subtotal;
    public final double taxPct;
    public final double taxAmount;
    public final double discount;
    public final double total;

    public Invoice(String id, List<String> lineItems,
                   double subtotal, double taxPct, double taxAmount,
                   double discount, double total) {
        this.id         = id;
        this.lineItems  = lineItems;
        this.subtotal   = subtotal;
        this.taxPct     = taxPct;
        this.taxAmount  = taxAmount;
        this.discount   = discount;
        this.total      = total;
    }
}
