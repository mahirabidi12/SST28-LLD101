public class SmsSender extends NotificationSender {

    public SmsSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    @Override
    protected SendResult checkValid(Notification n) {
        if (n.phone == null || n.phone.isBlank())
            return SendResult.err("phone number is required for SMS");
        return SendResult.ok();
    }

    @Override
    protected SendResult deliver(Notification n) {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
        return SendResult.ok();
    }
}
