public class StudentTaxPolicy implements TaxPolicy {

    @Override
    public double compute(double amount) {
        return amount * 0.05;
    }

    @Override
    public double getRate() {
        return 5.0;
    }
}
