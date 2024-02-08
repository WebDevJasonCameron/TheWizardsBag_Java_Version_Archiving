package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.DAOs.TagDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagJDBCExecutor {

    public Tag getById(long id){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        Tag tag = new Tag();

        try {
            Connection connection = dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            tag = tagDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tag;

    }

    public Tag getByName(String name){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        Tag tag = new Tag();

        try {
            Connection connection = dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);

            tag = tagDAO.findByName(name);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return tag;
    }

    public List<Tag> getAll(){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db",  "postgres", password);

        List<Tag> tags = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            tags =  tagDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }

    public Tag create(String tagName, String tagType){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            Tag tag = new Tag();

            tag.setTagName(tagName);
            tag.setTagType(tagType);

            return tagDAO.create(tag);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        final Keys jdbcKey = new Keys();
        final String password = jdbcKey.jdbcPassword();
        final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

        try {
            Connection connection = dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            Tag tagBeingDeleted = tagDAO.findById(id);
            tagDAO.delete(id);
            System.out.println("Deleted: " + tagBeingDeleted.getTagName());


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
