public class DeluxeRoom implements PricingComponent {

    @Override
    public double getMonthly() { return 16000.0; }

    @Override
    public double getDeposit() { return 5000.0; }

    @Override
    public String label() { return "DELUXE"; }
}
