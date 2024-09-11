package com.cli.theWizardsBag.MenuCons;

public class YesNoValidationStrategy implements ValidationStrategy {

    // OVRs
    @Override
    public boolean isValid(String input) {
        String sanitized = sanitize(input);
        return "y".equalsIgnoreCase(sanitized) || "n".equalsIgnoreCase(sanitized);
    }

    @Override
    public String sanitize(String input) {
        return input.trim().toLowerCase();
    }
}
