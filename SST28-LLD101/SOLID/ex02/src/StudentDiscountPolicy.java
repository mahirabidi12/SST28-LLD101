public class StudentDiscountPolicy implements DiscountPolicy {

    @Override
    public double compute(double subtotal, int numLines) {
        return subtotal >= 180.0 ? 10.0 : 0.0;
    }
}
