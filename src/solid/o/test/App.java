package solid.o.test;

import solid.o.solution.CreditCardPayment;
import solid.o.solution.PayPalPayment;
import solid.o.solution.Payment;
import solid.o.solution.PaymentProcessor;

public class App {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        Payment creditCardPayment = new CreditCardPayment();
        processor.processPayment(creditCardPayment, 100.0);

        Payment paypalPayment = new PayPalPayment();
        processor.processPayment(paypalPayment, 50.0);
    }
}
