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
    private final static String GET_BY_ID = "SELECT " +
                                                "st.*, " +
                                                "s.*, " +
                                                "t.* " +
                                            "FROM spell_tags st " +
                                                "JOIN spells s ON st.spells_spell_id = s.spell_id " +
                                                "JOIN tags t ON st.tags_tag_id = t.tag_id " +
                                            "WHERE " +
                                                "st.spell_tag_id = 1;";

    // <!> Delete this after TagDAO completed
    private final static String GET_BY_NAME = "SELECT * FROM tags" +
                                              "WHERE tag_name=?";

    // <!> Change to focus on spell_tags table
    private final static String GET_ALL_BY_SPELL_ID = "SELECT " +
                                            " s.*, " +
                                            " st.*, " +
                                            " t.* " +
                                        "FROM spells s " +
                                            "JOIN spell_tags st ON s.spell_id = st.spells_spell_id " +
                                            "JOIN tags t ON t.tag_id = st.tags_tag_id " +
                                        "WHERE " +
                                            "s.spell_id = ?";

    // CONs
    public SpellTagDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    // <!> This targets the spell_tag_id.  Useful for changing a spell's tag when you know it
    public SpellTag findById(long id) {
        SpellTag spellTag = new SpellTag();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){

                spellTag.setSpellTagID(rs.getLong("spell_tag_id"));
                spellTag.setTagID(rs.getLong("tags_tag_id"));
                spellTag.setSpellName(rs.getString("spell_name"));
                spellTag.setTagName(rs.getString("tag_name"));
                spellTag.setTagType(rs.getString("tag_type"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellTag;
    }

    @Override
    // <!> This should target all spell_tag_id.  Should group by spell id, so you can see a
    // list of spells and their related tags
    public List<SpellTag> findAll() {
        List<SpellTag> spellTagList = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement("" +
                                            "SELECT * FROM tags " +
                                            "WHERE\n" +
                                                "\ttag_type = 'na'\n" +
                                                "\tOR tag_type = 'both'\n" +
                                                "\tOR tag_type = 'spell' ");){

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                SpellTag spellTag = new SpellTag();

                spellTag.setTagID(rs.getLong("tag_id"));
                spellTag.setTagName(rs.getString("tag_name"));
                spellTag.setTagType(rs.getString("tag_type"));

                spellTagList.add(spellTag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return spellTagList;
    }

    @Override
    // <!> This should focus on the spell tag relations, NOT tag itself!  Think spell_tags table, not tags!
    // <!>
    public SpellTag update(SpellTag dto) {
        return null;
    }

    @Override
    // <!> This should focus on the spell tag relations, NOT tag itself!  Think spell_tags table, not tags!
    public SpellTag create(SpellTag dto) {
        return null;
    }

    @Override
    // <!> This should focus on the spell tag relations, NOT tag itself!  Think spell_tags table, not tags!
    public void delete(long id) {
    }

    // METHs
    // <!> Move this to a rpgClassDAO!
    public SpellTag findByName (String tagName){
        SpellTag spellTag = new SpellTag();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME);) {
            statement.setString(1, tagName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                spellTag.setTagID(rs.getLong("tag_id"));
                spellTag.setTagName(rs.getString("tag_name"));
                spellTag.setTagName(rs.getString("tag_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spellTag;
    }

    public List<SpellTag> findAllWithSpellId(long spellId) {
        List<SpellTag> spellTags = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);

            ResultSet rs = statement.executeQuery();
            long tagId = 0;

            while (rs.next()){
                long currentTagId = rs.getLong("tag_id");

                if(currentTagId != tagId) {
                    SpellTag spellTag = new SpellTag();

                    spellTag.setSpellTagID(rs.getLong("spell_tag_id"));
                    spellTag.setTagID(rs.getLong("tag_id"));
                    spellTag.setTagName(rs.getString("tag_name"));
                    spellTag.setTagType(rs.getString("tag_type"));

                    spellTags.add(spellTag);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }



        return spellTags;
    }

}
