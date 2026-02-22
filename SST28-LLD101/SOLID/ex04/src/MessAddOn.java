public class MessAddOn implements PricingComponent {

    @Override
    public double getMonthly() { return 1000.0; }

    @Override
    public double getDeposit() { return 0.0; }

    @Override
    public String label() { return "MESS"; }
}
