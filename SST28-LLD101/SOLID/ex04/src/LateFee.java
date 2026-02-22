public class LateFee implements PricingComponent {

    private final double fee;

    public LateFee(double fee) {
        this.fee = fee;
    }

    @Override
    public double getMonthly() { return fee; }

    @Override
    public double getDeposit() { return 0.0; }

    @Override
    public String label() { return "LATE_FEE"; }
}
