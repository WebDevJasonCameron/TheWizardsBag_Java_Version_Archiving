package com.backend.theWizardsBag.utils.Executors;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.DAOs.SpellDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpellJDBCExecutor_test {

    public static void main(String[] args) {

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();

        // METHs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

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
    }

}
