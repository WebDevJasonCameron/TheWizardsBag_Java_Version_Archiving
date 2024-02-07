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



    public List<SpellTag> getAll(){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<SpellTag> spellTags = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            spellTags =  spellTagDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellTags;
    }

    public SpellTag getById(long id) {
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        SpellTag spellTag = new SpellTag();

        try {
            Connection connection = dcm.getConnection();
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            spellTag = spellTagDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<SpellTag> getAllBySpellId(long spellId){

        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<SpellTag> spellTags = new ArrayList<>();

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
