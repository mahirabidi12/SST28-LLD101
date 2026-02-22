public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    @Override
    protected SendResult checkValid(Notification n) {
        if (n.email == null || !n.email.contains("@"))
            return SendResult.err("invalid email address");
        return SendResult.ok();
    }

    @Override
    protected SendResult deliver(Notification n) {
        System.out.println("EMAIL -> to=" + n.email
                + " subject=" + n.subject
                + " body="    + n.body);
        audit.add("email sent");
        return SendResult.ok();
    }
}
