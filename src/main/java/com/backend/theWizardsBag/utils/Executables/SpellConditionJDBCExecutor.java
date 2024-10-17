package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellClass;
import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.utils.DAOs.SpellClassDAO;
import com.backend.theWizardsBag.utils.DAOs.SpellConditionDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpellConditionJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public SpellCondition create(long spellsSpellId, long conditionsConditionId){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            SpellCondition spellCondition = new SpellCondition();

            spellCondition.setSpellConditionId(spellsSpellId);
            spellCondition.setConditionsConditionId(conditionsConditionId);
            return spellConditionDAO.create(spellCondition);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellCondition getById(long id){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            return spellConditionDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellCondition> getAll(){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            return spellConditionDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellCondition> getAllBySpellId(long spellId){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            return spellConditionDAO.findAllBySpellId(spellId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellCondition> getAllByConditionId(long conditionId){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            return spellConditionDAO.findAllByConditionId(conditionId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellCondition update(SpellCondition spellConditionNewData){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);

            SpellCondition spellCondition = spellConditionDAO.findById(spellConditionNewData.getSpellConditionId());

            spellCondition.setSpellConditionId(spellConditionNewData.getSpellConditionId());
            spellCondition.setSpellsSpellId(spellConditionNewData.getSpellsSpellId());
            spellCondition.setConditionsConditionId(spellConditionNewData.getConditionsConditionId());

            return spellConditionDAO.update(spellCondition);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);
            SpellCondition spellCondition = spellConditionDAO.findById(id);
            System.out.println("Deleted spell_condition with " + spellCondition.getSpellConditionId() + " id");
            spellConditionDAO.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // MTHs & SPELL
    public SpellCondition getBySpellAndConditionIds(long spellId, long conditionId){
        try (Connection connection = dcm.getConnection();){
            SpellConditionDAO spellConditionDAO = new SpellConditionDAO(connection);

            return spellConditionDAO.findBySpellAndConditionIds(spellId, conditionId);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
