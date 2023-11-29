package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.beans.Customizer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellDAO extends DataAccessObject<Spell> {

    // VARs


    // CONs
    public SpellDAO(Connection connection){
        super(connection);
    }

    // OVRs
    @Override
    public Spell findById(long id) {
        return null;
    }

    @Override
    public List<Spell> findAll() {
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM spells");){

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getInt("spell_id"));
                spell.setLevel(rs.getString("level"));
                spell.setCastingTime(rs.getString("casting_time"));
                spell.setRange(rs.getString("range_area"));
                spell.setComponentsVisual(rs.getBoolean("component_visual"));
                spell.setComponentsSemantic(rs.getBoolean("component_semantic"));
                spell.setComponentsMaterial(rs.getBoolean("component_material"));
                spell.setComponentsMaterials(rs.getString("component_materials"));
                spell.setDuration(rs.getString("duration"));
                spell.setConcentration(rs.getBoolean("concentration"));
                spell.setRitual(rs.getBoolean("ritual"));
                spell.setSchool(rs.getString("school"));
                spell.setSaveType(rs.getString("save_type"));
                spell.setDescription(rs.getString("description"));
                spell.setImageUrl(rs.getString("image_url"));
                spell.setSource(rs.getInt("source"));

                // Need to get the lists from junction tables

                // Add to Spell List
                spells.add(spell);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    @Override
    public Spell update(Spell dto) {
        return null;
    }

    @Override
    public Spell create(Spell dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }



    // METHs
}
