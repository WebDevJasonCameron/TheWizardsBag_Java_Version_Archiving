package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.ItemNote;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class ItemNoteDAO extends DataAccessObject<ItemNote> {

    // ATTs

    // CONs
    public ItemNoteDAO(Connection connection) {
        super(connection);
    }

    // GETs & SETs

    // OVRs
    @Override
    public ItemNote findById(long id) {
        return null;
    }
    @Override
    public List<ItemNote> findAll() {
        return null;
    }
    @Override
    public ItemNote update(ItemNote dto) {
        return null;
    }
    @Override
    public ItemNote create(ItemNote dto) {
        return null;
    }
    @Override
    public void delete(long id) {
    }

    // METHs

}
