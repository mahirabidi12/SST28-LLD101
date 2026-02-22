public interface TaxPolicy {

    double compute(double amount);

    double getRate();
}
