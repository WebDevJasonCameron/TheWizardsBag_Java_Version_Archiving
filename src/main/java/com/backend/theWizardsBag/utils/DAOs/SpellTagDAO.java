package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellAccessible;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class SpellTagDAO extends DataAccessObject<SpellAccessible> {

    // ATTs


    // CONs
    public SpellTagDAO(Connection connection) {
        super(connection);
    }

    // GETs & SETs

    // OVRs
    @Override
    public SpellAccessible findById(long id) {
        return null;
    }
    @Override
    public List<SpellAccessible> findAll() {
        return null;
    }
    @Override
    public SpellAccessible update(SpellAccessible dto) {
        return null;
    }
    @Override
    public SpellAccessible create(SpellAccessible dto) {
        return null;
    }
    @Override
    public void delete(long id) {
    }

    // METHs

}
