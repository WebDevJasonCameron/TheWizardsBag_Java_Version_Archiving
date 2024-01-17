package com.backend.theWizardsBag.utils.Executors;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellClass;
import com.backend.theWizardsBag.utils.DAOs.SpellClassDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellClassJDBCExecutor {

    // <!> <R> We are using main function to test... this will need to change to a proper function
    public static void main(String[] args) {

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();

        // METHs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        // <!> Get All...
        /*
        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            List<SpellClass> spellClasses = spellClassDAO.findAll();

            for (SpellClass spellClass : spellClasses) {
                System.out.println(spellClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
         */

        // <!> Get by ID...
        /*
        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            SpellClass spellClass = spellClassDAO.findById(2);
            System.out.println(spellClass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        // <!> Get by Spell ID...
        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            List<SpellClass> spellClasses = spellClassDAO.findAllBySpellId(26);

            for (SpellClass spellClass : spellClasses) {
                System.out.println(spellClass.getClassName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
