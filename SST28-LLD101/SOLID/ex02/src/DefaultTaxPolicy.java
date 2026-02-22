public class DefaultTaxPolicy implements TaxPolicy {

    @Override
    public double compute(double amount) {
        return amount * 0.08;
    }

    @Override
    public double getRate() {
        return 8.0;
    }
}
