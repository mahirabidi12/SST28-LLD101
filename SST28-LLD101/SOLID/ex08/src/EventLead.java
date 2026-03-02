/**
 * Role interface: event creation and count.
 */
public interface EventLead {

    void createEvent(String name, double budget);

    int getEventsCount();
}
