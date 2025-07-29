package solid.d.test;

import solid.d.solution.EmailServiceImpl;
import solid.d.solution.OrderProcessor;
import solid.d.solution.SMSServiceImpl;

public class App {
    public static void main(String[] args) {
        EmailServiceImpl emailService = new EmailServiceImpl();
        SMSServiceImpl smsService = new SMSServiceImpl();
        OrderProcessor orderProcessor = new OrderProcessor(emailService);
        orderProcessor.processOrder("12345", "customer@example.com");
        orderProcessor = new OrderProcessor(smsService);
        orderProcessor.processOrder("12345", "customer@example.com");
    }
}
