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
    public void delete(long id) {

    }

    // METHs


}
