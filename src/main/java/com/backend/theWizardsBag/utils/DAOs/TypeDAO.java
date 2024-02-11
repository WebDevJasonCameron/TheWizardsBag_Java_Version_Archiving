package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Type;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO extends DataAccessObject<Type> {

    // SQLs
    private final static String INSERT = "INSERT INTO types " +
                                            "(type_name, type_sub_type)" +
                                         "VALUES (?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM types " +
                                            "WHERE type_id=?";

    private final static String GET_ALL = "SELECT * FROM types";

    private final static String GET_ALL_BY_NAME = "SELECT * FROM types " +
                                                  "WHERE type_name = ?";

    private final static String GET_BY_NAME_AND_SUB = "SELECT * FROM types " +
                                                      "WHERE " +
                                                        "type_name = ? " +
                                                        "AND type_sub_type = ?";

    private final static String UPDATE = "UPDATE types SET type_name = ?, type_sub_type = ? " +
                                         "WHERE type_id = ?";

    private final static String DELETE = "DELETE FROM types " +
                                         "WHERE type_id = ?";

    // CONs
    public TypeDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Type create(Type dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getTypeName());
            statement.setString(2, dto.getTypeSubType());
            statement.execute();
            long id = this.getLastVal(TYPE_SEQUENCE);
            return this.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Type findById(long id) {
        Type type = new Type();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                type.setTypeId(rs.getLong("type_id"));
                type.setTypeName(rs.getString("type_name"));
                type.setTypeSubType(rs.getString("type_sub_type"));
            }

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return type;
    }

    @Override
    public List<Type> findAll() {
        List<Type> types = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Type type = new Type();

                type.setTypeId(rs.getLong("type_id"));
                type.setTypeName(rs.getString("type_name"));
                type.setTypeSubType(rs.getString("type_sub_type"));

                types.add(type);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return types;
    }

    @Override
    public Type update(Type dto) {
        Type type = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getTypeName());
            statement.setString(2, dto.getTypeSubType());
            statement.setLong(3, dto.getTypeId());
            statement.execute();

            type = this.findById(dto.getTypeId());
            System.out.println(type);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return type;
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
    public List<Type> findAllByName (String typeName) {
        List<Type> types = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_NAME);) {
            statement.setString(1, typeName);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Type type = new Type();
                type.setTypeId(rs.getLong("type_id"));
                type.setTypeName(rs.getString("type_name"));
                type.setTypeSubType(rs.getString("type_sub_type"));
                types.add(type);
            }

        } catch (SQLException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        }
        return types;
    }

    public Type findByNameAndSubType (String typeName, String typeSubType){
        Type type = new Type();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME_AND_SUB);){
            statement.setString(1, typeName);
            statement.setString(2, typeSubType);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                type.setTypeId(rs.getLong("type_id"));
                type.setTypeName(rs.getString("type_name"));
                type.setTypeSubType(rs.getString("type_sub_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return type;
    }
}
