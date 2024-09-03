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

        return sanatizedInput;
    }

    private int getValidateNumber(){
        while (true){
            String input = handleInput();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number");
            }
        }
    }

    public boolean getValidatedYesNo() {
        while (true) {
            String input = handleInput().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input, please enter 'y' or 'n'.");
            }
        }
    }
}
