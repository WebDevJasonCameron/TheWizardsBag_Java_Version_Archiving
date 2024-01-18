package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.DAOs.SpellTagDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellTagJDBCExecutor {

    // <!> <R> We are using main function to test... this will need to change to a proper function
    public static void main(String[] args) {

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();

        // OBJs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        // <!> Get All...
        /*
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
         */

        // <!> Get by ID...
        /*
        try {
            Connection connection = dcm.getConnection();
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);

            SpellTag spellTag = spellTagDAO.findById(1);
            System.out.println(spellTag);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        // <!> Get All by Spell ID...
        try {
            Connection connection = dcm.getConnection();
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);

            List<SpellTag> spellTags = spellTagDAO.findAllWithSpellId(50);

            for(SpellTag spellTag : spellTags) {
                System.out.println(spellTag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SpellTag> ExecuteGetAllBySpellId(long spellId){

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        List<SpellTag> spellTags = new ArrayList<>();

        // OBJs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);

            spellTags = spellTagDAO.findAllWithSpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellTags;
    }

}
