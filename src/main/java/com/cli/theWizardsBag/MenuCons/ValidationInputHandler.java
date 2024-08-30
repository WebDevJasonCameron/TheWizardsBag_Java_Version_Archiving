package com.cli.theWizardsBag.MenuCons;


import java.util.Scanner;

public class ValidationInputHandler implements InputHandler {

    // ATTs
    private Scanner scanner;

    // CONs
    public ValidationInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    // OVRs
    @Override
    public String handleInput() {
        String input = scanner.nextLine();
        return sanitizeInput(input);
    }

    // METHs
    private String sanitizeInput(String input) {
        String sanatizedInput = input.trim();
        sanatizedInput = sanatizedInput.replace("[<>]", "");
        sanatizedInput = sanatizedInput.replace("[\"';]", "");

        if (isValid(sanatizedInput)) {
            return sanatizedInput;
        } else {
            System.out.println("Invalid input, please try again");
            return handleInput();
        }
    }

    private boolean isValid(String input) {
        return !input.isEmpty();
    }

}
