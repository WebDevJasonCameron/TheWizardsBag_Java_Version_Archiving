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
    private final static String INSERT = "INSERT INTO spell_classes " +
                                            "(spells_spell_id, classes_class_id) " +
                                         "VALUES " +
                                            "(?, ?) ";

    private final static String GET_BY_ID = "SELECT * FROM spell_classes " +
                                            "WHERE spell_class_id = ? ";

    private final static String GET_ALL = "SELECT * FROM spell_classes ";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT * FROM spell_classes " +
                                                      "WHERE spells_spell_id = ?";


    private final static String GET_ALL_BY_CLASS_ID = "SELECT * FROM spell_classes " +
                                                      "WHERE classes_class_id = ?";

    private final static String UPDATE =    "UPDATE spell_classes " +
                                            "SET " +
                                                "spell_class_id, " +
                                                "spells_spell_id, " +
                                                "classes_class_id " +
                                            "WHERE " +
                                                "spell_class_id = ? ";

    private final static String DELETE = "DELETE FROM spell_classes " +
            "WHERE spell_class_id = ? ";

    // CONs
    public SpellClassDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public SpellClass create(SpellClass dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getClassesClassId());
            statement.execute();

            long id = this.getLastVal(SPELL_CLASS_SEQUENCE);
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public SpellClass findById(long id) {
        SpellClass spellClass = new SpellClass();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                spellClass.setSpellClassId(rs.getLong("spell_class_id"));
                spellClass.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellClass.setClassesClassId(rs.getLong("classes_class_id"));

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

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                SpellClass spellClass = new SpellClass();

                spellClass.setSpellClassId(rs.getLong("spell_class_id"));
                spellClass.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellClass.setClassesClassId(rs.getLong("classes_class_id"));

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
        SpellClass spellClass = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE); ) {
            statement.setLong(1, dto.getSpellsSpellId());
            statement.setLong(2, dto.getClassesClassId());
            statement.setLong(3, dto.getSpellClassId());
            statement.execute();

            spellClass = this.findById(dto.getSpellClassId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellClass;
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

    // MTHs
    public List<SpellClass> findAllBySpellId(long spellId){
        List<SpellClass> spellClasses = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellClass spellClass = new SpellClass();

                spellClass.setSpellClassId(rs.getLong("spell_class_id"));
                spellClass.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellClass.setClassesClassId(rs.getLong("classes_class_id"));

                spellClasses.add(spellClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellClasses;
    }

    public List<SpellClass> findAllByClassId(long classId){
        List<SpellClass> spellClasses = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_CLASS_ID);) {
            statement.setLong(1, classId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                SpellClass spellClass = new SpellClass();

                spellClass.setSpellClassId(rs.getLong("spell_class_id"));
                spellClass.setSpellsSpellId(rs.getLong("spells_spell_id"));
                spellClass.setClassesClassId(rs.getLong("classes_class_id"));

                spellClasses.add(spellClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return spellClasses;
    }
}
