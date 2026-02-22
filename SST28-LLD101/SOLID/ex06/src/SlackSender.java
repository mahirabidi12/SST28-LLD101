public class SlackSender extends NotificationSender {

    public SlackSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    @Override
    protected SendResult checkValid(Notification n) {
        if (n.email == null || n.email.isBlank())
            return SendResult.err("slack requires a recipient email");
        return SendResult.ok();
    }

    @Override
    protected SendResult deliver(Notification n) {
        System.out.println("SLACK -> to=" + n.email + " body=" + n.body);
        audit.add("slack sent");
        return SendResult.ok();
    }
}
