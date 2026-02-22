public interface DiscountPolicy {

    double compute(double subtotal, int numLines);
}
