package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.DAOs.SpellDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class SpellJDBCExecutor {

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
            SpellDAO spellDAO = new SpellDAO(connection);

            List<Spell> spells =  spellDAO.findAll();

            for (Spell spell : spells) {
                System.out.println(spell.toString());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        // <!> Get by ID
        try {
            Connection connection = dcm.getConnection();
            SpellDAO spellDAO = new SpellDAO(connection);

            Spell spell =  spellDAO.findById(1);

            System.out.println(spell);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
