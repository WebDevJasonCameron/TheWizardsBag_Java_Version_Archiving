package com.cli.theWizardsBag.MenuCons;

public class NumberValidationStrategy implements ValidationStrategy {

    // OVRs
    @Override
    public boolean isValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String sanitize(String input) {
        return input.trim();
    }
}
