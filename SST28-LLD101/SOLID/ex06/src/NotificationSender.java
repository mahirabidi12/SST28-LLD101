public abstract class NotificationSender {

    protected final AuditLog    audit;
    protected final SenderConfig config;

    protected NotificationSender(AuditLog audit, SenderConfig config) {
        this.audit  = audit;
        this.config = config;
    }

    // Template method — final so subtypes cannot break the contract
    public final SendResult send(Notification n) {

        if (n.body == null || n.body.isBlank()) {
            audit.add("rejected: empty body");
            return SendResult.err("body cannot be empty");
        }

        if (n.body.length() > config.maxLen) {
            audit.add("rejected: body too long");
            return SendResult.err("body exceeds max length of " + config.maxLen);
        }

        SendResult check = checkValid(n);
        if (!check.succeeded()) {
            audit.add("failed: " + check.errorMessage());
            return check;
        }

        return deliver(n);
    }

    // Hook — subtypes override to add channel-specific validation
    protected SendResult checkValid(Notification n) {
        return SendResult.ok();
    }

    // Core send logic — must be implemented by each channel
    protected abstract SendResult deliver(Notification n);
}
