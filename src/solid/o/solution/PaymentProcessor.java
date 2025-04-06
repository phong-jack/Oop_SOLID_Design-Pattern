package solid.o.solution;

public class PaymentProcessor {
    public void processPayment(Payment payment, double amount) {
        payment.process(amount);
    }
}
