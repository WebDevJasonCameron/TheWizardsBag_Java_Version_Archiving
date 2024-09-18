package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import com.cli.theWizardsBag.MenuCons.TextValidationStrategy;
import com.cli.theWizardsBag.MenuCons.ValidationInputHandler;

import java.sql.SQLOutput;
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

    // METHs
    private void viewByName(){
        System.out.println("Enter the name of the spell to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String spellName = inputHandler.handleInput();
        System.out.println("Viewing spell with name: " + spellName);
        // Implementation for viewing by name
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        Spell spell = spellJDBCExecutor.getBySpellName(spellName);

        if (spell.getSpellName() == null) {
            System.out.println("No spell found with name: " + spellName);
        } else {
            System.out.println("- Name: " + spell.getSpellName());
            System.out.println("- Class List: " + spell.getClassList());
            System.out.println("- Description: " + spell.getSpellDescription());
            System.out.println("- Duration: " + spell.getSpellDuration());
            System.out.println("- Level: " + spell.getSpellLevel());
            System.out.println("- Casting Time: " + spell.getSpellCastingTime());
            System.out.println("- Condition List: " + spell.getConditionList());
            System.out.println("- Component Materials: " + spell.getSpellComponentsMaterials());
        }
    }

    private void viewByLevel() {
        System.out.println("Enter the level of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String level = inputHandler.handleInput();
        System.out.println("Viewing spells with level: " + level);
        // Implementation for viewing by level
    }

    private void viewByCastingTime() {
        System.out.println("Enter the casting time of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String castingTime = inputHandler.handleInput();
        System.out.println("Viewing spells with casting time: " + castingTime);
        // Implementation for viewing by casting time
    }

    private void viewByRange() {
        System.out.println("Enter the range of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String range = inputHandler.handleInput();
        System.out.println("Viewing spells with range: " + range);
        // Implementation for viewing by range
    }

    private void viewByConcentration() {
        System.out.println("Enter the concentration type of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String concentration = inputHandler.handleInput();
        System.out.println("Viewing spells with concentration type: " + concentration);
        // Implementation for viewing by concentration
    }

    private void viewByAttribute() {
        System.out.print("Enter the spell school the spells you want to view belongs to: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,new TextValidationStrategy());
        String school = inputHandler.handleInput();
        System.out.println("Here are the spells from the " + school + " spell school:");
        // Implementation for viewing by spell school
    }

    private void viewBySource() {
        System.out.println("Enter the source of the spells you want to view belongs to: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,new TextValidationStrategy());
        String source = inputHandler.handleInput();
        System.out.println("Here are the spells from " + source + " source:");
        // Implementation for viewing by source
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

}
