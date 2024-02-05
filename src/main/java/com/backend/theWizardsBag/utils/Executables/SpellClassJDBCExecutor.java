package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.SpellClass;
import com.backend.theWizardsBag.utils.DAOs.SpellClassDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellClassJDBCExecutor {

    // GETs
    public static List<SpellClass> getAll() {
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        List<SpellClass> spellClasses = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            spellClasses = spellClassDAO.findAll();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellClasses;
    }

    public static SpellClass getById(long id) {
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        SpellClass spellClass = new SpellClass();

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            spellClass = spellClassDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellClass;
    }

    public static List<SpellClass> getAllByName(String className) {
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        List<SpellClass> spellClasses = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);
            spellClasses = spellClassDAO.findAllByName(className);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellClasses;
    }

    public static SpellClass getByNameAndSubName(String className, String classSubclassName) {
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        SpellClass spellClass = new SpellClass();

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            spellClass = spellClassDAO.findByNameAndSubName(className, classSubclassName);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return spellClass;
    }

    // GET BY SPELL
    public static List<SpellClass> getAllBySpellId(long spellId) {
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        List<SpellClass> spellClasses = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            spellClasses = spellClassDAO.findAllBySpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spellClasses;
    }

    // CREATE
    public static Long createSpellClass(String className, String classSubClassName, String classDescription){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            // Used to create a new spell class entry in the db
            SpellClass spellClass = new SpellClass();

            spellClass.setClassName(className);
            spellClass.setClassSubClassName(classSubClassName);
            spellClass.setClassDescription(classDescription);

            spellClassDAO.create(spellClass);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return null;
    }

    // DELETE
    public static void deleteByIdSpellClass(long spellId){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            SpellClassDAO spellClassDAO = new SpellClassDAO(connection);

            SpellClass spellClassBeingDelete = spellClassDAO.findById(spellId);
            spellClassDAO.delete(spellId);
            System.out.println("Deleted: " + spellClassBeingDelete.getClassName());


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
