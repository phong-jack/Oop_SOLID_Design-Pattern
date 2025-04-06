package solid.o.solution;

public class CreditCardPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }

}
