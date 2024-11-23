package com.cli.theWizardsBag.Menus;

import com.cli.theWizardsBag.MenuCons.Menu;

import java.util.Scanner;

public class CreateSpellMenu extends Menu {

    Scanner scanner = new Scanner(System.in);

    /*  The Plan
    Create a spell container
    Ask the user
        - Name of spell
        - Level
        - Casting time
        - Casting range
        - If there are visual components
        - If there are semantic components
        - If there are material components
        -- if so, what are they
        - What is the Spells duration
        - Is the spell a concentration spell
        - Can the spell be a ritual
        - What school of magic does it belong to
        - Is there a save roll component to the spell
        - Provide a description
        - Provide an image url?
        - Do you want to add tag
        -- What tag
        -- Again?
        - Does the spell cause any conditions?
        -- What conditions do you want to add?
        - Does the spell cause a damage type?
        -- What damage types do you want to add?





     */

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
