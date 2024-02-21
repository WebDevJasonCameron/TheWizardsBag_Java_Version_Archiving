package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Condition;
import com.backend.theWizardsBag.models.RpgClass;
import com.backend.theWizardsBag.utils.DAOs.ConditionDAO;
import com.backend.theWizardsBag.utils.DAOs.RpgClassDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConditionJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public Condition create(String conditionName, String conditionDescription){
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);
            Condition condition = new Condition();

            condition.setConditionName(conditionName);
            condition.setConditionDescription(conditionDescription);

            return  conditionDAO.create(condition);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Condition getByID (long id){
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);
            return conditionDAO.findById(id);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Condition> getAll (){
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);
            return conditionDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Condition getByName (String conditionName){
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);
            return conditionDAO.findByName(conditionName);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Condition update(Condition conditionNewData) {
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);

            Condition condition = conditionDAO.findById(conditionNewData.getConditionId());
            System.out.println(condition.getConditionName() + " - " + condition.getConditionDescription());  // <R> remove after test

            condition.setConditionName(conditionNewData.getConditionName());
            condition.setConditionDescription(conditionNewData.getConditionDescription());
            condition = conditionDAO.update(condition);

            System.out.println(condition.getConditionName() + " - " + condition.getConditionDescription());  // <R> remove after test

            return condition;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);
            Condition conditionBeingDeleted = conditionDAO.findById(id);
            conditionDAO.delete(id);
            System.out.println("Deleted: " + conditionBeingDeleted.getConditionName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // SPELL
    public List<Condition> getAllBySpell (long spellId){
        try {
            Connection connection = this.dcm.getConnection();
            ConditionDAO conditionDAO = new ConditionDAO(connection);
            return conditionDAO.findAllBySpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
