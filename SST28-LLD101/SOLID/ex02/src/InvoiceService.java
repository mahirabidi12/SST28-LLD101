import java.util.List;

public class InvoiceService {

    private int counter = 1000;
    private final FileStore store;
    private final PricingService pricer;

    public InvoiceService(FileStore store, PricingService pricer) {
        this.store  = store;
        this.pricer = pricer;
    }

    public void generateInvoice(Menu menu,
                                List<OrderLine> lines,
                                TaxPolicy taxPolicy,
                                DiscountPolicy discountPolicy) {

        String invoiceId = "INV-" + (++counter);

        double subtotal  = pricer.calculateSubtotal(menu, lines);
        double tax       = taxPolicy.compute(subtotal);
        double discount  = discountPolicy.compute(subtotal, lines.size());
        double total     = subtotal + tax - discount;

        String text = InvoiceFormatter.format(
                invoiceId, menu, lines,
                subtotal, taxPolicy.getRate(), tax, discount, total
        );

        store.save(invoiceId, text);
        System.out.print(text);
        System.out.println("Saved invoice: " + invoiceId + " (lines=" + store.countLines(invoiceId) + ")");
    }
}
