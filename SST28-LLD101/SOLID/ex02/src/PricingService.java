import java.util.List;

public class PricingService {

    public double calculateSubtotal(Menu menu, List<OrderLine> lines) {
        double subtotal = 0.0;

        for (OrderLine line : lines) {
            MenuItem item = menu.getItems().get(line.itemId);
            double cost   = item.price * line.qty;
            subtotal     += cost;
        }

        return subtotal;
    }
}
