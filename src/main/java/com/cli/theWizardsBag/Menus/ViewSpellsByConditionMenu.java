package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Condition;
import com.backend.theWizardsBag.utils.Executables.ConditionJDBCExecutor;
import com.cli.theWizardsBag.MenuCons.Menu;
import com.cli.theWizardsBag.MenuCons.MenuOption;

import java.util.ArrayList;
import java.util.List;

public class ViewSpellsByConditionMenu extends Menu {

    ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
    List<Condition> conditions = conditionJDBCExecutor.getAllByConditionNames();
    List<MenuOption> menuOptions = getMenuOptions(conditions);

    // CONs
    public ViewSpellsByConditionMenu(String title) {
        super(title);
        this.options = menuOptions;
    }

    // METHs
    private List<MenuOption> getMenuOptions(List<Condition> conditions) {
        List<MenuOption> menuOptionsOutput = new ArrayList<>();
        for(Condition condition : conditions) {
            menuOptionsOutput.add(new MenuOption(condition.getConditionName(), () -> {
                System.out.println("You chose " + condition.getConditionName());
                // (!) viewByConditionId(condition.getConditionId());
            }));
        }
        return menuOptionsOutput;
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
}
