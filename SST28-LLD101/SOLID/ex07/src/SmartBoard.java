public class SmartBoard implements Powerable, Dimmable, InputSource {

    private boolean active = false;

    @Override
    public void on()  { active = true; }

    @Override
    public void off() { System.out.println("SmartBoard OFF"); }

    @Override
    public void dim(int pct) { System.out.println("SmartBoard brightness " + pct + "%"); }

    @Override
    public void connect(String port) {
        if (active) System.out.println("SmartBoard input: " + port);
    }
}
