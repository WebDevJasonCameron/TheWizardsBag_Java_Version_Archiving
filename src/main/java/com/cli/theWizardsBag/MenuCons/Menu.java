package com.cli.theWizardsBag.MenuCons;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected String title;
    protected List<MenuOption> options;
    protected Scanner scanner;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== " + title + " ===");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getName());
            }
            System.out.print("Please make a choice (or enter 0 to exit): ");

            int choice = getValidatedNumber();
            if (choice == 0) {
                System.out.println("Exiting " + title + ".");
                break;
            }
            handleUserChoice(choice);
        }
    }

    private int getValidatedNumber() {
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    protected abstract void handleUserChoice(int choice);
}
