package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Source;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SourceDAO extends DataAccessObject<Source> {

    // SQLs
    private final static String INSERT = "INSERT INTO sources " +
            "(source_name, source_publish_date, source_publisher, source_ttrpg) " +
            "VALUES (?, ?, ?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM sources " +
            "WHERE source_id = ? ";

    private final static String GET_ALL = "SELECT * FROM sources ";

    private final static String GET_ALL_BY_TTRPG = "SELECT * FROM sources " +
            "WHERE LOWER(source_ttrpg) = LOWER( ? )";

    private final static String UPDATE = "UPDATE sources " +
            "SET source_name = ?, source_publish_date = ?, source_publisher = ?, source_ttrpg = ? " +
            "WHERE source_id = ? ";

    private final static String DELETE = "DELETE FROM sources " +
            "WHERE source_id = ? ";

    // CONs
    public SourceDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Source create(Source dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getSourceName());
            statement.setDate(2, dto.getSourcePublishDate());
            statement.setString(3, dto.getSourcePublisher());
            statement.setString(4, dto.getSourceTTRPG());
            statement.execute();
            long id = this.getLastVal(SOURCE_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Source findById(long id) {
        return null;
    }

    @Override
    public List<Source> findAll() {
        return null;
    }

    @Override
    public Source update(Source dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    // MTHs
    public List<Source> findByTTRPG (String ttrpg){
        return null;
    }

}
