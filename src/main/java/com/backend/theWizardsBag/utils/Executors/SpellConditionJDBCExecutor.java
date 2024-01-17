package com.backend.theWizardsBag.utils.Executors;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.utils.DAOs.SpellConditionDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpellConditionJDBCExecutor {

    // <!> <R> We are using main function to test... this will need to change to a proper function
    public static void main(String[] args) {

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();

        // METHs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        // <!> Get All...
        /*
        try {
            Connection connection = dcm.getConnection();
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);

            List<SpellCondition> spellConditions = spellConditionDAO.findAll();

            for (SpellCondition spellCondition : spellConditions){
                System.out.println(spellCondition);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        // <!> Get by ID
        try {
            Connection connection = dcm.getConnection();
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);

            SpellCondition spellCondition = spellConditionDAO.findById(1);
            System.out.println(spellCondition);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
