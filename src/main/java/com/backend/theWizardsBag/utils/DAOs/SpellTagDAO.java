package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellAccessible;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class SpellTagDAO extends DataAccessObject<SpellTag> {

    // ATTs


    // CONs
    public SpellTagDAO(Connection connection) {
        super(connection);
    }

    // GETs & SETs

    // OVRs
    @Override
    public SpellTag findById(long id) {
        return null;
    }

    @Override
    public List<SpellTag> findAll() {
        return null;
    }

    @Override
    public SpellTag update(SpellTag dto) {
        return null;
    }

    @Override
    public SpellTag create(SpellTag dto) {
        return null;
    }

    @Override
    public void delete(long id) {
    }


    // METHs
    public List<SpellAccessible> findAllWithSpellId(long id) { return null; }

}
