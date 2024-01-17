package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellDamage;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<SpellDamage> spellDamages = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM damagetypes");) {
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                SpellDamage spellDamage = new SpellDamage();

                spellDamage.setDamageID(rs.getLong("damagetype_id"));
                spellDamage.setDamageName(rs.getString("damage"));

                spellDamages.add(spellDamage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellDamages;
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
