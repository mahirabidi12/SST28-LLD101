public class GymAddOn implements PricingComponent {

    @Override
    public double getMonthly() { return 300.0; }

    @Override
    public double getDeposit() { return 0.0; }

    @Override
    public String label() { return "GYM"; }
}
