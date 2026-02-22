import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo02 {

    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        Menu menu = new Menu();
        menu.addItem(new MenuItem("M1", "Veg Thali",  80.00));
        menu.addItem(new MenuItem("C1", "Coffee",     30.00));
        menu.addItem(new MenuItem("S1", "Sandwich",   60.00));

        FileStore      store  = new FileStore();
        PricingService pricer = new PricingService();

        Map<String, TaxPolicy> taxRegistry = new HashMap<>();
        taxRegistry.put("student", new StudentTaxPolicy());
        taxRegistry.put("staff",   new StaffTaxPolicy());

        Map<String, DiscountPolicy> discountRegistry = new HashMap<>();
        discountRegistry.put("student", new StudentDiscountPolicy());
        discountRegistry.put("staff",   new StaffDiscountPolicy());

        PolicyResolver  resolver = new PolicyResolver(taxRegistry, discountRegistry);
        CafeteriaSystem sys      = new CafeteriaSystem(menu, store, pricer, resolver);

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order);
        System.out.println();
        sys.checkout("staff", order);
    }
}
