package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

public class RpgClassJDBCExecutor {


    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs





}
