public class StaffTaxPolicy implements TaxPolicy {

    @Override
    public double compute(double amount) {
        return amount * 0.02;
    }

    @Override
    public double getRate() {
        return 2.0;
    }
}
