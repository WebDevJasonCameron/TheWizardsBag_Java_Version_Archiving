package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CreateSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);
    Spell spell = new Spell();

    // CONs
    public CreateSpellMenu() {
        super("Create Spell");
        addOption(new MenuOption("Would you like to create a spell?", this::spellCreation));
    }

    // METHs
    private Spell spellCreation() {
        System.out.println("\nTo Start the spell creation process, we need to fill out some parameters...");
        spell.setSpellName(setSpellName());
        spell.setSpellLevel(setSpellLevel());
        spell.setSpellCastingTime(setSpellCastingTime());
        spell.setSpellRange(setSpellRange());
        spell.setSpellComponentsVisual(isSpellComponentVisual());

        /*
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
        */

        return spell;
    }

    // SUP METHs
    private String setSpellName() {
        System.out.println("===================\n\t1) Enter the name of the spell: ");
        String spellName = scanner.nextLine();
        System.out.println("Spell name: " + spellName + "\n");
        return spellName;
    }

    private String setSpellLevel() {
        Map<String, String> spellLevelDictionary = new HashMap<>();

        String spellLevelOutput = "";
        int count = 0;
        spellLevelDictionary.put(String.valueOf(count), "no level");

        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<String> spellLevelList = spellJDBCExecutor.getAllSpellLevels();

        System.out.println("\t2) Enter the level of the spell: ");

        System.out.println("0. No Level");
        for (String spellLevel : spellLevelList) {
            System.out.println((count += 1) + ". " + spellLevel);
            spellLevelDictionary.put(String.valueOf(count), spellLevel);
        }

        String spellLevel = scanner.nextLine();

        if (spellLevelDictionary.containsKey(spellLevel)) {
            spellLevelOutput = spellLevelDictionary.get(spellLevel);
        } else {
            System.out.println("Unrecognized spell level: " + spellLevel);
            System.out.println("Please try again.");
            setSpellLevel();
        }

        System.out.println("\tThe chosen spell level is : " + spellLevelOutput) ;
        return spellLevelOutput;

    }

    private String setSpellCastingTime() {
        Map<String, String> spellCastingTimeDictionary = new HashMap<>();

        String spellCastingTimeOutput = "";
        int count = 0;
        spellCastingTimeDictionary.put(String.valueOf(count), "no casting time");

        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<String> spellCastingTimeList = spellJDBCExecutor.getAllSpellCastingTime();

        System.out.println("\t2) Enter the Casting Time of the spell: ");

        System.out.println("0. No Casting Time");
        for (String spellCastingTime : spellCastingTimeList) {
            System.out.println((count += 1) + ". " + spellCastingTime);
            spellCastingTimeDictionary.put(String.valueOf(count), spellCastingTime);
        }

        String spellCastingTime = scanner.nextLine();

        if (spellCastingTimeDictionary.containsKey(spellCastingTime)) {
            spellCastingTimeOutput = spellCastingTimeDictionary.get(spellCastingTime);
        } else {
            System.out.println("Unrecognized spell casting time: " + spellCastingTime);
            System.out.println("Please try again.");
            setSpellCastingTime();
        }

        System.out.println("\tThe chosen spell casting time is : " + spellCastingTimeOutput) ;
        return spellCastingTimeOutput;
    }

    private String setSpellRange() {
        Map<String, String> spellRangeDictionary = new HashMap<>();

        String spellRangeOutput = "";
        int count = 0;
        spellRangeDictionary.put(String.valueOf(count), "no range");

        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<String> spellRangeList = spellJDBCExecutor.getAllSpellRange();

        System.out.println("\t2) Enter the range of the spell: ");

        System.out.println("0. No Range");
        for (String spellRange : spellRangeList) {
            System.out.println((count += 1) + ". " + spellRange);
            spellRangeDictionary.put(String.valueOf(count), spellRange);
        }

        String spellRange = scanner.nextLine();

        if (spellRangeDictionary.containsKey(spellRange)) {
            spellRangeOutput = spellRangeDictionary.get(spellRange);
        } else {
            System.out.println("Unrecognized spell range: " + spellRange);
            System.out.println("Please try again.");
            setSpellRange();
        }

        System.out.println("\tThe chosen spell range is : " + spellRangeOutput) ;
        return spellRangeOutput;
    }

    private boolean isSpellComponentVisual() {
        System.out.println("Is there a visual component to the spell? ");

        Map<String, Boolean> spellComponentBooleanOptions = new HashMap<>();
        boolean spellComponentVisualOutput = false;

        int count = 1;
        spellComponentBooleanOptions.put(String.valueOf(count), false);
        spellComponentBooleanOptions.put(String.valueOf(count), true);

        for (String spellComponent : spellComponentBooleanOptions.keySet()) {
            System.out.println(spellComponent);      // <!><!>true or false, but doesn't work correctly
        }


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
