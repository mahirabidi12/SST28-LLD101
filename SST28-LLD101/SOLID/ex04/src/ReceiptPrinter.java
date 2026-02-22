import java.util.List;

public class ReceiptPrinter {

    public static void print(BookingRequest req, Money monthly, Money deposit) {
        String addOnNames = buildAddOnList(req.addOns);

        System.out.println("Room: " + req.roomType.label() + " | AddOns: " + addOnNames);
        System.out.println("Monthly: "      + monthly);
        System.out.println("Deposit: "      + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }

    private static String buildAddOnList(List<PricingComponent> addOns) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < addOns.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(addOns.get(i).label());
        }
        sb.append("]");
        return sb.toString();
    }
}
