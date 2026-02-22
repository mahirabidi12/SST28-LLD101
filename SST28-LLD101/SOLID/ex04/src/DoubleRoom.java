public class DoubleRoom implements PricingComponent {

    @Override
    public double getMonthly() { return 15000.0; }

    @Override
    public double getDeposit() { return 5000.0; }

    @Override
    public String label() { return "DOUBLE"; }
}
