package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Effect;
import com.backend.theWizardsBag.utils.DAOs.EffectDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EffectJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public Effect create(String effectName, String effectSubEffect){
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);
            Effect effect = new Effect();

            effect.setEffectName(effectName);
            effect.setEffectSubEffect(effectSubEffect);
            return effectDAO.create(effect);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Effect getById(long id){
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);
            return effectDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Effect> getAll (){
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);
            return effectDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Effect> getAllByName(String effectName) {
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);
            return effectDAO.findAllByName(effectName);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Effect getByNameAndSub(String effectName, String effectSubEffect) {
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);
            return effectDAO.findByNameAndSub(effectName, effectSubEffect);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Effect update(Effect effectNewData){
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);

            Effect effect = effectDAO.findById(effectNewData.getEffectId());

            effect.setEffectName(effectNewData.getEffectName());
            effect = effectDAO.update(effect);

            return effect;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try {
            Connection connection = this.dcm.getConnection();
            EffectDAO effectDAO = new EffectDAO(connection);
            Effect effectBeingDeleted = effectDAO.findById(id);
            effectDAO.delete(id);
            System.out.println("Deleted: " + effectBeingDeleted.getEffectName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
