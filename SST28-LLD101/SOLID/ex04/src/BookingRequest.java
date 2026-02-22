import java.util.List;

public class BookingRequest {

    public final PricingComponent       roomType;
    public final List<PricingComponent> addOns;

    public BookingRequest(PricingComponent roomType, List<PricingComponent> addOns) {
        this.roomType = roomType;
        this.addOns   = addOns;
    }
}
