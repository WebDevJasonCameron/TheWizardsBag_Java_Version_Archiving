package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TagDAO extends DataAccessObject<Tag> {

    // SQLs
    private final static String GET_BY_ID = "SELECT * FROM tags " +
                                            "WHERE tag_id=?";

    private final static String GET_BY_NAME = "SELECT * FROM tags" +
                                              "WHERE tag_name=?";

    // CONs
    public TagDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Tag findById(long id) {
        Tag tag = new Tag();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                tag.setTagID(rs.getLong("tag_id"));
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
        return null;
    }

    @Override
    public Tag update(Tag dto) {
        return null;
    }

    @Override
    public Tag create(Tag dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    // METHs
}
