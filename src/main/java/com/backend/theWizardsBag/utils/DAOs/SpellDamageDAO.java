package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellDamage;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class SpellDamageDAO extends DataAccessObject<SpellDamage> {

    // SQLs

    // CONs
    public SpellDamageDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellDamage findById(long id) {
        return null;
    }

    @Override
    public List<SpellDamage> findAll() {
        return null;
    }

    @Override
    public SpellDamage update(SpellDamage dto) {
        return null;
    }

    @Override
    public SpellDamage create(SpellDamage dto) {
        return null;
    }

    @Override
    public void delete(long id) {
    }

    // METHs
}
