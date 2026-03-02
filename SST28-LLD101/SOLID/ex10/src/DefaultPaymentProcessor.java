public class DefaultPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment(String studentId, double amount) {
        return "TXN-9001";
    }
}
