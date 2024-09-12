package com.cli.theWizardsBag.MenuCons;

import java.util.Scanner;

public class ValidationInputHandler implements InputHandler {

    // ATTs
    private Scanner scanner;
    private ValidationStrategy strategy;

    // CONs
    public ValidationInputHandler(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public ValidationInputHandler(Scanner scanner, ValidationStrategy strategy) {
        this.scanner = scanner;
        this.strategy = strategy;
    }

    // OVRs
    @Override
    public String handleInput() {
        while (true) {
            String input = scanner.nextLine();
            String sanitized = strategy.sanitize(input);

            if (strategy.isValid(sanitized)) {
                return sanitized;
            } else {
                System.out.println("Invalid input, please try again: ");
            }
        }
    }
}
