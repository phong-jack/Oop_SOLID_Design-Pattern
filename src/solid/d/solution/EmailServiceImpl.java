package solid.d.solution;

public class EmailServiceImpl implements Notification {
    @Override
    public void send(String to, String subject, String body) {
        System.out.println("==============MAIL==================");
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("================================");
    }

}
