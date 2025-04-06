package solid.o.solution;

public class PayPalPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

}
