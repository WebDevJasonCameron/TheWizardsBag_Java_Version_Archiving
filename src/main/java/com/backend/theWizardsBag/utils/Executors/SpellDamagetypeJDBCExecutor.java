package com.backend.theWizardsBag.utils.Executors;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellDamage;
import com.backend.theWizardsBag.utils.DAOs.SpellDamageDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpellDamagetypeJDBCExecutor {

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
            SpellDamageDAO spellDamageDAO = new SpellDamageDAO(connection);

            List<SpellDamage> spellDamages = spellDamageDAO.findAll();

            for (SpellDamage spellDamage : spellDamages) {
                System.out.println(spellDamage);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
         */

        // <!> Get by ID...
        /*
        try {
            Connection connection = dcm.getConnection();
            SpellDamageDAO spellDamageDAO = new SpellDamageDAO(connection);

            SpellDamage spellDamage = spellDamageDAO.findById(1);
            System.out.println(spellDamage);

        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

        // <!> Get All by Spell ID...
        try {
            Connection connection = dcm.getConnection();
            SpellDamageDAO spellDamageDAO = new SpellDamageDAO(connection);

            List<SpellDamage> spellDamages = spellDamageDAO.findAllBySpellId(22);

            for (SpellDamage spellDamage : spellDamages) {
                System.out.println(spellDamage);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
