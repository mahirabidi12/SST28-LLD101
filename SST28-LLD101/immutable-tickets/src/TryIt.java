import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Demo showing immutability benefits.
 *
 * After refactor:
 * - Direct mutation no longer compiles (no setters)
 * - External modifications to tags do not affect the ticket
 * - Service "updates" return NEW ticket instances
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket ticket = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created:\n " + ticket);

        // Service methods now return new instances
        IncidentTicket updatedTicket = service.assign(ticket, "agent@example.com");
        updatedTicket = service.escalateToCritical(updatedTicket);

        System.out.println("\nOriginal after service mutations:\n " + ticket);
        System.out.println("\nNew ticket after service mutations:\n " + updatedTicket);

        // External tag mutation no longer affects the ticket (defensive copy)
        List<String> tagsCopy = updatedTicket.getTags();
        tagsCopy.add("HACKED_FROM_OUTSIDE");
        System.out.println("\nAfter external tag mutation:\n " + updatedTicket);
    }
}
