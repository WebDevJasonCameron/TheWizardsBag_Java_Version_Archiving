package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellDamagetype;
import com.backend.theWizardsBag.utils.DAOs.SpellDamagetypeDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class SpellDamagetypeJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public SpellDamagetype create(long spellsSpellId, long damagetypesDamagetypeId){
        try {
            Connection connection= this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);
            SpellDamagetype spellDamagetype = new SpellDamagetype();

            spellDamagetype.setSpellDamagetypeId(spellsSpellId);
            spellDamagetype.setDamagetypesDamagetypeId(damagetypesDamagetypeId);
            return spellDamagetypeDAO.create(spellDamagetype);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellDamagetype getById(long id){
        try {
            Connection connection = this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);
            return spellDamagetypeDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellDamagetype> getAll(){
        try{
            Connection connection = this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);
            return spellDamagetypeDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellDamagetype> getAllBySpellId(long spellId){
        try {
            Connection connection = this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);
            return spellDamagetypeDAO.findAllBySpellId(spellId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellDamagetype> getAllByDamagetypeId(long damagetypeId){
        try {
            Connection connection = this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);
            return spellDamagetypeDAO.findAllBySpellId(damagetypeId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellDamagetype update(SpellDamagetype spellDamagetypeNewData){
        try {
            Connection connection = this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);

            SpellDamagetype spellDamagetype = spellDamagetypeDAO.findById(spellDamagetypeNewData.getSpellDamagetypeId());

            spellDamagetype.setSpellDamagetypeId(spellDamagetypeNewData.getSpellDamagetypeId());
            spellDamagetype.setSpellsSpellId(spellDamagetypeNewData.getSpellsSpellId());
            spellDamagetype.setDamagetypesDamagetypeId(spellDamagetypeNewData.getDamagetypesDamagetypeId());

            return spellDamagetypeDAO.update(spellDamagetype);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        try {
            Connection connection = this.dcm.getConnection();
            SpellDamagetypeDAO spellDamagetypeDAO = new SpellDamagetypeDAO(connection);
            SpellDamagetype spellDamagetype = spellDamagetypeDAO.findById(id);
            System.out.println("Deleted spell_damagetype with " + spellDamagetype.getSpellDamagetypeId() + " id");
            spellDamagetypeDAO.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
