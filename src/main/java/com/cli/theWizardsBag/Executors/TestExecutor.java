package com.cli.theWizardsBag.Executors;

import com.cli.theWizardsBag.Menus.TestMenu;

public class TestExecutor {
    public static void main(String[] args) {

        TestMenu testMenu = new TestMenu();
        testMenu.firstMenu("Welcome.  Would you like to search for a spell?  (y or n)");

    }
}
