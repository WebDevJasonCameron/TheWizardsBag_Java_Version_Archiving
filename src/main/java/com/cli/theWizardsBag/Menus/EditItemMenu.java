package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import com.cli.theWizardsBag.MenuCons.TextValidationStrategy;
import com.cli.theWizardsBag.MenuCons.ValidationInputHandler;

import java.util.Scanner;

public class EditItemMenu extends Menu {

    Scanner scanner = new Scanner(System.in);

    // CONs
    public EditItemMenu() {
        super("Edit Item Menu");
        addOption(new MenuOption("Edit by Name", this::editByName));
        addOption(new MenuOption("Edit by Attribute", this::editByAttribute));
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
    private void editByName(){
        System.out.println("Enter the name of the item to edit: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String itemName = inputHandler.handleInput();
        System.out.println("Editing item with name: " + itemName);
        // Implementation for editing by name
    }

    private void editByAttribute() {
        System.out.print("Enter the attribute to edit: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,new TextValidationStrategy());
        String attribute = inputHandler.handleInput();
        System.out.println("Editing item with attribute: " + attribute);
        // Implementation for editing by attribute
    }

}
