package com.example.tickets;

import java.util.regex.Pattern;

/**
 * Centralized validation utilities for ticket fields.
 *
 * All validation logic is consolidated here to avoid duplication.
 */
public final class Validation {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private static final Pattern ID_PATTERN = Pattern.compile("^[A-Z0-9-]+$");

    private Validation() {}

    public static void requireNonBlank(String val, String field) {
        if (val == null || val.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
    }

    public static void requireMaxLen(String val, int maxLength, String field) {
        if (val != null && val.length() > maxLength) {
            throw new IllegalArgumentException(field + " must be <= " + maxLength + " chars");
        }
    }

    public static void requireEmail(String email, String field) {
        requireNonBlank(email, field);
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException(field + " must be a valid email");
        }
    }

    public static void requireTicketId(String ticketId) {
        requireNonBlank(ticketId, "id");
        requireMaxLen(ticketId, 20, "id");
        if (!ID_PATTERN.matcher(ticketId).matches()) {
            throw new IllegalArgumentException("id must match " + ID_PATTERN.pattern());
        }
    }

    public static void requireOneOf(String val, String field, String... allowedValues) {
        if (val == null) return; // optional field
        for (String allowed : allowedValues) {
            if (allowed.equals(val)) return;
        }
        throw new IllegalArgumentException(field + " must be one of: " + String.join(", ", allowedValues));
    }

    public static void requireRange(Integer val, int minVal, int maxVal, String field) {
        if (val == null) return; // optional field
        if (val < minVal || val > maxVal) {
            throw new IllegalArgumentException(field + " must be between " + minVal + " and " + maxVal);
        }
    }

    public static void requireTitle(String titleText) {
        requireNonBlank(titleText, "title");
        requireMaxLen(titleText, 80, "title");
    }
}
