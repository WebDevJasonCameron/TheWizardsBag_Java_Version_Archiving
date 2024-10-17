package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.RpgClass;
import com.backend.theWizardsBag.utils.DAOs.RpgClassDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RpgClassJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);


    // MTHs
    public RpgClass create(String className, String classSubclassName, String classDescription){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            RpgClass rpgClass = new RpgClass();

            rpgClass.setClassName(className);
            rpgClass.setClassSubclassName(classSubclassName);
            rpgClass.setClassDescription(classDescription);
            return classDAO.create(rpgClass);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public RpgClass getById(long id){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            return classDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<RpgClass> getAll (){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            return classDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<RpgClass> getAllByName (String className){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            return classDAO.findAllByName(className);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public RpgClass getByNameAndSub (String className, String classSubclassName){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            return classDAO.findByNameAndSub(className, classSubclassName);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public RpgClass update(RpgClass classNewData){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);

            RpgClass rpgClass = classDAO.findById(classNewData.getClassId());

            rpgClass.setClassName(classNewData.getClassName());
            rpgClass.setClassSubclassName(classNewData.getClassSubclassName());
            rpgClass.setClassDescription(classNewData.getClassDescription());
            rpgClass = classDAO.update(rpgClass);

            return rpgClass;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            RpgClass classBeingDeleted = classDAO.findById(id);
            classDAO.delete(id);
            System.out.println("Deleted: " + classBeingDeleted.getClassName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // SPELL
    public List<RpgClass> getAllBySpell (long spellId){
        try (Connection connection = dcm.getConnection();){
            RpgClassDAO classDAO = new RpgClassDAO(connection);
            return classDAO.findAllBySpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
