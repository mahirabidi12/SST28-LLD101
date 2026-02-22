public class Demo06 {

    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");

        AuditLog     audit  = new AuditLog();
        SenderConfig config = new SenderConfig();

        Notification n = new Notification(
                "Welcome", "Hello and welcome to SST!",
                "riya@sst.edu", "9876543210"
        );

        NotificationSender emailSender = new EmailSender(audit, config);
        NotificationSender smsSender   = new SmsSender(audit, config);
        NotificationSender waSender    = new WhatsAppSender(audit, config);

        emailSender.send(n);
        smsSender.send(n);

        SendResult waResult = waSender.send(n);
        if (!waResult.succeeded()) {
            System.out.println("WA ERROR: " + waResult.errorMessage());
        }

        System.out.println("AUDIT entries=" + audit.size());
    }
}
