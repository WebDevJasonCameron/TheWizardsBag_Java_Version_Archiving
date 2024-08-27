# Notes from AI

## 2024 08 27 | Menus in OOP
ME:
>Good morning.  I am working on a Java programming project.  I am in the phase of creating the CLI interactions.  I am curious how I should handle menus at this phase since I am trying to keep things as object oriented.  I know I will need multiple menus and submenus based on the choices the user provides.  Is there a way I can set up menu classes that can be modified based on the type of menu I want to later create as an object?  Each object can then provides the functionality of the different use-cases I would assume the user would need as if we were building a function oriented program.

>Here is an example of what I can assume the program will need the user to choose:

>User determines if they want to add, edit, view, or remove an item from a db.  This would be the main menu.  However, the user would then need to choose what they want to add as a sub menu.  Or they would need to choose how to find the item they want to edit (name, attribute, or something else) which would then be its own sub menu.  Even after that, the user will then need to pull information from the db and then edit it within yet another sub menu.

>Can you help me determine if these menus can be set up as reusable with java classes, or do I need to make a new class for each one of these menus?

GPT:
>Good morning! It sounds like you're looking to create a flexible and reusable menu system for your Java CLI application using object-oriented principles. This is definitely possible, and you can design your menu classes in a way that makes them highly reusable and easy to modify. Here's an approach you can take:

### 1. **Abstract Base Class for Menus**

>Start with an abstract base class called `Menu`. This class will define the common properties and methods that all menus will share.

```java
public abstract class Menu {
    protected String title;
    protected List<MenuOption> options;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }

    public abstract void display();
    public abstract void handleUserChoice(int choice);
}
```

### 2. **MenuOption Class**

>Create a `MenuOption` class that represents each option in the menu. This class can encapsulate the option's name and the action that should be taken when the option is selected.

```java
public class MenuOption {
    private String name;
    private Runnable action;

    public MenuOption(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        action.run();
    }
}
```

### 3. **Concrete Menu Classes**

>Extend the `Menu` class to create concrete classes for different types of menus. Each subclass can override the `display` and `handleUserChoice` methods to provide specific functionality.

```java
public class MainMenu extends Menu {
    public MainMenu() {
        super("Main Menu");
        addOption(new MenuOption("Add Item", () -> {
            // logic for adding item
        }));
        addOption(new MenuOption("Edit Item", () -> {
            // logic for editing item
        }));
        addOption(new MenuOption("View Item", () -> {
            // logic for viewing item
        }));
        addOption(new MenuOption("Remove Item", () -> {
            // logic for removing item
        }));
    }

    @Override
    public void display() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getName());
        }
    }

    @Override
    public void handleUserChoice(int choice) {
        if (choice > 0 && choice <= options.size()) {
            options.get(choice - 1).execute();
        } else {
            System.out.println("Invalid choice, please try again.");
        }
    }
}
```

### 4. **Submenu Handling**

>For submenus, you can create additional menu classes that extend `Menu` and use them as options within other menus. For example, an `EditItemMenu` could be a submenu that is invoked when the "Edit Item" option is selected in the main menu.

```java
public class EditItemMenu extends Menu {
    public EditItemMenu() {
        super("Edit Item Menu");
        addOption(new MenuOption("Edit by Name", () -> {
            // logic for editing by name
        }));
        addOption(new MenuOption("Edit by Attribute", () -> {
            // logic for editing by attribute
        }));
        // Additional options
    }

    @Override
    public void display() {
        // Display logic
    }

    @Override
    public void handleUserChoice(int choice) {
        // Handle logic
    }
}
```

### 5. **Putting It All Together**

You can instantiate these menu objects in your main application logic and chain them as needed:

```java
public class MenuApplication {
    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        // Display main menu and handle choices
        mainMenu.display();
        // Logic to get user input and pass it to handleUserChoice
    }
}
```

### Key Points

>- **Reusability**: By using an abstract base class (`Menu`), you ensure that all menus share a common structure and can be easily extended or modified.
>- **Separation of Concerns**: Each menu handles its own display and user input, keeping the logic clean and manageable.
> **Extensibility**: You can easily add new menu types or modify existing ones without changing the core application logic.

>This design allows you to keep your CLI interactions organized and maintainable, adhering to object-oriented principles. Let me know if you need further clarification or if there's anything else you'd like to add!