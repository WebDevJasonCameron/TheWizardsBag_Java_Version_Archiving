package com.backend.theWizardsBag.utils.Executors;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellTag;
 import com.backend.theWizardsBag.utils.DAOs.SpellTagDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpellTagJDBCExecutor {

    // <!> <R> We are using main function to test... this will need to change to a proper function
    public static void main(String[] args) {

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();

        // METHs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);

            List<SpellTag> spellTags =  spellTagDAO.findAll();

            for (SpellTag spellTag : spellTags) {
                System.out.println(spellTag.toString());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
