public class Projector implements Powerable, InputSource {

    private boolean active = false;

    @Override
    public void on()  { active = true; }

    @Override
    public void off() { System.out.println("Projector OFF"); }

    @Override
    public void connect(String port) {
        if (active) System.out.println("Projector ON (" + port + ")");
    }
}
