package com.cli.theWizardsBag.MenuCons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    // ATTs
    protected String title;
    protected List<MenuOption> options;
    protected Scanner scanner;
    protected ValidationInputHandler validationInputHandler;

    // CONs
    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.validationInputHandler = new ValidationInputHandler();
    }

    // METHs
    public void addOption(MenuOption option) {
        options.add(option);
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getName());
        }
        System.out.print("Please make a choice: ");
        handleUserInput();
    }

    public void handleUserInput(){
        int choice = scanner.nextInt();
        handleUserChoice(choice);
    };

    public abstract void handleUserChoice(int choice);

}
