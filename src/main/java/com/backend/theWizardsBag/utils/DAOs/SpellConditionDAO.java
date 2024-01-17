package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellConditionDAO extends DataAccessObject<SpellCondition> {

    // SQLs
    private final static String GET_BY_ID = "SELECT * FROM conditions WHERE condition_id=?";

    private final static String GET_ALL_BY_SPELL_ID =   "SELECT  " +
                                                            "sc.spell_condition_id, " +
                                                            "c.condition_id," +
                                                            "c.condition," +
                                                            "c.description " +
                                                        "FROM spells s " +
                                                            " JOIN spell_conditions sc ON s.spell_id = sc.spells_spell_id " +
                                                            " JOIN conditions c ON c.condition_id = sc.conditions_condition_id " +
                                                        "WHERE  " +
                                                            " sc.spells_spell_id = ?";

    // CONs
    public SpellConditionDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellCondition findById(long id) {
        SpellCondition spellCondition = new SpellCondition();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                spellCondition.setConditionID(rs.getLong("condition_id"));
                spellCondition.setConditionName(rs.getString("condition"));
                spellCondition.setConditionDescription(rs.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return spellCondition;
    }

    @Override
    public List<SpellCondition> findAll() {
        List<SpellCondition> spellConditions = new ArrayList<>();

        try(PreparedStatement statement = this .connection.prepareStatement("SELECT * FROM conditions");){

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellCondition spellCondition = new SpellCondition();

                spellCondition.setConditionID(rs.getInt("condition_id"));
                spellCondition.setConditionName(rs.getString("condition"));
                spellCondition.setConditionDescription(rs.getString("description"));

                spellConditions.add(spellCondition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return spellConditions;
    }

    @Override
    public SpellCondition update(SpellCondition dto) {
        return null;
    }

    @Override
    public SpellCondition create(SpellCondition dto) {
        return null;
    }

    @Override
    public void delete(long id) {}

    // METHs
    public List<SpellCondition> findAllBySpellId(long spellId) {
        List<SpellCondition> spellConditions = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);
            SpellCondition spellCondition = new SpellCondition();

            ResultSet rs = statement.executeQuery();
            long conditionId = 0;
            SpellCondition condition = null;

            while (rs.next()) {
                long currentConditionId = rs.getLong("condition_id");

                if(conditionId != currentConditionId){
                    spellCondition = new SpellCondition();

                    spellCondition.setSpellConditionID(rs.getLong("spell_condition_id"));
                    spellCondition.setConditionID(rs.getLong("condition_id"));
                    spellCondition.setConditionName(rs.getString("condition"));
                    spellCondition.setConditionDescription(rs.getString("description"));

                    spellConditions.add(spellCondition);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spellConditions;
    }

}
