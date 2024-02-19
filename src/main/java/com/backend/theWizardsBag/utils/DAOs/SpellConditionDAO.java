package com.backend.theWizardsBag.utils.DAOs;

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
    private final static String INSERT = "INSERT INTO spell_conditions " +
                                            "(spells_spell_id, conditions_condition_id) " +
                                         "VALUES " +
                                            "(?, ?) ";

    private final static String GET_BY_ID = "SELECT * FROM spell_conditions " +
                                            "WHERE spell_condition_id = ? ";

    private final static String GET_ALL = "SELECT * FROM spell_conditions ";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT * FROM spell_conditions " +
                                                      "WHERE spells_spell_id = ?";


    private final static String GET_ALL_BY_CONDITION_ID = "SELECT * FROM spell_conditions " +
                                                      "WHERE conditions_condition_id = ?";

    private final static String UPDATE =    "UPDATE spell_conditions " +
                                            "SET " +
                                                "spell_condition_id, " +
                                                "spells_spell_id, " +
                                                "conditions_condition_id " +
                                            "WHERE " +
                                                "spell_condition_id = ? ";

    private final static String DELETE = "DELETE FROM spell_conditions " +
                                         "WHERE spell_condition_id = ? ";

    // CONs
    public SpellConditionDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellCondition create(SpellCondition dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getConditionsConditionId());
            statement.execute();

            long id = this.getLastVal(SPELL_CONDITION_SEQUENCE);
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public SpellCondition findById(long id) {
        SpellCondition spellCondition = new SpellCondition();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellCondition.setSpellConditionId(rs.getLong("spell_condition_id"));
                spellCondition.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellCondition.setConditionsConditionId(rs.getLong("conditions_condition_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellCondition;
    }

    @Override
    public List<SpellCondition> findAll() {
        List<SpellCondition> spellConditions = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                SpellCondition spellCondition = new SpellCondition();

                spellCondition.setSpellConditionId(rs.getLong("spell_condition_id"));
                spellCondition.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellCondition.setConditionsConditionId(rs.getLong("conditions_condition_id"));

                spellConditions.add(spellCondition);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellConditions;    }

    @Override
    public SpellCondition update(SpellCondition dto) {
        SpellCondition spellCondition = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE); ) {
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getConditionsConditionId());
            statement.setLong(3, dto.getSpellConditionId());
            statement.execute();

            spellCondition = this.findById(dto.getSpellConditionId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellCondition;    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // MTHs
    public List<SpellCondition> findAllBySpellId(long spellId){
        List<SpellCondition> spellConditions = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellCondition spellCondition = new SpellCondition();

                spellCondition.setSpellConditionId(rs.getLong("spell_condition_id"));
                spellCondition.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellCondition.setConditionsConditionId(rs.getLong("conditions_condition_id"));

                spellConditions.add(spellCondition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellConditions;
    }

    public List<SpellCondition> findAllByConditionId(long conditionId){
        List<SpellCondition> spellConditions = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_CONDITION_ID);) {
            statement.setLong(1, conditionId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellCondition spellCondition = new SpellCondition();

                spellCondition.setSpellConditionId(rs.getLong("spell_condition_id"));
                spellCondition.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellCondition.setConditionsConditionId(rs.getLong("conditions_condition_id"));

                spellConditions.add(spellCondition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellConditions;
    }
}
