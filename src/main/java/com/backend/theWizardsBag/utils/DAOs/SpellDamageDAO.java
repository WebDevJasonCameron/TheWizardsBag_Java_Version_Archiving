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
    private final static String GET_BY_ID = "SELECT * FROM damagetypes WHERE damagetype_id=?";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT  " +
                                        " s.*, " +
                                        " d.* " +
                                    "FROM spells s " +
                                        " JOIN spell_damagetypes sd ON s.spell_id = sd.spells_spell_id " +
                                        " JOIN damagetypes d ON d.damagetype_id = sd.damagetypes_damagetype_id " +
                                    "WHERE  " +
                                        " s.spell_id = ?";

    // CONs
    public SpellDamageDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellDamage findById(long id) {
        SpellDamage spellDamage = new SpellDamage();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellDamage.setDamageID(rs.getLong("damagetype_id"));
                spellDamage.setDamageName(rs.getString("damage"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spellDamage;
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
    public List<SpellDamage> findAllBySpellId (long spellId) {
        List<SpellDamage> spellDamages = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);){
            statement.setLong(1, spellId);

            ResultSet rs = statement.executeQuery();
            long damagetypeId = 0;

            while (rs.next()) {
                long currentDamagetypeId = rs.getLong("damagetype_id");

                if (damagetypeId != currentDamagetypeId) {
                    SpellDamage spellDamage = new SpellDamage();

                    spellDamage.setDamageID(rs.getLong("damagetype_id"));
                    spellDamage.setDamageName(rs.getString("damage"));

                    spellDamages.add(spellDamage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spellDamages;
    }
}
