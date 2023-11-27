package com.backend.theWizardsBag.executors;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor_test {

    public static void main(String[] args) {

        // VARs
        Keys jdbcKey = new Keys();
        String password = jdbcKey.jdbcPassword();

        // METHs
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            //  TEST READ SPELL FROM HERE

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
