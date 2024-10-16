package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellTagJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.TagJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewSpellByTagMenu extends Menu {

    Scanner scanner = new Scanner(System.in);
    TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
    List<Tag> tags = tagJDBCExecutor.getAllByTagTypes("spell", "both");
    List<MenuOption> menuOptions = getMenuOptions(tags);

    // CONs
    public ViewSpellByTagMenu(String title) {
        super(title);
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<Tag> tags) {
        List<MenuOption> menuOptionsOutput = new ArrayList<>();
        for (Tag tag : tags) {
            menuOptionsOutput.add(new MenuOption(tag.getTagName(), () -> {
                System.out.println("You chose " + tag.getTagName());
                viewByTagId(tag.getTagId());
            }));
        }
        return menuOptionsOutput;
    }

    private void viewByTagId(Long tagId){
        SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();

        List<SpellTag> spellTags = spellTagJDBCExecutor.getAllByTagId(tagId);
        List<Spell> spells = new ArrayList<>();

        for (SpellTag spellTag : spellTags) {
            spells.add(spellJDBCExecutor.getById(spellTag.getSpellsSpellId()));
        }

        System.out.println("The following spells have that tag:  \n");

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
