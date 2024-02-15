package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Source;
import com.backend.theWizardsBag.utils.DAOs.SourceDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class SourceJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public Source create(String sourceName, Date sourcePublishDate, String sourcePublisher, String sourceTTRPG){
        try {
            Connection connection = this.dcm.getConnection();
            SourceDAO sourceDAO = new SourceDAO(connection);
            Source source = new Source();

            source.setSourceName(sourceName);
            source.setSourcePublishDate(sourcePublishDate);
            source.setSourcePublisher(sourcePublisher);
            source.setSourceTTRPG(sourceTTRPG);
            return sourceDAO.create(source);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }





}
