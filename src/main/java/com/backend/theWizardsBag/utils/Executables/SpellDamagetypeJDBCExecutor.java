package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellDamage;
import com.backend.theWizardsBag.utils.DAOs.SpellDamageDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellDamagetypeJDBCExecutor {

    public List<SpellDamage> getAll(){

        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<SpellDamage> spellDamages = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellDamageDAO spellDamageDAO = new SpellDamageDAO(connection);
            spellDamages = spellDamageDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellDamages;
    }

    public SpellDamage getById(long id) {

        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);
        SpellDamage spellDamage = new SpellDamage();

        // <!> Get by ID...
        try {
            Connection connection = dcm.getConnection();
            SpellDamageDAO spellDamageDAO = new SpellDamageDAO(connection);
            spellDamage = spellDamageDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellDamage;
    }

    public List<SpellDamage> getAllBySpellId (long spellId) {
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<SpellDamage> spellDamages = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellDamageDAO spellDamageDAO = new SpellDamageDAO(connection);
            spellDamages = spellDamageDAO.findAllBySpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellDamages;
    }

}
