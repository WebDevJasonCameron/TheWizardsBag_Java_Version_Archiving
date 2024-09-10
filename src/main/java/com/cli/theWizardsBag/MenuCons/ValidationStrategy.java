package com.cli.theWizardsBag.MenuCons;

public interface ValidationStrategy {

    // ATTs
    boolean isValid(String input);
    String sanitize(String input);
}
