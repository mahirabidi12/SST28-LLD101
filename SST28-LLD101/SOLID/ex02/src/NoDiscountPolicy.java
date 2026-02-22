public class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public double compute(double subtotal, int numLines) {
        return 0.0;
    }
}
