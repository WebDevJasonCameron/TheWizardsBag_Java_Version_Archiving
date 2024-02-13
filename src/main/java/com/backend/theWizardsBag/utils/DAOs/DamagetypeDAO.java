package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Damagetype;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DamagetypeDAO extends DataAccessObject<Damagetype> {

    // SQLs
    private final static String INSERT = "INSERT INTO damagetypes " +
            "(damagetype_name) " +
            "VALUES (?)";

    private final static String GET_BY_ID = "SELECT * FROM damagetypes " +
            "WHERE damagetype_id = ?";

    private final static String GET_ALL = "SELECT * FROM damagetypes ";

    private final static String GET_BY_NAME = "SELECT * FROM damagetypes " +
            "WHERE LOWER(damagetype_name) = LOWER( ? )";

    private final static String UPDATE = "UPDATE damagetypes " +
            "SET damagetype_name = ? " +
            "WHERE damagetype_id = ?";

    private final static String DELETE = "DELETE FROM damagetypes " +
            "WHERE damagetype_id = ?";

    // CONs
    public DamagetypeDAO(Connection connection) {
        super(connection);
    }


    // OVRs
    @Override
    public Damagetype create(Damagetype dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getDamagetypeName());
            statement.execute();
            long id = this.getLastVal(DAMAGETYPE_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Damagetype findById(long id) {
        Damagetype damagetype = new Damagetype();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                damagetype.setDamagetypeId(rs.getLong("damagetype_id"));
                damagetype.setDamagetypeName(rs.getString("damagetype_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return damagetype;
    }

    @Override
    public List<Damagetype> findAll() {
        List<Damagetype> damagetypes = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Damagetype damagetype = new Damagetype();

                damagetype.setDamagetypeId(rs.getLong("damagetype_id"));
                damagetype.setDamagetypeName(rs.getString("damagetype_name"));

                damagetypes.add(damagetype);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return damagetypes;
    }

    @Override
    public Damagetype update(Damagetype dto) {
        Damagetype damagetype = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getDamagetypeName());
            statement.setLong(2, dto.getDamagetypeId());
            statement.execute();

            damagetype = this.findById(dto.getDamagetypeId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return damagetype;
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
    public Damagetype findByName (String damagetypeName) {
        Damagetype damagetype = new Damagetype();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME);) {
            statement.setString(1, damagetypeName);
            statement.execute();
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                damagetype.setDamagetypeId(rs.getLong("damagetype_id"));
                damagetype.setDamagetypeName(rs.getString("damagetype_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return damagetype;
    }

}
