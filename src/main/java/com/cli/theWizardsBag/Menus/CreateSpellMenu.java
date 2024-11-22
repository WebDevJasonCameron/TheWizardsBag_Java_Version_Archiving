package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;

import java.util.Scanner;

public class CreateSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);


    // CONs
    public CreateSpellMenu(String title) {
        super(title);
    }

    // OVR
    @Override
    protected void handleUserChoice(int choice) {
        if (choice > 0 && choice <= options.size()) {
            options.get(choice - 1).execute();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }
}
