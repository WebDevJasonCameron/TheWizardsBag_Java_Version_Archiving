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


    // CONs
    public SelectAvailableSpellLevelMenu(String title) {
        super(title);
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<String> spellLevelList) {
        List<MenuOption> menuOptions = new ArrayList<>();
        for(String spellLevel : spellLevelList) {
            System.out.println(spellLevel);
        }
        return menuOptions;             // <!> Fix this....
    }



    // OVRs
    @Override
    protected void handleUserChoice(int choice) {

    }
}
