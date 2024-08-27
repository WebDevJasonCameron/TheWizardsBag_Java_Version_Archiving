package com.cli.theWizardsBag.MenuCons;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    // ATTs
    protected String title;
    protected List<MenuOption> options;

    // CONs
    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }

    public abstract void display();
    public abstract void handleUserChoice(int choice);

}
