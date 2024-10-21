package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Damagetype;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.models.SpellDamagetype;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.Executables.DamagetypeJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellTagJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.ArrayList;
import java.util.List;

public class ViewSpellsByDamagetypeMenu extends Menu {

    DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
    List<Damagetype> damagetypes = damagetypeJDBCExecutor.getAll();
    List<MenuOption> menuOptions = getMenuOptions(damagetypes);


    // CONs
    public ViewSpellsByDamagetypeMenu(String title) {
        super(title);
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<Damagetype> damagetypes) {
        List<MenuOption> menuOptionsOutput = new ArrayList<>();
        for (Damagetype damagetype : damagetypes) {
            menuOptionsOutput.add(new MenuOption(damagetype.getDamagetypeName(), () -> {
                System.out.println("You chose " + damagetype.getDamagetypeName());
                // More here
            }));
        }
        return menuOptionsOutput;
    }

    private void viewByDamagetypeId(Long DamagetypeId){
        DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();


        //List<SpellTag> spellTags = spellTagJDBCExecutor.getAllByTagId(DamagetypeId);
        List<SpellDamagetype> spellDamagetypes = damagetypeJDBCExecutor.getAllByDamagetypeId(DamagetypeId);

        List<Spell> spells = new ArrayList<>();

        for (SpellDamagetype spellDamagetype : spellDamagetypes) {
            spells.add(spellJDBCExecutor.getById(spellDamagetype.getSpellsSpellId()));
        }

        System.out.println("The following spells have the tag:  \n");

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
