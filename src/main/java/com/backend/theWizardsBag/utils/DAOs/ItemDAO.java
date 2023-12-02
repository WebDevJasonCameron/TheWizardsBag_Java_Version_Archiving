package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Item;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class ItemDAO extends DataAccessObject<Item> {

    // VARs

    // CONs
    public ItemDAO(Connection connection) {
        super(connection);
    }

    // GETs & SETs

    // OVRs
    @Override
    public Item findById(long id) {
        return null;
    }
    @Override
    public List<Item> findAll() {
        return null;
    }
    @Override
    public Item update(Item dto) {
        return null;
    }
    @Override
    public Item create(Item dto) {
        return null;
    }
    @Override
    public void delete(long id) {
    }

    // METHs
}
