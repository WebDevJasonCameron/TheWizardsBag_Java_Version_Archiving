package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.*;
import com.backend.theWizardsBag.utils.Executables.*;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellDAO extends DataAccessObject<Spell> {

    // SQLs
    private final static String INSERT = "INSERT INTO spells " +
                                            "(spell_name, " +
                                            "spell_level, " +
                                            "spell_casting_time, " +
                                            "spell_range_area, " +
                                            "spell_component_visual, " +
                                            "spell_component_semantic, " +
                                            "spell_component_material, " +
                                            "spell_component_materials, " +
                                            "spell_duration, " +
                                            "spell_concentration, " +
                                            "spell_ritual, " +
                                            "spell_school, " +
                                            "spell_save_type, " +
                                            "spell_description, " +
                                            "spell_image_url, " +
                                            "spell_source_id) " +
                                         "VALUES " +
                                             "(?, ?, ?, ?, ?, " +
                                             "?, ?, ?, ?, ?, " +
                                             "?, ?, ?, ?, ?," +
                                             "?) ";

    private final static String GET_BY_ID = "SELECT * FROM spells " +
                                            "WHERE spell_id = ? ";

    private final static String GET_ALL = "SELECT * FROM spells ";

    private final static String GET_BY_SPELL_NAME = "SELECT * FROM spells " +
                                                    "WHERE " +
                                                        "LOWER(spell_name) = LOWER(?) ";

    private final static String GET_BY_WORD_IN_NAME = "SELECT * FROM spells " +
                                                      "WHERE " +
                                                         "POSITION(LOWER(?) IN (LOWER(spell_name))) > 0";

    private final static String GET_BY_LEVEL = "SELECT * FROM spells " +
                                               "WHERE " +
                                                 "POSITION(LOWER(?) IN (LOWER(spell_level))) > 0";

    private final static String GET_ALL_BY_SPELL_SCHOOL = "SELECT * FROM spells " +
                                                          "WHERE spell_school = ? ";

    private final static String GET_BY_CASTING_TIME = "SELECT * FROM spells " +
                                        "WHERE " +
                                            "POSITION(LOWER(?) IN (LOWER(spell_casting_time))) > 0";

    private final static String GET_BY_RANGE = "SELECT * FROM spells " +
                                        "WHERE " +
                                            "POSITION(LOWER(?) IN (LOWER(spell_range_area))) > 0";

    private final static String GET_BY_CONCENTRATION = "SELECT * FROM spells " +
                                                       "WHERE " +
                                                          "spell_concentration = ?";

    private final static String UPDATE = "UPDATE spells " +
                                         "SET " +
                                             "spell_name = ?, " +
                                             "spell_level = ?, " +
                                             "spell_casting_time = ?, " +
                                             "spell_range_area = ?, " +
                                             "spell_component_visual = ?, " +
                                             "spell_component_semantic = ?, " +
                                             "spell_component_material = ?, " +
                                             "spell_component_materials = ?, " +
                                             "spell_duration = ?, " +
                                             "spell_concentration = ?, " +
                                             "spell_ritual = ?, " +
                                             "spell_school = ?, " +
                                             "spell_save_type = ?, " +
                                             "spell_description = ?, " +
                                             "spell_image_url = ?, " +
                                             "spell_source_id = ? " +
                                         "WHERE " +
                                             "spell_id = ?";

    private final static String DELETE = "DELETE FROM spells " +
                                         "WHERE spell_id = ? ";

    // SUB Qs
    private final static String GET_ALL_SPELL_LEVELS = "SELECT DISTINCT spell_level " +
                                                        "FROM spells " +
                                                        "ORDER BY spell_level ASC";

    private final static String GET_ALL_SPELL_CASTING_TIMES = "SELECT DISTINCT spell_casting_time " +
            "FROM spells " +
            "ORDER BY spell_casting_time ASC";

    // CONs
    public SpellDAO(Connection connection){
        super(connection);
    }

    // OVRs
    @Override
    public Spell create(Spell dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getSpellName());
            statement.setString(2, dto.getSpellLevel());
            statement.setString(3, dto.getSpellCastingTime());
            statement.setString(4, dto.getSpellRange());
            statement.setBoolean(5, dto.isSpellComponentsVisual());
            statement.setBoolean(6, dto.isSpellComponentsSemantic());
            statement.setBoolean(7, dto.isSpellComponentsMaterial());
            statement.setString(8, dto.getSpellComponentsMaterials());
            statement.setString(9, dto.getSpellDuration());
            statement.setBoolean(10, dto.isSpellConcentration());
            statement.setBoolean(11, dto.isSpellRitual());
            statement.setString(12, dto.getSpellSchool());
            statement.setString(13, dto.getSpellSaveType());
            statement.setString(14, dto.getSpellDescription());
            statement.setString(15, dto.getSpellImageUrl());
            statement.setLong(16, dto.getSpellSource());
            statement.execute();
            long id = this.getLastVal(SPELL_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Spell findById(long id) {
        Spell spell = new Spell();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));


                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));


                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

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

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

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
        Spell spell = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getSpellName());
            statement.setString(2, dto.getSpellLevel());
            statement.setString(3, dto.getSpellCastingTime());
            statement.setString(4, dto.getSpellRange());
            statement.setBoolean(5, dto.isSpellComponentsVisual());
            statement.setBoolean(6, dto.isSpellComponentsSemantic());
            statement.setBoolean(7, dto.isSpellComponentsMaterial());
            statement.setString(8, dto.getSpellComponentsMaterials());
            statement.setString(9, dto.getSpellDuration());
            statement.setBoolean(10, dto.isSpellConcentration());
            statement.setBoolean(11, dto.isSpellRitual());
            statement.setString(12, dto.getSpellSchool());
            statement.setString(13, dto.getSpellSaveType());
            statement.setString(14, dto.getSpellDescription());
            statement.setString(15, dto.getSpellImageUrl());
            statement.setLong(16, dto.getSpellSource());
            statement.setLong(17, dto.getSpellId());
            statement.execute();

            spell = this.findById(dto.getSpellId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spell;
    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // METHs
    public Spell findBySpellName(String spellName){
        Spell spell = new Spell();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_SPELL_NAME);) {
            statement.setString(1, spellName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));


                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return spell;
    }

    public List<Spell> findAllWithWordInSpellName(String word){
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_WORD_IN_NAME);){
            statement.setString(1, word);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));


                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Add to Spell List
                spells.add(spell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    public List<Spell> findAllWithSpellLevel(String word){
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_LEVEL);){
            statement.setString(1, word);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

                // <!> Getting an error for the following meths, "too many connections"

                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Add to Spell List
                spells.add(spell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    public List<Spell> findAllWithCastingTime(String word){
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_CASTING_TIME);){
            statement.setString(1, word);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

                // <!> Getting an error for the following meths, "too many connections"

                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Add to Spell List
                spells.add(spell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    public List<Spell> findAllWithRange(String word){
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_RANGE);){
            statement.setString(1, word);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

                // <!> Getting an error for the following meths, "too many connections"

                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Add to Spell List
                spells.add(spell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    public List<Spell> findAllWithConcentration(boolean word){
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_CONCENTRATION);){
            statement.setBoolean(1, word);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

                // <!> Getting an error for the following meths, "too many connections"

                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Add to Spell List
                spells.add(spell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    public List<Spell> findAllWithSpellSchool(String word){
        List<Spell> spells = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_SCHOOL);){
            statement.setString(1, word);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Spell spell = new Spell();

                spell.setSpellId(rs.getLong("spell_id"));
                spell.setSpellName(rs.getString("spell_name"));
                spell.setSpellLevel(rs.getString("spell_level"));
                spell.setSpellCastingTime(rs.getString("spell_casting_time"));
                spell.setSpellRange(rs.getString("spell_range_area"));
                spell.setSpellComponentsVisual(rs.getBoolean("spell_component_visual"));
                spell.setSpellComponentsSemantic(rs.getBoolean("spell_component_semantic"));
                spell.setSpellComponentsMaterial(rs.getBoolean("spell_component_material"));
                spell.setSpellComponentsMaterials(rs.getString("spell_component_materials"));
                spell.setSpellDuration(rs.getString("spell_duration"));
                spell.setSpellConcentration(rs.getBoolean("spell_concentration"));
                spell.setSpellRitual(rs.getBoolean("spell_ritual"));
                spell.setSpellSchool(rs.getString("spell_school"));
                spell.setSpellSaveType(rs.getString("spell_save_type"));
                spell.setSpellDescription(rs.getString("spell_description"));
                spell.setSpellImageUrl(rs.getString("spell_image_url"));
                spell.setSpellSource(rs.getInt("spell_source_id"));

                // <!> Getting an error for the following meths, "too many connections"

                // Get & Set Classes List
                RpgClassJDBCExecutor rpgClassJDBCExecutor = new RpgClassJDBCExecutor();
                spell.setClassList(rpgClassJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Conditions List
                ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();
                spell.setConditionList(conditionJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Damages
                DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();
                spell.setDamagetypeList(damagetypeJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Get & Set Spell Tags
                TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
                spell.setTagList(tagJDBCExecutor.getAllBySpell(spell.getSpellId()));

                // Add to Spell List
                spells.add(spell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return spells;
    }

    // SUB METHs
    public List<String> findAllSpellLevels(){
        List<String> spellLevels = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_SPELL_LEVELS);){
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                spellLevels.add(rs.getString("spell_level"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellLevels;
    }

    public List<String> getAllSpellCastingTime(){                   // <!> Here
        List<String> spellCastingTimes = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_SPELL_LEVELS);){
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                spellCastingTimes.add(rs.getString("spell_level"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellCastingTimes;
    }

}
