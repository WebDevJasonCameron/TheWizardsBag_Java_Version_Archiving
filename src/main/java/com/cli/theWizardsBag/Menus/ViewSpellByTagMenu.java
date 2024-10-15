package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.SpellTag;
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
        System.out.println("The following spells have that tag:  \n");

        // get all spell ids with that tag id
        // print out all the spell names with that tag id
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
