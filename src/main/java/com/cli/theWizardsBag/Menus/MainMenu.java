package com.cli.theWizardsBag.Menus;


import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

public class MainMenu extends Menu {

    // CONs
    public MainMenu() {
        super("Main Menu");
        addOption(new MenuOption("Add Item", this::addItem));
        addOption(new MenuOption("Edit Item", this::editItem));
        addOption(new MenuOption("View Item", this::viewItem));
        addOption(new MenuOption("Remove Item", this::removeItem));
    }

    // OVRs
    @Override
    protected void handleUserChoice(int choice) {
        if (choice > 0 && choice <= options.size()) {
            options.get(choice - 1).execute();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }

    // METHs
    private void addItem() {
        System.out.println("Adding an item...");
        // Implementation for adding an item
    }

    private void editItem() {
        System.out.println("Editing an item...");
        EditItemMenu editItemMenu = new EditItemMenu();
        editItemMenu.display();
    }

    private void viewItem() {
        System.out.println("Viewing an item...");
        // Implementation for viewing an item
    }

    private void removeItem() {
        System.out.println("Removing an item...");
        // Implementation for removing an item
    }

    private void addSpell() {
        System.out.println("Adding an spell...");
        // Implementation for adding a spell
    }

    private void editSpell() {
        System.out.println("Editing a spell...");
        // Implementation for editing a spell
    }

    private void viewSpell() {
        System.out.println("Viewing a spell...");
        // Implementation for viewing a spell
    }

    private void removeSpell() {
        System.out.println("Removing a spell...");
        // Implementation for removing a spell
    }
}
