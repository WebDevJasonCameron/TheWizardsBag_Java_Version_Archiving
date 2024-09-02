package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import com.cli.theWizardsBag.MenuCons.NumericInputHandler;

public class MainMenu extends Menu {

    // CONs
    public MainMenu() {
        super("Main Menu");

        addOption(new MenuOption("Add Item", () -> {
            System.out.println("Add Magical Item...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("Edit Item", () -> {
            System.out.println("Edit Magical Item...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("View Item", () -> {
            System.out.println("View Magical Item...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("Delete Item", () -> {
            System.out.println("Delete Magical Item...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("Add Spell", () -> {
            System.out.println("Add Magical Spell...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("Edit Spell", () -> {
            System.out.println("Edit Magical Spell...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("View Spell", () -> {
            System.out.println("View Magical Spell...");
        }, new NumericInputHandler()));

        addOption(new MenuOption("Delete Spell", () -> {
            System.out.println("Delete Magical Spell...");
        }, new NumericInputHandler()));
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
