package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.RpgClass;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.models.SpellClass;
import com.backend.theWizardsBag.utils.Executables.RpgClassJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellClassJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
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

    private void viewByRPGClassId(Long rpgClassId){
        SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();

        List<SpellClass> spellClasses = spellClassJDBCExecutor.getAllByClassId(rpgClassId);

        List<Spell> spells = new ArrayList<Spell>();

        for (SpellClass spellClass : spellClasses) {
            spells.add(spellJDBCExecutor.getById(spellClass.getSpellsSpellId()));
        }

        System.out.println("The following spells can be used by this RPG class: \n");

        for (Spell spell : spells) {
            System.out.println(spell.getSpellName());
        }
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
