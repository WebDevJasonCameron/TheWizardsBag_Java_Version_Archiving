package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.RpgClass;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RpgClassDAO extends DataAccessObject<RpgClass> {

    // SQLs
    private final static String INSERT = "INSERT INTO rpg_classes " +
            "(class_name, class_subclass_name, class_description) " +
            "VALUES (?, ?, ?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM rpg_classes " +
            "WHERE class_id = ? ";

    private final static String GET_ALL = "SELECT * FROM rpg_classes ";

    private final static String GET_ALL_BY_NAME = "SELECT * FROM rpg_classes " +
            "WHERE LOWER(class_name) = LOWER( ? )";

    private final static String GET_BY_NAME_AND_SUB = "SELECT * FROM rpg_class " +
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
        return null;
    }

    @Override
    public List<RpgClass> findAll() {
        return null;
    }

    @Override
    public RpgClass update(RpgClass dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    // MTHs



}
