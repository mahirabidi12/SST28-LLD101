public class Demo07 {

    public static void main(String[] args) {
        System.out.println("=== Smart Classroom ===");

        DeviceRegistry registry = new DeviceRegistry();
        registry.register(new Projector());
        registry.register(new LightsPanel());
        registry.register(new AirConditioner());
        registry.register(new AttendanceScanner());

        ClassroomController ctrl = new ClassroomController(registry);
        ctrl.startClass();
        ctrl.endClass();
    }
}
