package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;

import java.util.Scanner;

public class ViewSpellByTagMenu extends Menu {

    Scanner scanner = new Scanner(System.in);

    // CONs
    public ViewSpellByTagMenu(String title) {
        super(title);
    }

    // OVRs
    @Override
    protected void handleUserChoice(int choice) {

    }
}
