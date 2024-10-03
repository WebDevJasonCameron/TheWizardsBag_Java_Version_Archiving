package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ViewSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);

    // CONs
    public ViewSpellMenu() {
        super("View Spell Menu");
        addOption(new MenuOption("Select Spell to View by Name: ", this::viewByName));
        addOption(new MenuOption("Search for Spells with a Word in Their Name: ", this::viewByWordInSpellName));
        addOption(new MenuOption("Select Spells to View by Level: ", this::viewByLevel));
        addOption(new MenuOption("Select Spells to View by Casting Time: ", this::viewByCastingTime));
        addOption(new MenuOption("Select Spells to View by Range: ", this::viewByRange));
        addOption(new MenuOption("Select Spells to View if Concentration Type: ", this::viewByConcentration));
        addOption(new MenuOption("Select Spells to View by School Attribute: ", this::viewBySchool));
        addOption(new MenuOption("Select Spells to View by Source: ", this::viewBySource));
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

    private void viewByWordInSpellName() {
        System.out.println("Search for Spells with a Word in Their Name: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String word = inputHandler.handleInput();
        System.out.println("Searched for spells with the following word in its name: " + word);
        // Implementation for viewing by name search
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<Spell> spells = spellJDBCExecutor.getAllByWordInSpellName(word);

        if (spells.size() == 0) {
            System.out.println("No spells found with name: " + word);
        } else {
            for (int i = 0; i < spells.size(); i++) {
                Spell spell = spells.get(i);
                System.out.println(spell.getSpellName());
            }
        }
    }

    private void viewByLevel() {
        System.out.println("Enter the level of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String level = inputHandler.handleInput();
        System.out.println("Viewing spells with level: " + level);
        // Implementation for viewing by level
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<Spell> spells = spellJDBCExecutor.getAllByLevel(level);

        if (spells.size() == 0) {
            System.out.println("No spells found with the level: " + level);
        } else {
            for (int i = 0; i < spells.size(); i++) {
                Spell spell = spells.get(i);
                System.out.println(spell.getSpellName());
            }
        }
    }

    private void viewByCastingTime() {
        System.out.println("Enter the casting time of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String castingTime = inputHandler.handleInput();
        System.out.println("Viewing spells with casting time: " + castingTime);
        // Implementation for viewing by casting time
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<Spell> spells = spellJDBCExecutor.getAllByCastingTime(castingTime);

        if (spells.size() == 0) {
            System.out.println("No spells found with the casting time of: " + castingTime);
        } else {
            for (int i = 0; i < spells.size(); i++) {
                Spell spell = spells.get(i);
                System.out.println(spell.getSpellName());
            }
        }
    }

    private void viewByRange() {
        System.out.println("Enter the range of the spells to view: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new TextValidationStrategy());
        String range = inputHandler.handleInput();
        System.out.println("Viewing spells with range: " + range);
        // Implementation for viewing by range
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<Spell> spells = spellJDBCExecutor.getAllByRange(range);

        if (spells.size() == 0) {
            System.out.println("No spells found with the range of: " + range);
        } else {
            for (int i = 0; i < spells.size(); i++) {
                Spell spell = spells.get(i);
                System.out.println(spell.getSpellName());
            }
        }
    }


    private void viewByConcentration() {
        System.out.println("Enter 'y' for concentration spells or 'n' for non-concentration spells spells: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,  new YesNoValidationStrategy());
        String concentration = inputHandler.handleInput();
        System.out.println("Viewing spells with concentration: " + concentration);
        // Implementation for viewing by concentration
        boolean word = concentration.equals("y")? true: false;

        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<Spell> spells = spellJDBCExecutor.getAllByConcentration(word);

        if (spells.size() == 0) {
            System.out.println("Error concentrating.  We did not find spells for or against concentration");
        } else {
            for (int i = 0; i < spells.size(); i++) {
                Spell spell = spells.get(i);
                System.out.println(spell.getSpellName());
            }
        }
    }

    private void viewBySchool() {
        System.out.print("Enter the spell school the spells you want to view belongs to: ");
        ValidationInputHandler inputHandler = new ValidationInputHandler(this.scanner,new TextValidationStrategy());
        String school = inputHandler.handleInput();
        System.out.println("Here are the spells from the " + school + " spell school:");
        // Implementation for viewing by spell school
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<Spell> spells = spellJDBCExecutor.getAllBySpellSchool(school);

        if (spells.size() == 0) {
            System.out.println("No spells found with the school of: " + school);
        } else {
            for (int i = 0; i < spells.size(); i++) {
                Spell spell = spells.get(i);
                System.out.println(spell.getSpellName());
            }
        }
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
