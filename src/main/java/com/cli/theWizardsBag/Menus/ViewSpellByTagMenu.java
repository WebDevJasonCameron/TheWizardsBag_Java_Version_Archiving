package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Tag;
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

    // CONs
    public ViewSpellByTagMenu(String title) {
        super("View Spell by Its Tag Menu");

    }


    // METHs
    private List<MenuOption> viewByTag() {
        SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
        List<MenuOption> options = new ArrayList<>();
        for (Tag tag : tags) {
            options.add(new MenuOption(tag.getTagName(), spellTagJDBCExecutor.getAllByTagId(tag.getTagId()));
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
