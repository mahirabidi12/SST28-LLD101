public class SingleRoom implements PricingComponent {

    @Override
    public double getMonthly() { return 14000.0; }

    @Override
    public double getDeposit() { return 5000.0; }

    @Override
    public String label() { return "SINGLE"; }
}
