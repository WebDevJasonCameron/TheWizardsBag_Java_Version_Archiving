package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Condition;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConditionDAO extends DataAccessObject<Condition> {

    // SQLs
    private final static String INSERT = "INSERT INTO conditions " +
                                            "(condition_name, condition_description) " +
                                         "VALUES (?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM conditions " +
                                            "WHERE condition_id = ?";

    private final static String GET_ALL = "SELECT * FROM conditions";

    private final static String GET_BY_NAME = "SELECT * FROM conditions " +
                                              "WHERE LOWER(condition_name) = LOWER( ? )";

    private final static String UPDATE = "UPDATE conditions " +
                                         "SET condition_name = ?, condition_description = ? " +
                                         "WHERE condition_id = ?";

    private final static String DELETE = "DELETE FROM conditions " +
                                         "WHERE condition_id = ?";

    // CONs
    public ConditionDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Condition create(Condition dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getConditionName());
            statement.setString(2, dto.getConditionDescription());
            statement.execute();
            long id = this.getLastVal(CONDITION_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Condition findById(long id) {
        Condition condition = new Condition();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                condition.setConditionId(rs.getLong("condition_id"));
                condition.setConditionName(rs.getString("condition_name"));
                condition.setConditionDescription(rs.getString("condition_description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return condition;
    }

    @Override
    public List<Condition> findAll() {
        List<Condition> conditions = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Condition condition = new Condition();

                condition.setConditionId(rs.getLong("condition_id"));
                condition.setConditionName(rs.getString("condition_name"));
                condition.setConditionDescription(rs.getString("condition_description"));

                conditions.add(condition);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return conditions;
    }

    @Override
    public Condition update(Condition dto) {
        Condition condition = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getConditionName());
            statement.setString(2, dto.getConditionDescription());
            statement.setLong(3, dto.getConditionId());
            statement.execute();

            condition = this.findById(dto.getConditionId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return condition;
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
    public Condition findByName (String conditionName) {
        Condition condition = new Condition();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME);) {
            statement.setString(1, conditionName);
            statement.execute();
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                condition.setConditionId(rs.getLong("condition_id"));
                condition.setConditionName(rs.getString("condition_name"));
                condition.setConditionDescription(rs.getString("condition_description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return condition;
    }
}
