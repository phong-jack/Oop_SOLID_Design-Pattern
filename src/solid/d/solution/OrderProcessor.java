package solid.d.solution;

public class OrderProcessor {
    private Notification notification;

    public OrderProcessor(Notification notification) {
        this.notification = notification;
    }

    public void processOrder(String orderId, String customerEmail) {
        // Order processing logic
        System.out.println("Processing order: " + orderId);

        // Send confirmation email
        notification.send(customerEmail, "Order Confirmation", "Your order has been processed.");
    }
}
