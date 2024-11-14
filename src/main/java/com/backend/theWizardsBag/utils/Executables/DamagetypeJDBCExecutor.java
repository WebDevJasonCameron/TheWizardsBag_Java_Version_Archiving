package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Damagetype;
import com.backend.theWizardsBag.utils.DAOs.DamagetypeDAO;
import com.backend.theWizardsBag.utils.DAOs.TagDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DamagetypeJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public Damagetype create(String damagetypeName){
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            Damagetype damagetype = new Damagetype();

            damagetype.setDamagetypeName(damagetypeName);
            return damagetypeDAO.create(damagetype);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Damagetype getById(long id){
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            return damagetypeDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Damagetype> getAll (){
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            return damagetypeDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Damagetype getByName (String damagetypeName){
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            return damagetypeDAO.findByName(damagetypeName);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Damagetype update(Damagetype damagetypeNewData) {
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);

            Damagetype damagetype = damagetypeDAO.findById(damagetypeNewData.getDamagetypeId());

            damagetype.setDamagetypeName(damagetypeNewData.getDamagetypeName());
            damagetype = damagetypeDAO.update(damagetype);

            return damagetype;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            Damagetype damagetypeBeingDeleted = damagetypeDAO.findById(id);
            damagetypeDAO.delete(id);
            System.out.println("Deleted: " + damagetypeBeingDeleted.getDamagetypeName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // MTHs & SPELL
    public List<Damagetype> getAllBySpell (long spellId){
        try (Connection connection = dcm.getConnection();){
            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            return damagetypeDAO.findAllBySpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Damagetype> getAllByDamagetypeName (String damagetypeName){
        try (Connection connection = dcm.getConnection();){

            DamagetypeDAO damagetypeDAO = new DamagetypeDAO(connection);
            return damagetypeDAO.findAllByDamagetypeName(damagetypeName);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
