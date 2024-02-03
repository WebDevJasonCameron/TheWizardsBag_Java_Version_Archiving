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
    private final static String INSERT = "INSERT INTO rpg_classes " +
                                            "(class_name, class_subclass_name, class_description) " +
                                         "VALUES (?, ?, ?)";

    private final static String DELETE = "DELETE FROM rpg_classes WHERE class_id = ?";

    private final static String GET_BY_ID = "SELECT * FROM rpg_classes WHERE class_id=?";

    private final static String GET_ALL_BY_SPELL_ID = "SELECT \n" +
                                                " s.*,\n" +
                                                " sc.*,\n" +
                                                " rc.*\n" +
                                                "FROM spells s\n" +
                                                "\tJOIN spell_classes sc ON s.spell_id = sc.spells_spell_id\n" +
                                                "\tJOIN rpg_classes rc ON rc.class_id = sc.classes_class_id\n" +
                                                "WHERE \n" +
                                                "\ts.spell_id = ?";

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
                spellClass.setClassSubClassName(rs.getString("class_subclass_name"));
                spellClass.setClassDescription(rs.getString("class_description"));
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
                spellClass.setClassSubClassName(rs.getString("class_subclass_name"));
                spellClass.setClassDescription(rs.getString("class_description"));

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
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getClassName());
            statement.setString(2, dto.getClassSubClassName());
            statement.setString(3, dto.getClassDescription());
            statement.execute();
            long id = this.getLastVal(CLASS_SEQUENCE);
            return this.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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

    // METHs
    public List<SpellClass> findAllBySpellId (long spellId) {
        List<SpellClass> spellClasses = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_SPELL_ID);) {
            statement.setLong(1, spellId);

            ResultSet rs = statement.executeQuery();
            long classId = 0;

            while (rs.next()) {
                long currentClassId = rs.getLong("class_id");

                if (currentClassId != classId) {
                    SpellClass spellClass = new SpellClass();

                    spellClass.setSpellClassID(rs.getLong("spell_class_id"));
                    spellClass.setClassID(rs.getLong("class_id"));
                    spellClass.setClassName(rs.getString("class_name"));
                    spellClass.setClassSubClassName(rs.getString("class_subclass_name"));
                    spellClass.setClassDescription(rs.getString("class_description"));

                    spellClasses.add(spellClass);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return spellClasses;
    }


}
