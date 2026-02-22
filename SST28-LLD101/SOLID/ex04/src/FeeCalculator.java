public class FeeCalculator {

    public static Money calculateMonthly(BookingRequest req) {
        double roomFee  = req.roomType.getMonthly();
        double extraFees = 0.0;

        for (PricingComponent addon : req.addOns) {
            extraFees += addon.getMonthly();
        }

        return new Money(roomFee + extraFees);
    }
}
