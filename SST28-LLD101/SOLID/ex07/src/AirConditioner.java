public class AirConditioner implements Powerable, ThermoControl {

    @Override
    public void on()  { /* standby */ }

    @Override
    public void off() { System.out.println("AC OFF"); }

    @Override
    public void setTemp(int celsius) { System.out.println("AC set to " + celsius + "C"); }
}
