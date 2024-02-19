package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellClass;
import com.backend.theWizardsBag.utils.DAOs.SpellClassDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpellClassJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public SpellClass create(Long spellsSpellId, Long classesClassId){
        try {
            Connection connection= this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            SpellClass spellClass = new SpellClass();

            spellClass.setSpellClassId(spellsSpellId);
            spellClass.setClassesClassId(classesClassId);
            return spellClassDAO.create(spellClass);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellClass getById(Long id){
        try {
            Connection connection = this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            return spellClassDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellClass> getAll(){
        try{
            Connection connection = this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            return spellClassDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }





}
