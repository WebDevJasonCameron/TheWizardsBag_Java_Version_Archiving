package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.ItemEffect;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class ItemEffectDAO extends DataAccessObject<ItemEffect> {

    // SQLs

    // CONs
    public ItemEffectDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public ItemEffect findById(long id) {
        return null;
    }
    @Override
    public List<ItemEffect> findAll() {
        return null;
    }
    @Override
    public ItemEffect update(ItemEffect dto) {
        return null;
    }
    @Override
    public ItemEffect create(ItemEffect dto) {
        return null;
    }
    @Override
    public void delete(long id) {

    }

    // METHs
}
