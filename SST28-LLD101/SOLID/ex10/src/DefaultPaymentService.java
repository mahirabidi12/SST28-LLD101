public class DefaultPaymentService implements PaymentService {

    @Override
    public String processPayment(String studentId, double amount) {
        return "TXN-9001";
    }
}
