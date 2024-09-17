package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import com.cli.theWizardsBag.MenuCons.TextValidationStrategy;
import com.cli.theWizardsBag.MenuCons.ValidationInputHandler;

import java.util.Scanner;

public class ViewSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);

    // CONs
    public ViewSpellMenu() {
        super("View Spell Menu");
        addOption(new MenuOption("Select Spell to View by Name", this::viewByName));
        addOption(new MenuOption("Select Spells to View by Level", this::viewByLevel));
        addOption(new MenuOption("Select Spells to View by Casting Time", this::viewByCastingTime));
        addOption(new MenuOption("Select Spells to View by Range", this::viewByRange));
        addOption(new MenuOption("Select Spells to View if Concentration Type", this::viewByConcentration));
        addOption(new MenuOption("Select Spells to View by School Attribute", this::viewByAttribute));
        addOption(new MenuOption("Select Spells to View by Source", this::viewBySource));
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
    private void viewByName(){
        System.out.println("Enter the name of the spell to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String spellName = inputHandler.handleInput();
        System.out.println("Viewing spell with name: " + spellName);
        // Implementation for viewing by name
    }

    private void viewByLevel() {
    }

    private void viewByCastingTime() {
    }

    private void viewByRange() {
    }

    private void viewByConcentration() {
    }

    private void viewByAttribute() {
        System.out.print("Enter the school attribute the spells you want to view belongs to: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,new TextValidationStrategy());
        String attribute = inputHandler.handleInput();
        System.out.println("Here are the spells from the " + attribute + " spell school:");
        // Implementation for viewing by attribute
    }

    private void viewBySource() {
    }

}
