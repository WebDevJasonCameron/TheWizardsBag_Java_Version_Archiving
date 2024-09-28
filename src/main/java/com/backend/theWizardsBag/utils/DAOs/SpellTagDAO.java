package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellTagDAO extends DataAccessObject<SpellTag> {

    // SQLs
    private final static String INSERT = "INSERT INTO spell_tags " +
                                            "(spells_spell_id, tags_tag_id) " +
                                         "VALUES " +
                                            "(?, ?) ";

    private final static String GET_BY_ID = "SELECT * FROM spell_tags " +
                                            "WHERE spell_tag_id = ? ";

    private final static String GET_ALL = "SELECT * FROM spell_tags ";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT * FROM spell_tags " +
                                                      "WHERE spells_spell_id = ? ";

    private final static String GET_ALL_BY_TAG_ID = "SELECT * FROM spell_tags " +
                                                           "WHERE tags_tag_id = ?  ";

    private final static String UPDATE =    "UPDATE spell_tags " +
                                            "SET " +
                                                "spell_tag_id, " +
                                                "spells_spell_id, " +
                                                "tags_tag_id " +
                                            "WHERE " +
                                                "spell_tag_id = ? ";

    private final static String DELETE = "DELETE FROM spell_tags " +
                                         "WHERE spell_tag_id = ? ";

    // SQL & SPELL
    private final static String GET_BY_SPELL_AND_TAG_IDS = "SELECT  " +
                                                              "spell_tag_id " +
                                                           "FROM spell_tags " +
                                                           "WHERE " +
                                                              "spells_spell_id = ? " +
                                                              "AND tags_tag_id = ? ";

    // CONs
    public SpellTagDAO(Connection connection) {
        super(connection);
    }


    // OVRs
    @Override
    public SpellTag create(SpellTag dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getTagsTagId());
            statement.execute();

            long id = this.getLastVal(SPELL_TAG_SEQUENCE);
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }     }

    @Override
    public SpellTag findById(long id) {
        SpellTag spellTag = new SpellTag();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellTag.setSpellTagId(rs.getLong("spell_tag_id"));
                spellTag.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellTag.setTagsTagId(rs.getLong("tags_tag_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTag;

    }

    @Override
    public List<SpellTag> findAll() {
        List<SpellTag> spellTags = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                SpellTag spellTag = new SpellTag();

                spellTag.setSpellTagId(rs.getLong("spell_tag_id"));
                spellTag.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellTag.setTagsTagId(rs.getLong("tags_tag_id"));

                spellTags.add(spellTag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTags;      }

    @Override
    public SpellTag update(SpellTag dto) {
        SpellTag spellTag = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE); ) {
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getTagsTagId());
            statement.setLong(3, dto.getSpellTagId());
            statement.execute();

            spellTag = this.findById(dto.getSpellTagId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTag;      }

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

    // MTHs
    public List<SpellTag> findAllBySpellId(long spellId){
        List<SpellTag> spellTags = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellTag spellTag = new SpellTag();

                spellTag.setSpellTagId(rs.getLong("spell_tag_id"));
                spellTag.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellTag.setTagsTagId(rs.getLong("tags_tag_id"));

                spellTags.add(spellTag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTags;
    }

    public List<SpellTag> findAllByTagId(long tagId){
        List<SpellTag> spellTags = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_TAG_ID);) {
            statement.setLong(1, tagId);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellTag spellTag = new SpellTag();

                spellTag.setSpellTagId(rs.getLong("spell_tag_id"));
                spellTag.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellTag.setTagsTagId(rs.getLong("tags_tag_id"));

                spellTags.add(spellTag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTags;
    }

    // MTHs & SPELL
    public SpellTag findBySpellAndTagIds(long spellId, long tagId) {
        SpellTag spellTag = new SpellTag();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_SPELL_AND_TAG_IDS);){
            statement.setLong(1, spellId);
            statement.setLong(2, tagId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellTag.setSpellTagId(rs.getLong("spell_tag_id"));
                spellTag.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellTag.setTagsTagId(rs.getLong("tags_tag_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTag;
    }
}
