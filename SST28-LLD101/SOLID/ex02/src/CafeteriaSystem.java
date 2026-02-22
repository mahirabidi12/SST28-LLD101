import java.util.List;

public class CafeteriaSystem {

    private final Menu menu;
    private final PolicyResolver resolver;
    private final InvoiceService invoicer;

    public CafeteriaSystem(Menu menu, FileStore store, PricingService pricer, PolicyResolver resolver) {
        this.menu     = menu;
        this.resolver = resolver;
        this.invoicer = new InvoiceService(store, pricer);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        TaxPolicy      taxPolicy      = resolver.resolveTax(customerType);
        DiscountPolicy discountPolicy = resolver.resolveDiscount(customerType);

        invoicer.generateInvoice(menu, lines, taxPolicy, discountPolicy);
    }
}
