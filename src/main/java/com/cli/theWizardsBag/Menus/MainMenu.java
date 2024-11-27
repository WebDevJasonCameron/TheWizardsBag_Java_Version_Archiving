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

        addOption(new MenuOption("Add Spell", this::addSpell));
        addOption(new MenuOption("Edit Spell", this::editSpell));
        addOption(new MenuOption("View Spell", this::viewSpell));
        addOption(new MenuOption("Remove Spell", this::removeSpell));
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
        System.out.println("Adding a spell...");
        // Implementation for adding a spell
        CreateSpellMenu createSpellMenu = new CreateSpellMenu();
        createSpellMenu.display();
    }

    private void editSpell() {
        System.out.println("Editing a spell...");
        EditSpellMenu editSpellMenu = new EditSpellMenu();
        editSpellMenu.display();
    }

    private void viewSpell() {
        System.out.println("Viewing a spell...");
        ViewSpellMenu viewSpellMenu = new ViewSpellMenu();
        viewSpellMenu.display();
    }

    private void removeSpell() {
        System.out.println("Removing a spell...");
        // Implementation for removing a spell
    }

}
