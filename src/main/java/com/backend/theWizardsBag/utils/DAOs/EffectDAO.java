package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Effect;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EffectDAO extends DataAccessObject<Effect> {

    // SQLs
    private final static String INSERT = "INSERT INTO effects " +
            "(effect_name, effect_sub_effect) " +
            "VALUES (?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM effects " +
            "WHERE effect_id = ? ";

    private final static String GET_ALL = "SELECT * FROM effects ";

    private final static String GET_ALL_BY_NAME = "SELECT * FROM effects " +
            "WHERE LOWER(effect_name) = LOWER( ? ) ";

    private final static String GET_BY_NAME_AND_SUB = "SELECT * FROM effects " +
            "WHERE LOWER(effect_name) = LOWER( ? ) " +
            "AND LOWER(effect_sub_effect) = LOWER( ? ) ";

    private final static String UPDATE = "UPDATE effects " +
            "SET effect_name = ?, effect_sub_effect = ? " +
            "WHERE effect_id = ? ";

    private final static String DELETE = "DELETE FROM effects " +
            "WHERE effect_id = ? ";


    // CONs
    public EffectDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Effect create(Effect dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getEffectName());
            statement.setString(2, dto.getEffectSubEffect());
            statement.execute();
            long id = this.getLastVal(DAMAGETYPE_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Effect findById(long id) {
        Effect effect = new Effect();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                effect.setEffectId(rs.getLong("effect_id"));
                effect.setEffectName(rs.getString("effect_name"));
                effect.setEffectSubEffect(rs.getString("effect_sub_effect"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return effect;
    }

    @Override
    public List<Effect> findAll() {
        List<Effect> effects = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Effect effect = new Effect();

                effect.setEffectId(rs.getLong("effect_id"));
                effect.setEffectName(rs.getString("effect_name"));
                effect.setEffectSubEffect(rs.getString("effect_sub_effect"));

                effects.add(effect);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return effects;
    }

    @Override
    public Effect update(Effect dto) {
        Effect effect = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getEffectName());
            statement.setString(2, dto.getEffectSubEffect());
            statement.setLong(3, dto.getEffectId());
            statement.execute();

            effect = this.findById(dto.getEffectId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return effect;    }

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
    public List<Effect> findAllByName(String effectName) {
        List<Effect> effects = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_NAME);){
            statement.setString(1, effectName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Effect effect = new Effect();

                effect.setEffectId(rs.getLong("effect_id"));
                effect.setEffectName(rs.getString("effect_name"));
                effect.setEffectSubEffect(rs.getString("effect_sub_effect"));

                effects.add(effect);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return effects;
    }

    public Effect findByNameAndSub(String effectName, String effectSubEffect) {
        Effect effect = new Effect();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_NAME_AND_SUB);){
            statement.setString(1, effectName);
            statement.setString(2, effectSubEffect);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                effect.setEffectId(rs.getLong("effect_id"));
                effect.setEffectName(rs.getString("effect_name"));
                effect.setEffectSubEffect(rs.getString("effect_sub_effect"));

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return effect;
    }
}
