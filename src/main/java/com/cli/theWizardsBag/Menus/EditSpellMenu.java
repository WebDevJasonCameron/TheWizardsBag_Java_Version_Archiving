package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import com.cli.theWizardsBag.MenuCons.TextValidationStrategy;
import com.cli.theWizardsBag.MenuCons.ValidationInputHandler;

import java.util.Scanner;

public class EditSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);

    // CONs
    public EditSpellMenu() {
        super("Edit Spell Menu");
        addOption(new MenuOption("Select Spell to Edit by Name", this::editByName));
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
        System.out.println("Enter the name of the spell to edit: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String spellName = inputHandler.handleInput();
        System.out.println("Editing spell with name: " + spellName);
        // Implementation for editing by name
    }

}
