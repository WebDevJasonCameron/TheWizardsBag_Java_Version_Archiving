package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Type;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.*;
import java.util.List;

public class TypeDAO extends DataAccessObject<Type> {

    // SQLs
    private final static String INSERT = "INSERT INTO types " +
                                            "(type_name, type_sub_type)" +
                                         "VALUES (?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM types " +
                                            "WHERE type_id=?";

    // CONs


    // OVRs
    public TypeDAO(Connection connection) {
        super(connection);
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
        return null;
    }

    @Override
    public Type update(Type dto) {
        return null;
    }

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
    public void delete(long id) {

    }

    // MTHs
}
