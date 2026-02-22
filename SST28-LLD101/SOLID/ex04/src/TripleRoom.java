public class TripleRoom implements PricingComponent {

    @Override
    public double getMonthly() { return 12000.0; }

    @Override
    public double getDeposit() { return 5000.0; }

    @Override
    public String label() { return "TRIPLE"; }
}
