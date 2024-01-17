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

    // CONs
    public SpellTagDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellTag findById(long id) {
        return null;
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
                spellTag.setTagName(rs.getString("name"));
                spellTag.setTagType(rs.getString("type"));

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
    public List<SpellClass> findAllWithSpellId(long id) { return null; }

}
