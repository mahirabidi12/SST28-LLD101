public interface PaymentProcessor {

    String processPayment(String studentId, double amount);
}
