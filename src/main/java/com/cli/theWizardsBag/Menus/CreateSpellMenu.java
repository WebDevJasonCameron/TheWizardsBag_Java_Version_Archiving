package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Spell;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.Scanner;

public class CreateSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);
    Spell spell = new Spell();

    /*  The Plan
    Create a spell container
    Ask the user
        - Name of spell
        - Level
        - Casting time
        - Casting range
        - If there are visual components
        - If there are semantic components
        - If there are material components
        -- if so, what are they
        - What is the Spells duration
        - Is the spell a concentration spell
        - Can the spell be a ritual
        - What school of magic does it belong to
        - Is there a save roll component to the spell
        - Provide a description
        - Provide an image url?
        - Do you want to add tag
        -- What tag
        -- Again?
        - Does the spell cause any conditions?
        -- What conditions do you want to add?
        - Does the spell cause a damage type?
        -- What damage types do you want to add?
        - What classes can use this spell?
     */

    // CONs
    public CreateSpellMenu() {
        super("Create Spell");
        addOption(new MenuOption("Would you like to create a spell?", this::spellCreation));
    }

    // METHs
    private Spell spellCreation() {
        System.out.println("Starting the spell creation...");
        spell.setSpellName(setSpellName());
        spell.setSpellLevel(setSpellLevel());
        spell.setSpellCastingTime(setSpellCastingTime());
        spell.setSpellRange(setSpellRange());
        spell.setSpellComponentsVisual(isSpellComponentVisual());
        spell.setSpellComponentsSemantic(isSpellComponentSemantic());
        spell.setSpellComponentsMaterial(isSpellComponentMaterial());
        if (spell.isSpellComponentsMaterial() == true) {
            spell.setSpellComponentsMaterials(setSpellComponentMaterials());
        }
        spell.setSpellDuration(setSpellDuration());
        spell.setSpellConcentration(isSpellConcentration());
        spell.setSpellRitual(isSpellRitual());
        spell.setSpellSchool(setSpellSchool());
        spell.setSpellSaveType(setSpellSave());
        spell.setSpellDescription(setSpellDescription());
        spell.setSpellImageUrl(setSpellImageUrl());


        return spell;
    }

    // SUP METHs
    private String setSpellName() {
        System.out.println("Enter the name of the spell: ");
        String spellName = scanner.nextLine();
        return spellName;
    }

    private String setSpellLevel() {
        System.out.println("Enter the level of the spell: ");
        String spellLevel = scanner.nextLine();                         // <!> This changes to a selection
        return spellLevel;
    }

    private String setSpellCastingTime() {
        System.out.println("Enter the casting time: ");
        String castingTime = scanner.nextLine();                         // <!> This changes to a selection
        return castingTime;
    }

    private String setSpellRange() {
        System.out.println("Enter the range of the spell: ");
        String spellRange = scanner.nextLine();                          // <!> This changes to a selection
        return spellRange;
    }

    private boolean isSpellComponentVisual() {
        System.out.println("Is there a visual component to the spell? ");
        return scanner.nextBoolean();
    }

    private boolean isSpellComponentSemantic() {
        System.out.println("Is there a semantic component to the spell? ");
        return scanner.nextBoolean();
    }

    private boolean isSpellComponentMaterial() {
        System.out.println("Is there a visual component to the spell? ");
        return scanner.nextBoolean();
    }

    private String setSpellComponentMaterials() {
        System.out.println("Enter the materials of the spell: ");
        String materials = scanner.nextLine();
        return materials;
    }

    private String setSpellDuration() {
        System.out.println("Enter the duration of the spell: ");
        String duration = scanner.nextLine();                          // <!> This changes to a selection
        return duration;
    }

    private boolean isSpellConcentration() {
        System.out.println("Is there a concentration component to the spell? ");
        return scanner.nextBoolean();
    }

    private boolean isSpellRitual() {
        System.out.println("Is there a ritual component to the spell? ");
        return scanner.nextBoolean();
    }

    private String setSpellSchool() {
        System.out.println("Enter the school of the spell: ");
        String spellSchool = scanner.nextLine();                        // <!> This changes to a selection
        return spellSchool;
    }

    private String setSpellSave() {
        System.out.println("Enter the name of the spell: ");
        String spellSave = scanner.nextLine();
        return spellSave;
    }

    private String setSpellDescription() {
        System.out.println("Enter the description of the spell: ");
        String spellDescription = scanner.nextLine();
        return spellDescription;
    }

    private String setSpellImageUrl() {
        System.out.println("Enter the image url of the spell: ");
        String spellImageUrl = scanner.nextLine();
        return spellImageUrl;
    }

    /* Return ArrayList of
    - tags
    - conditions
    - damage types
    - class
     */


    // OVR
    @Override
    protected void handleUserChoice(int choice) {
        if (choice > 0 && choice <= options.size()) {
            options.get(choice - 1).execute();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }
}
