package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Source;
import com.backend.theWizardsBag.utils.DAOs.SourceDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

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

    public Source getById(long id){
        try {
            Connection connection = this.dcm.getConnection();
            SourceDAO sourceDAO = new SourceDAO(connection);
            return sourceDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Source> getAll (){
        try {
            Connection connection = this.dcm.getConnection();
            SourceDAO sourceDAO = new SourceDAO(connection);
            return sourceDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Source> getAllByTTRPG (String sourceTTRPG){
        try {
            Connection connection = this.dcm.getConnection();
            SourceDAO sourceDAO = new SourceDAO(connection);
            return sourceDAO.findAllByTTRPG(sourceTTRPG);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public Source update(Source sourceNewData){
        try {
            Connection connection = this.dcm.getConnection();
            SourceDAO sourceDAO = new SourceDAO(connection);

            Source source = sourceDAO.findById(sourceNewData.getSourceId());

            source.setSourceName(sourceNewData.getSourceName());
            source.setSourcePublishDate(sourceNewData.getSourcePublishDate());
            source.setSourcePublisher(sourceNewData.getSourcePublisher());
            source.setSourceTTRPG(sourceNewData.getSourceTTRPG());
            source = sourceDAO.update(source);

            return source;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try {
            Connection connection = this.dcm.getConnection();
            SourceDAO sourceDAO = new SourceDAO(connection);
            Source sourceBeingDeleted = sourceDAO.findById(id);
            sourceDAO.delete(id);
            System.out.println("Deleted: " + sourceBeingDeleted.getSourceName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
