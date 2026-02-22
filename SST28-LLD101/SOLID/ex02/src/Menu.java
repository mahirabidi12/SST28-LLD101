import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {

    private final Map<String, MenuItem> items = new LinkedHashMap<>();

    public void addItem(MenuItem item) {
        items.put(item.id, item);
    }

    public Map<String, MenuItem> getItems() {
        return items;
    }
}
