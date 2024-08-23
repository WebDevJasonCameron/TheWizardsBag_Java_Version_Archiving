package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;

import java.util.Scanner;

public class TestMenu {

    // ATTs
    Scanner scanner = new Scanner(System.in);
    public String response;

    // MENUs
    public void firstMenu(){
        System.out.println("Welcome.  Would you like to search for a spell?  (y or n)");
        String choiceResponse = this.scanner.nextLine();

        if(choiceResponse.toLowerCase().equals("y")){
            System.out.println("Please enter the spell you would like to search: ");
            String spellNameResponse = this.scanner.nextLine();

            SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();
            Spell spell = spellJDBCExecutor.getBySpellName(spellNameResponse);

            System.out.println(spell);

        } else if(choiceResponse.toLowerCase().equals("n")){
            System.out.println("Thank you for using the Wizards Bag!");
        } else {
            System.out.println("Sorry, that is not a valid response.");
        }

    }




}
