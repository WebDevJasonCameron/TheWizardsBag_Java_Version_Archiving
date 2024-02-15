package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Source;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Source source = new Source();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                source.setSourceId(rs.getLong("source_id"));
                source.setSourceName(rs.getString("source_name"));
                source.setSourcePublishDate(rs.getDate("source_publish_date"));
                source.setSourcePublisher(rs.getString("source_publisher"));
                source.setSourceTTRPG(rs.getString("source_ttrpg"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return source;
    }

    @Override
    public List<Source> findAll() {
        List<Source> sources = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Source source = new Source();

                source.setSourceId(rs.getLong("source_id"));
                source.setSourceName(rs.getString("source_name"));
                source.setSourcePublishDate(rs.getDate("source_publish_date"));
                source.setSourcePublisher(rs.getString("source_publisher"));
                source.setSourceTTRPG(rs.getString("source_ttrpg"));

                sources.add(source);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sources;      }

    @Override
    public Source update(Source dto) {
        Source source = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getSourceName());
            statement.setDate(2, dto.getSourcePublishDate());
            statement.setString(3, dto.getSourcePublisher());
            statement.setString(4, dto.getSourceTTRPG());
            statement.setLong(5, dto.getSourceId());
            statement.execute();

            source = this.findById(dto.getSourceId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return source;
    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // MTHs
    public List<Source> findAllByTTRPG (String ttrpg){
        List<Source> sources = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_TTRPG);){
            statement.setString(1, ttrpg);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Source source = new Source();

                source.setSourceId(rs.getLong("source_id"));
                source.setSourceName(rs.getString("source_name"));
                source.setSourcePublishDate(rs.getDate("source_publish_date"));
                source.setSourcePublisher(rs.getString("source_publisher"));
                source.setSourceTTRPG(rs.getString("source_ttrpg"));

                sources.add(source);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return sources;    }

}
