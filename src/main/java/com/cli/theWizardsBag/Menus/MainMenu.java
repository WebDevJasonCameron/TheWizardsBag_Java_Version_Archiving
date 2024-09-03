package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

public class MainMenu extends Menu {

    // CONs
    public MainMenu() {
        super("Main Menu");

        addOption(new MenuOption("Add Item", () -> {
            System.out.println("Add Magical Item...");
        }));

        addOption(new MenuOption("Edit Item", () -> {
            System.out.println("Edit Magical Item...");
        }));

        addOption(new MenuOption("View Item", () -> {
            System.out.println("View Magical Item...");
        }));

        addOption(new MenuOption("Delete Item", () -> {
            System.out.println("Delete Magical Item...");
        }));

        addOption(new MenuOption("Add Spell", () -> {
            System.out.println("Add Magical Spell...");
        }));

        addOption(new MenuOption("Edit Spell", () -> {
            System.out.println("Edit Magical Spell...");
        }));

        addOption(new MenuOption("View Spell", () -> {
            System.out.println("View Magical Spell...");
        }));

        addOption(new MenuOption("Delete Spell", () -> {
            System.out.println("Delete Magical Spell...");
        }));
    }

    // OVRs
    @Override
    public void display() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i).getName());
        }
    }

    @Override
    public void handleUserChoice(int choice) {
        if(choice > 0 && choice < options.size()) {
            options.get(choice -1).execute();
        } else if(choice < options.size()) {
            System.out.println("Invalid choice, please try again.");
        }
    }
}
