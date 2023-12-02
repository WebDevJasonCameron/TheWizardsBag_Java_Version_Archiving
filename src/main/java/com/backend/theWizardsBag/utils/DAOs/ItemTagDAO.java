package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.ItemTag;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class ItemTagDAO extends DataAccessObject<ItemTag> {

    // ATTs

    // CONs
    public ItemTagDAO(Connection connection) {
        super(connection);
    }

    // GETs & SETs

    // OVRs
    @Override
    public ItemTag findById(long id) {
        return null;
    }
    @Override
    public List<ItemTag> findAll() {
        return null;
    }
    @Override
    public ItemTag update(ItemTag dto) {
        return null;
    }
    @Override
    public ItemTag create(ItemTag dto) {
        return null;
    }
    @Override
    public void delete(long id) {
    }

    // METHs
}
