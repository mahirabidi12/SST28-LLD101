package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable incident ticket with fluent Builder pattern.
 *
 * REFACTORED:
 * - All fields are final (immutability)
 * - No public setters
 * - Defensive copying for collections
 * - Builder pattern for construction
 * - Centralized validation in Builder.build()
 */
public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final Priority priority;
    private final List<String> tags;
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;
    private final String source;

    private IncidentTicket(Builder builder) {
        this.id = builder.id;
        this.reporterEmail = builder.reporterEmail;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority != null ? Priority.valueOf(builder.priority) : null;
        this.tags = builder.tags != null ? new ArrayList<>(builder.tags) : new ArrayList<>();
        this.assigneeEmail = builder.assigneeEmail;
        this.customerVisible = builder.customerVisible;
        this.slaMinutes = builder.slaMinutes;
        this.source = builder.source;
    }

    // Getters - defensive copy for collections
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority != null ? priority.name() : null; }
    public List<String> getTags() { return new ArrayList<>(tags); }
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String reporterEmail;
        private String title;
        private String description;
        private String priority;
        private List<String> tags;
        private String assigneeEmail;
        private boolean customerVisible;
        private Integer slaMinutes;
        private String source;

        public Builder id(String ticketId) {
            this.id = ticketId;
            return this;
        }

        public Builder reporterEmail(String email) {
            this.reporterEmail = email;
            return this;
        }

        public Builder title(String titleText) {
            this.title = titleText;
            return this;
        }

        public Builder description(String desc) {
            this.description = desc;
            return this;
        }

        public Builder priority(String priorityLevel) {
            this.priority = priorityLevel;
            return this;
        }

        public Builder tags(List<String> tagList) {
            this.tags = new ArrayList<>(tagList);
            return this;
        }

        public Builder assigneeEmail(String email) {
            this.assigneeEmail = email;
            return this;
        }

        public Builder customerVisible(boolean visible) {
            this.customerVisible = visible;
            return this;
        }

        public Builder slaMinutes(Integer minutes) {
            this.slaMinutes = minutes;
            return this;
        }

        public Builder source(String sourceType) {
            this.source = sourceType;
            return this;
        }

        public IncidentTicket build() {
            // Centralized validation
            Validation.requireTicketId(id);
            Validation.requireEmail(reporterEmail, "reporterEmail");
            Validation.requireTitle(title);
            Validation.requireOneOf(priority, "priority", "LOW", "MEDIUM", "HIGH", "CRITICAL", null);
            Validation.requireRange(slaMinutes, 5, 7200, "slaMinutes");

            return new IncidentTicket(this);
        }

        public Builder copyFrom(IncidentTicket ticket) {
            return new Builder()
                    .id(ticket.getId())
                    .reporterEmail(ticket.getReporterEmail())
                    .title(ticket.getTitle())
                    .description(ticket.getDescription())
                    .priority(ticket.getPriority())
                    .tags(ticket.getTags())
                    .assigneeEmail(ticket.getAssigneeEmail())
                    .customerVisible(ticket.isCustomerVisible())
                    .slaMinutes(ticket.getSlaMinutes())
                    .source(ticket.getSource());
        }
    }
}
