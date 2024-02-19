package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Spell;
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
    public SpellClass create(long spellsSpellId, long classesClassId){
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

    public SpellClass getById(long id){
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

    public List<SpellClass> getAllBySpellId(long spellId){
        try {
            Connection connection = this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            return spellClassDAO.findAllBySpellId(spellId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellClass> getAllByClassId(long classId){
        try {
            Connection connection = this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            return spellClassDAO.findAllBySpellId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellClass update(SpellClass spellClassNewData){
        try {
            Connection connection = this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            SpellClass spellClass = spellClassDAO.findById(spellClassNewData.getSpellClassId());

            spellClass.setSpellClassId(spellClassNewData.getSpellClassId());
            spellClass.setSpellsSpellId(spellClassNewData.getSpellsSpellId());
            spellClass.setClassesClassId(spellClassNewData.getClassesClassId());

            return spellClassDAO.update(spellClass);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        try {
            Connection connection = this.dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            SpellClass spellClass = spellClassDAO.findById(id);
            System.out.println("Deleted spell_class with " + spellClass.getSpellClassId() + " id");
            spellClassDAO.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
