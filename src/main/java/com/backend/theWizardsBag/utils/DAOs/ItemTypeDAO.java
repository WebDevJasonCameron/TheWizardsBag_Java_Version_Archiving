package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.ItemType;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class ItemTypeDAO extends DataAccessObject<ItemType> {

    // SQLs

    // CONs
    public ItemTypeDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public ItemType findById(long id) {
        return null;
    }

    @Override
    public List<ItemType> findAll() {
        return null;
    }

    @Override
    public ItemType update(ItemType dto) {
        return null;
    }

    @Override
    public ItemType create(ItemType dto) {
        return null;
    }

    @Override
    public void delete(long id) {
    }

    // METHs
}
