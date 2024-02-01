package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.*;
import com.backend.theWizardsBag.utils.Executables.SpellClassJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellConditionJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellDamagetypeJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellTagJDBCExecutor;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellDAO extends DataAccessObject<Spell> {

    // SQLs
    private final static String GET_BY_ID = "SELECT * FROM spells WHERE spell_id=?";

    private final static String GET_BY_SPELL_NAME = "SELECT * FROM spells WHERE spell_name=?";

    // CONs
    public SpellDAO(Connection connection){
        super(connection);
    }

    // OVRs
    @Override
    public Spell findById(long id) {
        Spell spell = new Spell();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                List<SpellDamage> spellDamages = new ArrayList<>();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setName(rs.getString("spell_name"));
                spell.setLevel(rs.getString("spell_level"));
                spell.setCastingTime(rs.getString("spell_casting_time"));
                spell.setRange(rs.getString("spell_range_area"));
                spell.setComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setDuration(rs.getString("spell_duration"));
                spell.setConcentration(rs.getBoolean("spell_concentration"));
                spell.setRitual(rs.getBoolean("spell_ritual"));
                spell.setSchool(rs.getString("spell_school"));
                spell.setSaveType(rs.getString("spell_save_type"));
                spell.setDescription(rs.getString("spell_description"));
                spell.setImageUrl(rs.getString("spell_image_url"));
                spell.setSource(rs.getInt("spell_source_id"));

                // Get & Set Spell Tags
                SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
                spell.setTagList(spellTagJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Conditions
                SpellConditionJDBCExecutor spellConditionJDBCExecutor = new SpellConditionJDBCExecutor();
                spell.setConditionList(spellConditionJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Classes
                SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();
                spell.setClassList(spellClassJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Damages
                SpellDamagetypeJDBCExecutor spellDamagetypeJDBCExecutor = new SpellDamagetypeJDBCExecutor();
                spell.setDamageList(spellDamagetypeJDBCExecutor.getAllBySpellId(spell.getSpellId()));


            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return spell;
    }

    @Override
    public List<Spell> findAll() {
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM spells");){

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setName(rs.getString("spell_name"));
                spell.setLevel(rs.getString("spell_level"));
                spell.setCastingTime(rs.getString("spell_casting_time"));
                spell.setRange(rs.getString("spell_range_area"));
                spell.setComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setDuration(rs.getString("spell_duration"));
                spell.setConcentration(rs.getBoolean("spell_concentration"));
                spell.setRitual(rs.getBoolean("spell_ritual"));
                spell.setSchool(rs.getString("spell_school"));
                spell.setSaveType(rs.getString("spell_save_type"));
                spell.setDescription(rs.getString("spell_description"));
                spell.setImageUrl(rs.getString("spell_image_url"));
                spell.setSource(rs.getInt("spell_source_id"));

                // Get & Set Spell Tags
                SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
                spell.setTagList(spellTagJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Conditions
                SpellConditionJDBCExecutor spellConditionJDBCExecutor = new SpellConditionJDBCExecutor();
                spell.setConditionList(spellConditionJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Classes
                SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();
                spell.setClassList(spellClassJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Damages
                SpellDamagetypeJDBCExecutor spellDamagetypeJDBCExecutor = new SpellDamagetypeJDBCExecutor();
                spell.setDamageList(spellDamagetypeJDBCExecutor.getAllBySpellId(spell.getSpellId()));
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
    public Spell findBySpellName(String spellName){
        Spell spell = new Spell();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_SPELL_NAME);) {
            statement.setString(1, spellName);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                List<SpellDamage> spellDamages = new ArrayList<>();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setName(rs.getString("spell_name"));
                spell.setLevel(rs.getString("spell_level"));
                spell.setCastingTime(rs.getString("spell_casting_time"));
                spell.setRange(rs.getString("spell_range_area"));
                spell.setComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setDuration(rs.getString("spell_duration"));
                spell.setConcentration(rs.getBoolean("spell_concentration"));
                spell.setRitual(rs.getBoolean("spell_ritual"));
                spell.setSchool(rs.getString("spell_school"));
                spell.setSaveType(rs.getString("spell_save_type"));
                spell.setDescription(rs.getString("spell_description"));
                spell.setImageUrl(rs.getString("spell_image_url"));
                spell.setSource(rs.getInt("spell_source_id"));

                // Get & Set Spell Tags
                SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();
                spell.setTagList(spellTagJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Conditions
                SpellConditionJDBCExecutor spellConditionJDBCExecutor = new SpellConditionJDBCExecutor();
                spell.setConditionList(spellConditionJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Classes
                SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();
                spell.setClassList(spellClassJDBCExecutor.getAllBySpellId(spell.getSpellId()));

                // Get & Set Spell Damages
                SpellDamagetypeJDBCExecutor spellDamagetypeJDBCExecutor = new SpellDamagetypeJDBCExecutor();
                spell.setDamageList(spellDamagetypeJDBCExecutor.getAllBySpellId(spell.getSpellId()));


            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return spell;
    }
}
