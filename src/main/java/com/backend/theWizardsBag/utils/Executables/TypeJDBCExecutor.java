package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Type;
import com.backend.theWizardsBag.utils.DAOs.TypeDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TypeJDBCExecutor {

    public Type getById(long id) {
        Keys keys = new Keys();
        String password = keys.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        Type type = new Type();

        try {
            Connection connection = dcm.getConnection();
            TypeDAO typeDAO = new TypeDAO(connection);
            type = typeDAO.findById(id);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return type;
    }

    public Type create(String typeName, String typeSubType) {
        Keys keys = new Keys();
        String password = keys.jdbcPassword();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        try {
            Connection connection = dcm.getConnection();
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
}
