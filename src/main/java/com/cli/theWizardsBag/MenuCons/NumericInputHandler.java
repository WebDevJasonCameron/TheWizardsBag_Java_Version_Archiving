package com.cli.theWizardsBag.MenuCons;


public class NumericInputHandler extends ValidationInputHandler {

    @Override
    protected boolean isValid(String input) {
        // Example validation logic: check if the input is a numeric value

        try {
            Integer.parseInt(input);
            System.out.println("yup here");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("nope here");
            return false;
        }
    }
}
