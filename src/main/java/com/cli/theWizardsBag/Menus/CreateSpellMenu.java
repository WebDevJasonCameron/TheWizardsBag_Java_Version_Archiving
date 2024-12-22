package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.constants.enums.SpellSaveTypes;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import jdk.jfr.BooleanFlag;

import java.util.*;

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


        /*
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
        boolean spellComponentVisualOutput = false;

        List<Boolean> spellComponentVisualChoices = new ArrayList<>();
        spellComponentVisualChoices.add(Boolean.FALSE);
        spellComponentVisualChoices.add(Boolean.TRUE);

        Map<String, Boolean> spellComponentVisualChoicesList = new HashMap<>();
        int count = 0;
        for (Boolean spellComponentVisualChoice : spellComponentVisualChoices) {
            System.out.println((count += 1) + ". " + spellComponentVisualChoice);
            spellComponentVisualChoicesList.put(String.valueOf(count), spellComponentVisualChoice);
        }
        String spellComponentVisualChoiceNumber = scanner.nextLine();

        if (spellComponentVisualChoicesList.containsKey(spellComponentVisualChoiceNumber)) {
            spellComponentVisualOutput = spellComponentVisualChoicesList.get(spellComponentVisualChoiceNumber);
        } else {
            System.out.println("Unrecognized reply: " + spellComponentVisualChoiceNumber);
            System.out.println("Please try again.");
            setSpellRange();
        }

        return spellComponentVisualOutput;
    }

    private boolean isSpellComponentSemantic() {
        System.out.println("Is there a semantic component to the spell? ");
        boolean spellComponentSemanticOutput = false;

        List<Boolean> spellComponentSemanticChoices = new ArrayList<>();
        spellComponentSemanticChoices.add(Boolean.FALSE);
        spellComponentSemanticChoices.add(Boolean.TRUE);

        Map<String, Boolean> spellComponentSemanticChoicesList = new HashMap<>();
        int count = 0;
        for (Boolean spellComponentSemanticChoice : spellComponentSemanticChoices) {
            System.out.println((count += 1) + ". " + spellComponentSemanticChoice);
            spellComponentSemanticChoicesList.put(String.valueOf(count), spellComponentSemanticChoice);
        }
        String spellComponentSemanticChoiceNumber = scanner.nextLine();

        if (spellComponentSemanticChoicesList.containsKey(spellComponentSemanticChoiceNumber)) {
            spellComponentSemanticOutput = spellComponentSemanticChoicesList.get(spellComponentSemanticChoiceNumber);
        } else {
            System.out.println("Unrecognized reply: " + spellComponentSemanticChoiceNumber);
            System.out.println("Please try again.");
            setSpellRange();
        }

        return spellComponentSemanticOutput;
    }

    private boolean isSpellComponentMaterial() {
        System.out.println("Are there material components to the spell? ");
        boolean spellComponentMaterialOutput = false;

        List<Boolean> spellComponentMaterialChoices = new ArrayList<>();
        spellComponentMaterialChoices.add(Boolean.FALSE);
        spellComponentMaterialChoices.add(Boolean.TRUE);

        Map<String, Boolean> spellComponentMaterialChoicesList = new HashMap<>();
        int count = 0;
        for (Boolean spellComponentMaterialChoice : spellComponentMaterialChoices) {
            System.out.println((count += 1) + ". " + spellComponentMaterialChoice);
            spellComponentMaterialChoicesList.put(String.valueOf(count), spellComponentMaterialChoice);
        }
        String spellComponentMaterialChoiceNumber = scanner.nextLine();

        if (spellComponentMaterialChoicesList.containsKey(spellComponentMaterialChoiceNumber)) {
            spellComponentMaterialOutput = spellComponentMaterialChoicesList.get(spellComponentMaterialChoiceNumber);
        } else {
            System.out.println("Unrecognized reply: " + spellComponentMaterialChoiceNumber);
            System.out.println("Please try again.");
            setSpellRange();
        }

        return spellComponentMaterialOutput;
    }

    private String setSpellComponentMaterials() {
        System.out.println("Enter the materials of the spell: ");
        String materials = scanner.nextLine();
        return materials;
    }

    private String setSpellDuration() {
        Map<String, String> spellDurationDictionary = new HashMap<>();

        String spellDurationOutput = "";
        int count = 0;
        spellDurationDictionary.put(String.valueOf(count), "no duration");

        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<String> spellDurationList = spellJDBCExecutor.getAllSpellDuration();

        System.out.println("\t2) Enter the duration of the spell: ");

        System.out.println("0. No Range");
        for (String spellDuration : spellDurationList) {
            System.out.println((count += 1) + ". " + spellDuration);
            spellDurationDictionary.put(String.valueOf(count), spellDuration);
        }

        String spellDuration = scanner.nextLine();

        if (spellDurationDictionary.containsKey(spellDuration)) {
            spellDurationOutput = spellDurationDictionary.get(spellDuration);
        } else {
            System.out.println("Unrecognized spell duration: " + spellDuration);
            System.out.println("Please try again.");
            setSpellDuration();
        }

        System.out.println("\tThe chosen spell duration is : " + spellDurationOutput) ;
        return spellDurationOutput;
    }

    private boolean isSpellConcentration() {
        System.out.println("Is this a concentrated spell? ");
        boolean spellComponentConcentrationOutput = false;

        List<Boolean> spellComponentConcentrationChoices = new ArrayList<>();
        spellComponentConcentrationChoices.add(Boolean.FALSE);
        spellComponentConcentrationChoices.add(Boolean.TRUE);

        Map<String, Boolean> spellComponentConcentrationChoicesList = new HashMap<>();
        int count = 0;
        for (Boolean spellComponentConcentrationChoice : spellComponentConcentrationChoices) {
            System.out.println((count += 1) + ". " + spellComponentConcentrationChoice);
            spellComponentConcentrationChoicesList.put(String.valueOf(count), spellComponentConcentrationChoice);
        }
        String spellComponentConcentrationChoiceNumber = scanner.nextLine();

        if (spellComponentConcentrationChoicesList.containsKey(spellComponentConcentrationChoiceNumber)) {
            spellComponentConcentrationOutput = spellComponentConcentrationChoicesList.get(spellComponentConcentrationChoiceNumber);
        } else {
            System.out.println("Unrecognized reply: " + spellComponentConcentrationChoiceNumber);
            System.out.println("Please try again.");
            setSpellRange();
        }

        return spellComponentConcentrationOutput;
    }

    private boolean isSpellRitual() {
        System.out.println("Is this a ritual spell? ");
        boolean spellComponentRitualOutput = false;

        List<Boolean> spellComponentRitualChoices = new ArrayList<>();
        spellComponentRitualChoices.add(Boolean.FALSE);
        spellComponentRitualChoices.add(Boolean.TRUE);

        Map<String, Boolean> spellComponentRitualChoicesList = new HashMap<>();
        int count = 0;
        for (Boolean spellComponentRitualChoice : spellComponentRitualChoices) {
            System.out.println((count += 1) + ". " + spellComponentRitualChoice);
            spellComponentRitualChoicesList.put(String.valueOf(count), spellComponentRitualChoice);
        }
        String spellComponentRitualChoiceNumber = scanner.nextLine();

        if (spellComponentRitualChoicesList.containsKey(spellComponentRitualChoiceNumber)) {
            spellComponentRitualOutput = spellComponentRitualChoicesList.get(spellComponentRitualChoiceNumber);
        } else {
            System.out.println("Unrecognized reply: " + spellComponentRitualChoiceNumber);
            System.out.println("Please try again.");
            setSpellRange();
        }

        return spellComponentRitualOutput;
    }

    private String setSpellSchool() {
        Map<String, String> spellSchoolDictionary = new HashMap<>();

        String spellSchoolOutput = "";
        int count = 0;

        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
        List<String> spellSchoolList = spellJDBCExecutor.getAllSpellSchools();

        System.out.println("\t2) Enter the school the spell belongs to: ");

        for (String spellSchool : spellSchoolList) {
            System.out.println((count += 1) + ". " + spellSchool);
            spellSchoolDictionary.put(String.valueOf(count), spellSchool);
        }

        String spellSchool = scanner.nextLine();

        if (spellSchoolDictionary.containsKey(spellSchool)) {
            spellSchoolOutput = spellSchoolDictionary.get(spellSchool);
        } else {
            System.out.println("Unrecognized spell school: " + spellSchool);
            System.out.println("Please try again.");
            setSpellSchool();
        }

        System.out.println("\tThe chosen spell school is : " + spellSchoolOutput) ;
        return spellSchoolOutput;
    }

    private String setSpellSave() {
        Map<String, String> spellSaveDictionary = new HashMap<>();

        String spellSaveOutput = "";
        int count = 0;

        // List out the enums
        // Add the enums to a dictionary with numbers as keys
        // User selects key, that produces the values and output


        return "Reply with enum and change the db values to reflect the enums";
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
