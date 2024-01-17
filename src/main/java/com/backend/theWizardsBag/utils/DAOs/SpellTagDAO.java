package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellClass;
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
    private final static String GET_BY_ID = "SELECT * FROM tags WHERE tag_id=?";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT \n" +
                                            " s.*,\n" +
                                            " st.*,\n" +
                                            " t.*\n" +
                                        "FROM spells s\n" +
                                            "\tJOIN spell_tags st ON s.spell_id = st.spells_spell_id\n" +
                                            "\tJOIN tags t ON t.tag_id = st.tags_tag_id\n" +
                                        "WHERE \n" +
                                            "\ts.spell_id = ?";

    // CONs
    public SpellTagDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellTag findById(long id) {
        SpellTag spellTag = new SpellTag();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellTag.setTagID(rs.getLong("tag_id"));
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
    public List<SpellTag> findAll() {
        List<SpellTag> spellTagList = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement("" +
                "SELECT * FROM tags " +
                "WHERE\n" +
                "\ttype = 'na'\n" +
                "\tOR type = 'both'\n" +
                "\tOR type = 'spell' ");){

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
