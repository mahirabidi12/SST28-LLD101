package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for ticket operations.
 *
 * REFACTORED:
 * - No longer mutates tickets after creation
 * - All "update" operations return NEW ticket instances
 * - Validation is centralized in Builder
 */
public class TicketService {

    public IncidentTicket createTicket(String ticketId, String reporterEmail, String titleText) {
        // Basic pre-checks (actual validation happens in Builder)
        if (ticketId == null || ticketId.trim().isEmpty()) {
            throw new IllegalArgumentException("id required");
        }
        if (reporterEmail == null || !reporterEmail.contains("@")) {
            throw new IllegalArgumentException("email invalid");
        }
        if (titleText == null || titleText.trim().isEmpty()) {
            throw new IllegalArgumentException("title required");
        }

        IncidentTicket ticket = new IncidentTicket.Builder()
                .id(ticketId)
                .reporterEmail(reporterEmail)
                .title(titleText)
                .build();

        List<String> initialTags = new ArrayList<>();
        initialTags.add("NEW");

        ticket = new IncidentTicket.Builder()
                .copyFrom(ticket)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(initialTags)
                .build();

        return ticket;
    }

    public IncidentTicket escalateToCritical(IncidentTicket ticket) {
        List<String> updatedTags = new ArrayList<>(ticket.getTags());
        updatedTags.add("ESCALATED");

        return new IncidentTicket.Builder()
                .copyFrom(ticket)
                .priority("CRITICAL")
                .tags(updatedTags)
                .build();
    }

    public IncidentTicket assign(IncidentTicket ticket, String assigneeEmail) {
        return new IncidentTicket.Builder()
                .copyFrom(ticket)
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
