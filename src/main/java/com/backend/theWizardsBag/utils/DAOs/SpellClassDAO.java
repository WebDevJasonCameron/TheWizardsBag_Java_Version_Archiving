package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.SpellClass;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellClassDAO extends DataAccessObject<SpellClass> {

    // SQLs
    private final static String GET_BY_ID = "SELECT * FROM rpg_classes WHERE class_id=?";

    // CONs
    public SpellClassDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellClass findById(long id) {
        SpellClass spellClass = new SpellClass();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellClass.setClassID(rs.getLong("class_id"));
                spellClass.setClassName(rs.getString("class_name"));
                spellClass.setSubClassName(rs.getString("subclass_name"));
                spellClass.setClassDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spellClass;
    }

    @Override
    public List<SpellClass> findAll() {
        List<SpellClass> spellClasses = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM rpg_classes");){

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellClass spellClass = new SpellClass();

                spellClass.setClassID(rs.getLong("class_id"));
                spellClass.setClassName(rs.getString("class_name"));
                spellClass.setSubClassName(rs.getString("subclass_name"));
                spellClass.setClassDescription(rs.getString("description"));

                spellClasses.add(spellClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spellClasses;
    }

    @Override
    public SpellClass update(SpellClass dto) {
        return null;
    }

    @Override
    public SpellClass create(SpellClass dto) {
        return null;
    }

    @Override
    public void delete(long id) {
    }

    // METHs                    //   Given Spell ID, find all JOINT table data
    public List<SpellClass> findAllWithSpellId (long spellId) { return null;}


}
