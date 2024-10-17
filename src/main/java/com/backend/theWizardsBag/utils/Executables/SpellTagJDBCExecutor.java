package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.DAOs.SpellTagDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellTagJDBCExecutor {


    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public SpellTag create(long spellsSpellId, long tagsTagId){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            SpellTag spellTag = new SpellTag();

            spellTag.setSpellTagId(spellsSpellId);
            spellTag.setTagsTagId(tagsTagId);
            return spellTagDAO.create(spellTag);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellTag getById(long id){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            return spellTagDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellTag> getAll(){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            return spellTagDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellTag> getAllBySpellId(long spellId){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            return spellTagDAO.findAllBySpellId(spellId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<SpellTag> getAllByTagId(long tagId){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            return spellTagDAO.findAllByTagId(tagId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SpellTag update(SpellTag spellTagNewData){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);

            SpellTag spellTag = spellTagDAO.findById(spellTagNewData.getSpellTagId());

            spellTag.setSpellTagId(spellTagNewData.getSpellTagId());
            spellTag.setSpellsSpellId(spellTagNewData.getSpellsSpellId());
            spellTag.setTagsTagId(spellTagNewData.getTagsTagId());

            return spellTagDAO.update(spellTag);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        try (Connection connection = dcm.getConnection();){
            SpellTagDAO spellTagDAO = new SpellTagDAO(connection);
            SpellTag spellTag = spellTagDAO.findById(id);
            System.out.println("Deleted spell_tag with " + spellTag.getSpellTagId() + " id");
            spellTagDAO.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
