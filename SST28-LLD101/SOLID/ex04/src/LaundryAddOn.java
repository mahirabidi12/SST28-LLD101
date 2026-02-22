public class LaundryAddOn implements PricingComponent {

    @Override
    public double getMonthly() { return 500.0; }

    @Override
    public double getDeposit() { return 0.0; }

    @Override
    public String label() { return "LAUNDRY"; }
}
