package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO extends DataAccessObject<Tag> {

    // SQLs
    private final static String INSERT = "INSERT INTO tags " +
                                            "(tag_name, tag_type)" +
                                         "VALUES (?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM tags " +
                                            "WHERE tag_id=?";

    private final static String GET_ALL = "SELECT * FROM tags";

    private final static String GET_BY_NAME = "SELECT * FROM tags " +
                                              "WHERE tag_name=?";

    private final static String UPDATE = " UPDATE tags SET tag_name = ?, tag_type = ? WHERE tag_id = ? ";

    private final static String DELETE = "DELETE FROM tags " +
                                         "WHERE tag_id = ?";

    // SQL & SPELL
    private final static String GET_ALL_BY_SPELL_ID =
                                        "SELECT  " +
                                            "t.* " +
                                        "FROM spells s  " +
                                        "JOIN spell_tags st ON st.spells_spell_id = s.spell_id " +
                                        "JOIN tags t ON sd.spell_tag_id = t.tag_id " +
                                        "WHERE s.spell_id = ?";

    // CONs
    public TagDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Tag create(Tag dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getTagName());
            statement.setString(2, dto.getTagType());
            statement.execute();
            long id = this.getLastVal(TAG_SEQUENCE);
            return this.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Tag findById(long id) {
        Tag tag = new Tag();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                tag.setTagId(rs.getLong("tag_id"));
                tag.setTagName(rs.getString("tag_name"));
                tag.setTagType(rs.getString("tag_type"));
            }

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return tag;
    }

    @Override
    public List<Tag> findAll() {
        List<Tag> tags = new ArrayList<>();

        try(PreparedStatement statement =
                    this.connection.prepareStatement(GET_ALL);){

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Tag tag = new Tag();

                tag.setTagId(rs.getLong("tag_id"));
                tag.setTagName(rs.getString("tag_name"));
                tag.setTagType(rs.getString("tag_type"));

                tags.add(tag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return tags;
    }

    @Override
    public Tag update(Tag dto) {
        Tag tag = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getTagName());
            statement.setString(2, dto.getTagType());
            statement.setLong(3, dto.getTagId());
            statement.execute();

            tag = this.findById(dto.getTagId());
            System.out.println(tag);

        } catch (SQLException e) {
             e.printStackTrace();
             throw new RuntimeException(e);
        }
        return tag;
    }

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

    // METHs
    public Tag findByName (String tagName){
        Tag tag = new Tag();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME);) {
            statement.setString(1, tagName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                tag.setTagId(rs.getLong("tag_id"));
                tag.setTagName(rs.getString("tag_name"));
                tag.setTagType(rs.getString("tag_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return tag;
    }

    public List<Tag> findAllBySpellId(long spellId){
        List<Tag> tags = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);){
            statement.setLong(1, spellId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Tag tag = new Tag();

                tag.setTagId(rs.getLong("tag_id"));
                tag.setTagName(rs.getString("tag_name"));
                tag.setTagType(rs.getString("tag_type"));

                tags.add(tag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return tags;
    }

}
