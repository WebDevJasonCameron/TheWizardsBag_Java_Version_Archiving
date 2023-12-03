package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellAccessible;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class SpellAccessibleDAO extends DataAccessObject<SpellAccessible> {

    // SQLs

    // CONs
    public SpellAccessibleDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override                   //   Junction Table ID
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

    // METHs                    //   Given Spell ID, find all JOINT table data
    public List<SpellAccessible> findAllWithSpellId (long spellId) { return null;}


}
