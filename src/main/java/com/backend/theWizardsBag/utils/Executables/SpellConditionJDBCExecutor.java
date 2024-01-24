package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.utils.DAOs.SpellConditionDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellConditionJDBCExecutor {

    public static List<SpellCondition> getAll() {
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<SpellCondition> spellConditions = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            spellConditions = spellConditionDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spellConditions;
    }

    public static SpellCondition getById(long id) {
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        SpellCondition spellCondition = new SpellCondition();

        try {
            Connection connection = dcm.getConnection();
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            spellCondition = spellConditionDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellCondition;

    }

    public static List<SpellCondition> getAllBySpellId(long spellId) {
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<SpellCondition> spellConditions = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);

            spellConditions = spellConditionDAO.findAllBySpellId(spellId);

            for (SpellCondition spellCondition : spellConditions) {
                System.out.println(spellCondition);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spellConditions;
    }
}
