package solid.d.solution;

public class SMSServiceImpl implements Notification {
    @Override
    public void send(String to, String subject, String body) {
        System.out.println("==============SMS==================");
        System.out.println("Sending SMS to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("================================");
    }

}
