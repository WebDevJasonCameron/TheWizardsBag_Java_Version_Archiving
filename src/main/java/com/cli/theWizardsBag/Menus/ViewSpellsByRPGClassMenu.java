package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.RpgClass;
import com.backend.theWizardsBag.utils.Executables.RpgClassJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.ArrayList;
import java.util.List;


public class ViewSpellsByRPGClassMenu extends Menu {

    RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
    List<RpgClass> rpgClasses = rpgClassJDBCExecutor.getAll();
    List<MenuOption> menuOptions = getMenuOptions(rpgClasses);

    // CONs
    public ViewSpellsByRPGClassMenu(String title) {
        super(title);
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<RpgClass> rpgClasses) {
        List<MenuOption> menuOptionsOutput = new ArrayList<>();
        for (RpgClass rpgClass : rpgClasses) {
            menuOptionsOutput.add(new MenuOption(rpgClass.getClassName(), () -> {
                System.out.println("You chose " + rpgClass.getClassName());
                // <!> viewByRPGClassID(rpgClass.getRpgClassId()
            }));
        }
        return menuOptionsOutput;
    }


    // OVRs
    @Override
    protected void handleUserChoice(int choice) {

    }
}
