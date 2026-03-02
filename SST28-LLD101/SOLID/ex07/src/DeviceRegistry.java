import java.util.ArrayList;
import java.util.List;

public class DeviceRegistry {

    private final List<Object> devices = new ArrayList<>();

    public void register(Object device) { devices.add(device); }

    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> capability) {
        for (Object d : devices) {
            if (capability.isInstance(d)) return (T) d;
        }
        throw new IllegalStateException("No device supports: " + capability.getSimpleName());
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class<T> capability) {
        List<T> result = new ArrayList<>();
        for (Object d : devices) {
            if (capability.isInstance(d)) result.add((T) d);
        }
        return result;
    }
}
