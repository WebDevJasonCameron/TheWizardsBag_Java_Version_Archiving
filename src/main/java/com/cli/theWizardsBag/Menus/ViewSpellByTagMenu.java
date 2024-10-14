package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.Executables.SpellTagJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.TagJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;
import com.cli.theWizardsBag.MenuCons.TextValidationStrategy;
import com.cli.theWizardsBag.MenuCons.ValidationInputHandler;

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
                viewByTagId(tag.getId());
            }));
        }
        return menuOptionsOutput;
    }

    private void viewByTagId(Long tagId){
        SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
        System.out.println("Enter the tag number you want to view spells: ");
        // input handler

        // Implementation for viewing by name
        List<SpellTag> spellTags = spellTagJDBCExecutor.getAllByTagId(tagId);
        for (SpellTag spellTag : spellTags) {
            System.out.println(spellTag.getSpellsSpellId());
        }
    }



    // OVRs
    @Override
    protected void handleUserChoice(int choice) {

    }



}
