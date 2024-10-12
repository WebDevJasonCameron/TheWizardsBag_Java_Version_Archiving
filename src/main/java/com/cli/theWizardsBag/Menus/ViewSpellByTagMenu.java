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
    List<MenuOption> menuOptions = getMenuOptions(tags);

    // CONs
    public ViewSpellByTagMenu(String title) {
        super(title);
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<Tag> tags) {
        SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
        List<MenuOption> menuOptionsOutput = new ArrayList<>();
        for (Tag tag : tags) {
            menuOptionsOutput.add(new MenuOption(tag.getTagName(), () -> {spellTagJDBCExecutor.getAllByTagId(tag.getTagId());
            }));
        }

        return menuOptionsOutput;
    }


    // OVRs
    @Override
    protected void handleUserChoice(int choice) {

    }



}
