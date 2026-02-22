public class StaffDiscountPolicy implements DiscountPolicy {

    @Override
    public double compute(double subtotal, int numLines) {
        return numLines >= 3 ? 15.0 : 5.0;
    }
}
