package com.cli.theWizardsBag.Menus.SupportMenus;

import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.ArrayList;
import java.util.List;

public class SelectAvailableSpellLevelMenu extends Menu {

    // ATTs
    SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
    String chosenSpellLevel;

    List<String> spellLevelList = spellJDBCExecutor.getAllSpellLevels();
    List<MenuOption> menuOptions = getMenuOptions(spellLevelList);



    // CONs
    public SelectAvailableSpellLevelMenu() {
        super("Enter the level of the spell: ");
        this.chosenSpellLevel = "n/a";
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<String> spellLevelList) {
        List<MenuOption> menuOptions = new ArrayList<>();

        for(String spellLevel : spellLevelList) {
            menuOptions.add(new MenuOption(spellLevel, () ->{
                chosenSpellLevel = spellLevel;
            }));
        }
        return menuOptions;
    }

    // GETs & SETs
    public String getChosenSpellLevel() {
        System.out.println("Selected Spell Level (SelectAvailableSpellLevel): " + this.chosenSpellLevel);
        return this.chosenSpellLevel;
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
