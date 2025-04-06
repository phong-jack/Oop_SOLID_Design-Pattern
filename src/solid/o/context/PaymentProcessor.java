package solid.o.context;

public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            // Logic xử lý thanh toán bằng thẻ tín dụng
            System.out.println("Processing Credit Card payment of $" + amount);
        } else if (paymentType.equals("PayPal")) {
            // Logic xử lý thanh toán bằng PayPal
            System.out.println("Processing PayPal payment of $" + amount);
        } else {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}
