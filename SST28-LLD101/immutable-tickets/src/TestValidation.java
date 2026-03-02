import com.example.tickets.IncidentTicket;

public class TestValidation {
    public static void main(String[] args) {
        System.out.println("Testing Validation Rules:\n");
        
        // Test 1: Valid ticket
        try {
            IncidentTicket t = new IncidentTicket.Builder()
                .id("TCK-123")
                .reporterEmail("user@example.com")
                .title("Test ticket")
                .build();
            System.out.println("✅ Test 1 PASS: Valid ticket created");
        } catch (Exception e) {
            System.out.println("❌ Test 1 FAIL: " + e.getMessage());
        }
        
        // Test 2: Invalid ID (too long)
        try {
            IncidentTicket t = new IncidentTicket.Builder()
                .id("TCK-123456789012345678901")
                .reporterEmail("user@example.com")
                .title("Test")
                .build();
            System.out.println("❌ Test 2 FAIL: Should reject long ID");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test 2 PASS: Rejected long ID - " + e.getMessage());
        }
        
        // Test 3: Invalid email
        try {
            IncidentTicket t = new IncidentTicket.Builder()
                .id("TCK-123")
                .reporterEmail("not-an-email")
                .title("Test")
                .build();
            System.out.println("❌ Test 3 FAIL: Should reject invalid email");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test 3 PASS: Rejected invalid email - " + e.getMessage());
        }
        
        // Test 4: Invalid priority
        try {
            IncidentTicket t = new IncidentTicket.Builder()
                .id("TCK-123")
                .reporterEmail("user@example.com")
                .title("Test")
                .priority("INVALID")
                .build();
            System.out.println("❌ Test 4 FAIL: Should reject invalid priority");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test 4 PASS: Rejected invalid priority - " + e.getMessage());
        }
        
        // Test 5: Invalid SLA (too low)
        try {
            IncidentTicket t = new IncidentTicket.Builder()
                .id("TCK-123")
                .reporterEmail("user@example.com")
                .title("Test")
                .slaMinutes(3)
                .build();
            System.out.println("❌ Test 5 FAIL: Should reject SLA < 5");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test 5 PASS: Rejected low SLA - " + e.getMessage());
        }
        
        // Test 6: Valid with all optional fields
        try {
            IncidentTicket t = new IncidentTicket.Builder()
                .id("TCK-123")
                .reporterEmail("user@example.com")
                .title("Test")
                .priority("HIGH")
                .slaMinutes(60)
                .assigneeEmail("agent@example.com")
                .customerVisible(true)
                .source("WEBHOOK")
                .build();
            System.out.println("✅ Test 6 PASS: Valid ticket with all optional fields");
        } catch (Exception e) {
            System.out.println("❌ Test 6 FAIL: " + e.getMessage());
        }
    }
}
