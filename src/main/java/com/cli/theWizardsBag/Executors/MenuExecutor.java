package com.cli.theWizardsBag.Executors;

import com.cli.theWizardsBag.Menus.MainMenu;

public class MenuExecutor {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.display();
        System.out.println("Than you for using the application!");
    }
}
