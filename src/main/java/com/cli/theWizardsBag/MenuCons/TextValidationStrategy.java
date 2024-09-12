package com.cli.theWizardsBag.MenuCons;

public class TextValidationStrategy implements ValidationStrategy {

    // OVRs
    @Override
    public boolean isValid(String input) {
        return !input.trim().isEmpty();
    }

    @Override
    public String sanitize(String input) {
        String sanitized = input.trim();
        sanitized = sanitized.replaceAll("[\"';]", ""); // Remove quotes and semicolons
        return sanitized;
    }
}
