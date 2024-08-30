package com.cli.theWizardsBag.MenuCons;

public class MenuOption {

    // ATTs
    private String name;
    private Runnable action;
    private InputHandler inputHandler; // Interface for handling specific inputs

    // CONs
    public MenuOption(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public MenuOption(String name, Runnable action, InputHandler inputHandler) {
        this.name = name;
        this.action = action;
        this.inputHandler = inputHandler;
    }

    // GETs & SETs
    public String getName() {
        return name;
    }

    // METHs
    public void execute() {
        if (inputHandler != null) {
            String userInput = inputHandler.handleInput();
        }
        action.run();
    }
}
