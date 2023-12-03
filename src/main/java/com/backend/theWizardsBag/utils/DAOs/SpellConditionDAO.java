package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class SpellConditionDAO extends DataAccessObject<SpellCondition> {

    // SQLs

    // CONs
    public SpellConditionDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellCondition findById(long id) {
        return null;
    }

    @Override
    public List<SpellCondition> findAll() {
        return null;
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
