public class LightsPanel implements Powerable, Dimmable {

    @Override
    public void on()  { /* always available */ }

    @Override
    public void off() { System.out.println("Lights OFF"); }

    @Override
    public void dim(int pct) { System.out.println("Lights set to " + pct + "%"); }
}
