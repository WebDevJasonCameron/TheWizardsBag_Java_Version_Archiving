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

    // CONs
    public SpellClassDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override                   //   Junction Table ID
    public SpellClass findById(long id) {
        return null;
    }

    @Override
    public List<SpellClass> findAll() {
        List<SpellClass> spellClasses = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM rpg_classes");){

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellClass spellClass = new SpellClass();

                spellClass.setClassID(rs.getInt("class_id"));
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
