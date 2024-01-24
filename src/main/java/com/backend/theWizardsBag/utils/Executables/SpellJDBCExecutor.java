package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.DAOs.SpellDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellJDBCExecutor {

    public static List<Spell> getAll(){
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<Spell> spells = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellDAO spellDAO = new SpellDAO(connection);
            spells =  spellDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spells;
    }

    public static Spell getById (long id){
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        Spell spell = new Spell();

        try {
            Connection connection = dcm.getConnection();
            SpellDAO spellDAO = new SpellDAO(connection);
            spell =  spellDAO.findById(id);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spell;
    }

}
