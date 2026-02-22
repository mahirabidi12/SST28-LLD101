public class WhatsAppSender extends NotificationSender {

    public WhatsAppSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    @Override
    protected SendResult checkValid(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+"))
            return SendResult.err("phone must start with + and country code");
        return SendResult.ok();
    }

    @Override
    protected SendResult deliver(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
        return SendResult.ok();
    }
}
