package com.cli.theWizardsBag.MenuCons;

public class MenuOption {
    private String name;
    private Runnable action;

    public MenuOption(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        action.run();
    }
}
