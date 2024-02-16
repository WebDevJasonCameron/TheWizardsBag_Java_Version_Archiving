package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Note;
import com.backend.theWizardsBag.models.RpgClass;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RpgClassDAO extends DataAccessObject<RpgClass> {

    // SQLs
    private final static String INSERT = "INSERT INTO rpg_classes " +
            "(class_name, class_subclass_name, class_description) " +
            "VALUES (?, ?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM rpg_classes " +
            "WHERE class_id = ? ";

    private final static String GET_ALL = "SELECT * FROM rpg_classes ";

    private final static String GET_ALL_BY_NAME = "SELECT * FROM rpg_classes " +
            "WHERE LOWER(class_name) = LOWER( ? )";

    private final static String GET_BY_NAME_AND_SUB = "SELECT * FROM rpg_classes " +
            "WHERE LOWER(class_name) = LOWER( ? ) " +
            "AND LOWER(class_subclass_name) = LOWER( ? ) ";

    private final static String UPDATE = "UPDATE rpg_classes " +
            "SET class_name = ?, class_subclass_name = ?, class_description = ? " +
            "WHERE class_id = ? ";

    private final static String DELETE = "DELETE FROM rpg_classes " +
            "WHERE class_id = ? ";

    // CONs
    public RpgClassDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public RpgClass create(RpgClass dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getClassName());
            statement.setString(2, dto.getClassSubclassName());
            statement.setString(3, dto.getClassDescription());
            statement.execute();
            long id = this.getLastVal(NOTE_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public RpgClass findById(long id) {
        RpgClass rpgClass = new RpgClass();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                rpgClass.setClassId(rs.getLong("class_id"));
                rpgClass.setClassName(rs.getString("class_name"));
                rpgClass.setClassSubclassName(rs.getString("class_subclass_name"));
                rpgClass.setClassDescription(rs.getString("class_description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rpgClass;
    }

    @Override
    public List<RpgClass> findAll() {
        List<RpgClass> rpgClasses = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                RpgClass rpgClass = new RpgClass();

                rpgClass.setClassId(rs.getLong("class_id"));
                rpgClass.setClassName(rs.getString("class_name"));
                rpgClass.setClassSubclassName(rs.getString("class_subclass_name"));
                rpgClass.setClassDescription(rs.getString("class_description"));

                rpgClasses.add(rpgClass);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rpgClasses;
    }

    @Override
    public RpgClass update(RpgClass dto) {
        RpgClass rpgClass = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getClassName());
            statement.setString(2, dto.getClassSubclassName());
            statement.setString(3, dto.getClassDescription());
            statement.setLong(4, dto.getClassId());
            statement.execute();

            rpgClass = this.findById(dto.getClassId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rpgClass;
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

    // MTHs
    public List<RpgClass> findAllByName(String className){
        List<RpgClass> rpgClasses = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_NAME);){
            statement.setString(1, className);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                RpgClass rpgClass = new RpgClass();

                rpgClass.setClassId(rs.getLong("class_id"));
                rpgClass.setClassName(rs.getString("class_name"));
                rpgClass.setClassSubclassName(rs.getString("class_subclass_name"));
                rpgClass.setClassDescription(rs.getString("class_description"));

                rpgClasses.add(rpgClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return rpgClasses;
    }

    public RpgClass findByNameAndSub(String className, String classSubclassName){
        RpgClass rpgClass = new RpgClass();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME_AND_SUB);){
            statement.setString(1, className);
            statement.setString(2, classSubclassName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){

                rpgClass.setClassId(rs.getLong("class_id"));
                rpgClass.setClassName(rs.getString("class_name"));
                rpgClass.setClassSubclassName(rs.getString("class_subclass_name"));
                rpgClass.setClassDescription(rs.getString("class_description"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return rpgClass;
    }

}
