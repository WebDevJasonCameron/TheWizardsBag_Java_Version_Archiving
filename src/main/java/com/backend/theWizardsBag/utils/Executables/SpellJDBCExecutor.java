package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.utils.DAOs.SpellDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    public Spell create(String spellName,
                        String spellLevel,
                        String spellCastingTime,
                        String spellRange,
                        boolean spellComponentsVisual,
                        boolean spellComponentsSemantic,
                        boolean spellComponentsMaterial,
                        String spellComponentsMaterials,
                        String spellDuration,
                        boolean spellConcentration,
                        boolean spellRitual,
                        String spellSchool,
                        String spellSaveType,
                        String spellDescription,
                        String spellImageUr,
                        long spellSource){
        try {
            Connection connection = this.dcm.getConnection();
            SpellDAO spellDAO = new SpellDAO(connection);
            Spell spell = new Spell();

            spell.setSpellName(spellName);
            spell.setSpellLevel(spellLevel);
            spell.setSpellCastingTime(spellCastingTime);
            spell.setSpellRange(spellRange);
            spell.setSpellComponentsVisual(spellComponentsVisual);
            spell.setSpellComponentsSemantic(spellComponentsSemantic);
            spell.setSpellComponentsMaterial(spellComponentsMaterial);
            spell.setSpellComponentsMaterials(spellComponentsMaterials);
            spell.setSpellDuration(spellDuration);
            spell.setSpellConcentration(spellConcentration);
            spell.setSpellRitual(spellRitual);
            spell.setSpellSchool(spellSchool);
            spell.setSpellSaveType(spellSaveType);
            spell.setSpellDescription(spellDescription);
            spell.setSpellImageUrl(spellImageUr);
            spell.setSpellSource(spellSource);

            return spellDAO.create(spell);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Spell getById (long id) {

        Spell spell = new Spell();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spell =  spellDAO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spell;
    }

    public final List<Spell> getAll() {
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells =  spellDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spells;
    }

    public Spell getBySpellName(String spellName) {
        Spell spell = new Spell();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spell =  spellDAO.findBySpellName(spellName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spell;
    }

    public List<Spell> getAllByWordInSpellName(String word) {
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells =  spellDAO.findAllWithWordInSpellName(word);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spells;
    }

    public List<Spell> getAllByLevel(String word) {
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells = spellDAO.findAllWithSpellLevel(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spells;
    }

    public List<Spell> getAllByCastingTime(String word){
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells = spellDAO.findAllWithCastingTime(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spells;
    }

    public List<Spell> getAllByRange(String word){
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells = spellDAO.findAllWithRange(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spells;
    }

    public List<Spell> getAllByConcentration(boolean word){
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells = spellDAO.findAllWithConcentration(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spells;
    }

    public List<Spell> getAllBySpellSchool(String word) {
        List<Spell> spells = new ArrayList<>();

        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            spells =  spellDAO.findAllWithSpellSchool(word);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spells;
    }

    public Spell update(Spell spellNewData){
        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);

            Spell spell = spellDAO.findById(spellNewData.getSpellId());

            spell.setSpellName(spellNewData.getSpellName());
            spell.setSpellLevel(spellNewData.getSpellLevel());
            spell.setSpellCastingTime(spellNewData.getSpellCastingTime());
            spell.setSpellRange(spellNewData.getSpellRange());
            spell.setSpellComponentsVisual(spellNewData.isSpellComponentsVisual());
            spell.setSpellComponentsSemantic(spellNewData.isSpellComponentsSemantic());
            spell.setSpellComponentsMaterial(spellNewData.isSpellComponentsMaterial());
            spell.setSpellComponentsMaterials(spellNewData.getSpellComponentsMaterials());
            spell.setSpellDuration(spellNewData.getSpellDuration());
            spell.setSpellConcentration(spellNewData.isSpellConcentration());
            spell.setSpellRitual(spellNewData.isSpellRitual());
            spell.setSpellSchool(spellNewData.getSpellSchool());
            spell.setSpellSaveType(spellNewData.getSpellSaveType());
            spell.setSpellDescription(spellNewData.getSpellDescription());
            spell.setSpellImageUrl(spellNewData.getSpellImageUrl());
            spell.setSpellSource(spellNewData.getSpellSource());
            spell = spellDAO.update(spellNewData);

            return spell;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try (Connection connection = this.dcm.getConnection()){
            SpellDAO spellDAO = new SpellDAO(connection);
            Spell spellBeingDeleted = spellDAO.findById(id);
            spellDAO.delete(id);
            System.out.println("Deleted: " + spellBeingDeleted.getSpellName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
