public class SendResult {

    private final boolean success;
    private final String  error;

    private SendResult(boolean success, String error) {
        this.success = success;
        this.error   = error;
    }

    public static SendResult ok()              { return new SendResult(true, null);  }
    public static SendResult err(String msg)   { return new SendResult(false, msg);  }

    public boolean succeeded()      { return success; }
    public String  errorMessage()   { return error;   }
}
