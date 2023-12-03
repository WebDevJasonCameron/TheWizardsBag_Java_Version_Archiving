package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.ItemCondition;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class ItemConditionDAO extends DataAccessObject<ItemCondition> {

    // SQLs

    // CONs
    public ItemConditionDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public ItemCondition findById(long id) {
        return null;
    }

    @Override
    public List<ItemCondition> findAll() {
        return null;
    }

    @Override
    public ItemCondition update(ItemCondition dto) {
        return null;
    }

    @Override
    public ItemCondition create(ItemCondition dto) {
        return null;
    }

    @Override
    public void delete(long id) {
    }

    // METHs
}
