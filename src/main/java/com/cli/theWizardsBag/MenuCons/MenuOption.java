package com.cli.theWizardsBag.MenuCons;

public class MenuOption {

    // ATTs
    private String name;
    private Runnable action;

    // CONs
    public MenuOption(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    // GETs & SETs
    public String getName() {
        return name;
    }

    // METHs
    public void execute() {
        action.run();
    }
}
