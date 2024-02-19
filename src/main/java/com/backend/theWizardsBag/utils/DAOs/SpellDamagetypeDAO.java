package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.models.SpellDamagetype;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellDamagetypeDAO extends DataAccessObject<SpellDamagetype> {

    // SQLs
    private final static String INSERT = "INSERT INTO spell_damagetypes " +
                                            "(spells_spell_id, damagetypes_damagetype_id) " +
                                         "VALUES " +
                                            "(?, ?) ";

    private final static String GET_BY_ID = "SELECT * FROM spell_damagetypes " +
                                            "WHERE spell_damagetype_id = ? ";

    private final static String GET_ALL = "SELECT * FROM spell_damagetypes ";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT * FROM spell_damagetypes " +
                                                      "WHERE spells_spell_id = ?";


    private final static String GET_ALL_BY_DAMAGETYPE_ID = "SELECT * FROM spell_damagetypes " +
                                                          "WHERE damagetypes_damagetype_id = ?";

    private final static String UPDATE =    "UPDATE spell_damagetypes " +
                                            "SET " +
                                                "spell_damagetype_id, " +
                                                "spells_spell_id, " +
                                                "damagetypes_damagetype_id " +
                                            "WHERE " +
                                                "spell_damagetype_id = ? ";

    private final static String DELETE = "DELETE FROM spell_damagetypes " +
                                         "WHERE spell_damagetype_id = ? ";

    // CONs
    public SpellDamagetypeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public SpellDamagetype create(SpellDamagetype dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getDamagetypesDamagetypeId());
            statement.execute();

            long id = this.getLastVal(SPELL_CONDITION_SEQUENCE);
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }    }

    @Override
    public SpellDamagetype findById(long id) {
            SpellDamagetype spellDamagetype = new SpellDamagetype();

            try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
                statement.setLong(1, id);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    spellDamagetype.setSpellDamagetypeId(rs.getLong("spell_damagetype_id"));
                    spellDamagetype.setSpellsSpellId(rs.getLong("spells_spell_id"));
                    spellDamagetype.setDamagetypesDamagetypeId(rs.getLong("damagetypes_damagetype_id"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return spellDamagetype;
        }

    @Override
    public List<SpellDamagetype> findAll() {
        List<SpellDamagetype> spellDamagetypes = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                SpellDamagetype spellDamagetype = new SpellDamagetype();

                spellDamagetype.setSpellDamagetypeId(rs.getLong("spell_damagetype_id"));
                spellDamagetype.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellDamagetype.setDamagetypesDamagetypeId(rs.getLong("damagetypes_damagetype_id"));

                spellDamagetypes.add(spellDamagetype);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellDamagetypes;      }

    @Override
    public SpellDamagetype update(SpellDamagetype dto) {
        SpellDamagetype spellDamagetype = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE); ) {
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getDamagetypesDamagetypeId());
            statement.setLong(3, dto.getSpellDamagetypeId());
            statement.execute();

            spellDamagetype = this.findById(dto.getSpellDamagetypeId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellDamagetype;    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // OVRs
    public List<SpellDamagetype> findAllBySpellId(long spellId){
        List<SpellDamagetype> spellDamagetypes = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellDamagetype spellDamagetype = new SpellDamagetype();

                spellDamagetype.setSpellDamagetypeId(rs.getLong("spell_damagetype_id"));
                spellDamagetype.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellDamagetype.setDamagetypesDamagetypeId(rs.getLong("damagetypes_damagetype_id"));

                spellDamagetypes.add(spellDamagetype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellDamagetypes;
    }

    public List<SpellDamagetype> findAllByDamagetypeId(long damagetypeId){
        List<SpellDamagetype> spellDamagetypes = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_DAMAGETYPE_ID);) {
            statement.setLong(1, damagetypeId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellDamagetype spellDamagetype = new SpellDamagetype();

                spellDamagetype.setSpellDamagetypeId(rs.getLong("spell_damagetype_id"));
                spellDamagetype.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellDamagetype.setDamagetypesDamagetypeId(rs.getLong("damagetypes_damagetype_id"));

                spellDamagetypes.add(spellDamagetype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellDamagetypes;
    }




}
