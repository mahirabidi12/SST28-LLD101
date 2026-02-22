import java.util.Map;

public class PolicyResolver {

    private final Map<String, TaxPolicy>      taxRegistry;
    private final Map<String, DiscountPolicy> discountRegistry;

    public PolicyResolver(Map<String, TaxPolicy> taxRegistry,
                          Map<String, DiscountPolicy> discountRegistry) {
        this.taxRegistry      = taxRegistry;
        this.discountRegistry = discountRegistry;
    }

    public TaxPolicy resolveTax(String customerType) {
        return taxRegistry.getOrDefault(
                customerType.toLowerCase(),
                new DefaultTaxPolicy()
        );
    }

    public DiscountPolicy resolveDiscount(String customerType) {
        return discountRegistry.getOrDefault(
                customerType.toLowerCase(),
                new NoDiscountPolicy()
        );
    }
}
