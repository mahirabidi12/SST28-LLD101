public class ClassroomController {

    private final DeviceRegistry registry;

    public ClassroomController(DeviceRegistry registry) {
        this.registry = registry;
    }

    public void startClass() {
        for (Powerable p : registry.findAll(Powerable.class)) p.on();

        registry.find(InputSource.class).connect("HDMI-1");
        registry.find(Dimmable.class).dim(60);
        registry.find(ThermoControl.class).setTemp(24);

        System.out.println("Attendance scanned: present=" + registry.find(Scannable.class).scan());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (Powerable p : registry.findAll(Powerable.class)) p.off();
    }
}
