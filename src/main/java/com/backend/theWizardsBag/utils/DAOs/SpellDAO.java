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
    private static final String GET_ALL_ORD = "SELECT * FROM spells ORDER BY name" ;


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

                // Fill in all the SETTERS

                // Add to Spell List

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
