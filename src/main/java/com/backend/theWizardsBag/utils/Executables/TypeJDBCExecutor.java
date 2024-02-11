package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Type;
import com.backend.theWizardsBag.utils.DAOs.TypeDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TypeJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public Type create(String typeName, String typeSubType) {

        try {
            Connection connection = this.dcm.getConnection();
            TypeDAO typeDAO = new TypeDAO(connection);
            Type type = new Type();

            type.setTypeName(typeName);
            type.setTypeSubType(typeSubType);

            return typeDAO.create(type);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Type getById(long id) {
        Type type = new Type();
        try {
            Connection connection = this.dcm.getConnection();
            TypeDAO typeDAO = new TypeDAO(connection);
            type = typeDAO.findById(id);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return type;
    }

    public Type update(Type typeNewData) {
        try {
            Connection connection = this.dcm.getConnection();
            TypeDAO typeDAO = new TypeDAO(connection);

            Type type = typeDAO.findById(typeNewData.getTypeId());
            System.out.println(type.getTypeName() + " - " + type.getTypeSubType());   // <R> remove after test

            type.setTypeName(typeNewData.getTypeName());
            type.setTypeSubType(typeNewData.getTypeSubType());
            type = typeDAO.update(type);

            System.out.println(type.getTypeName() + " - " + type.getTypeSubType());   // <R> remove after test

            return type;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void delete(long id) {
        try {
            Connection connection = this.dcm.getConnection();
            TypeDAO typeDAO = new TypeDAO(connection);
            Type typeBeingDeleted = typeDAO.findById(id);
            typeDAO.delete(id);
            System.out.println("Deleted: " + typeBeingDeleted.getTypeName());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
