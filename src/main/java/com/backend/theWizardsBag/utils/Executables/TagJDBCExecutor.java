package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.DAOs.TagDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TagJDBCExecutor {

    public Tag getById(long id){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        Tag tag = new Tag();

        try {
            Connection connection = dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            tag = tagDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tag;

    }



}
