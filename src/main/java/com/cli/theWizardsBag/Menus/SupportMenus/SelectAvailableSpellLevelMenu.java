package com.cli.theWizardsBag.Menus.SupportMenus;

import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.ArrayList;
import java.util.List;

public class SelectAvailableSpellLevelMenu extends Menu {

    // ATTs
    SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
    List<String> spellLevelList = spellJDBCExecutor.getAllSpellLevels();
    List<MenuOption> menuOptions = getMenuOptions(spellLevelList);
    String chosenSpellLevel;


    // CONs
    public SelectAvailableSpellLevelMenu() {
        super("Enter the level of the spell: ");
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<String> spellLevelList) {
        List<MenuOption> menuOptions = new ArrayList<>();
        for(String spellLevel : spellLevelList) {
            menuOptions.add(new MenuOption(spellLevel, () ->{
                System.out.println("Selected Spell Level (SelectAvailableSpellLevel): " + spellLevel);
                chosenSpellLevel = spellLevel;
            }));
        }
        return menuOptions;
    }

    // GETs & SETs
    public String getChosenSpellLevel() {
        return chosenSpellLevel;
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
