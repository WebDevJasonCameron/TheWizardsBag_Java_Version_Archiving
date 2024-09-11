package com.cli.theWizardsBag.MenuCons;


public class MainMenu extends Menu {

    // CONs
    public MainMenu() {
        super("Main Menu");
        addOption(new MenuOption("Add Item", this::addItem));
        addOption(new MenuOption("Edit Item", this::editItem));
        addOption(new MenuOption("View Item", this::viewItem));
        addOption(new MenuOption("Remove Item", this::removeItem));
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

    // METHs
    private void addItem() {
        System.out.println("Adding an item...");
        // Implementation for adding an item
    }

    private void editItem() {
        System.out.println("Editing an item...");
        // Implementation for editing an item, such as...
        // EditItem editItemMenu = new EditItemMenu();
        // editItemMenu.display();
    }

    private void viewItem() {
        System.out.println("Viewing an item...");
        // Implementation for viewing an item
    }

    private void removeItem() {
        System.out.println("Removing an item...");
        // Implementation for removing an item
    }
}
