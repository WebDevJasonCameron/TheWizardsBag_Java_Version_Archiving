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

    // ATTs
    final Keys jdbcKey = new Keys();
    final String password = jdbcKey.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);


    // MTHs
    public Tag create(String tagName, String tagType){
        try {
            Connection connection = this.dcm.getConnection();
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

    public Tag getById(long id){
        Tag tag = new Tag();
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            tag = tagDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tag;

    }

    public Tag getByName(String name){
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);

            return tagDAO.findByName(name);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Tag> getAll(){
        List<Tag> tags = new ArrayList<>();

        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            tags =  tagDAO.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }

    public Tag update(Tag tagNewData){
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);

            Tag tag = tagDAO.findById(tagNewData.getTagId());
            System.out.println(tag.getTagName() + " - " + tag.getTagType() );   // <R> remove after test

            tag.setTagName(tagNewData.getTagName());
            tag.setTagType(tagNewData.getTagType());
            tag = tagDAO.update(tag);

            System.out.println(tag.getTagName() + " - " + tag.getTagType() );   // <R> remove after test

            return tag;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("TagJDBCExecutor error: " + e);
        }

    }

    public void delete(long id){
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            Tag tagBeingDeleted = tagDAO.findById(id);
            tagDAO.delete(id);
            System.out.println("Deleted: " + tagBeingDeleted.getTagName());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    // SPELL MTHs
    public List<Tag> getAllBySpell (long spellId){
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            return tagDAO.findAllBySpellId(spellId);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Tag> getAllByTagType (String tagType){
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            return tagDAO.findAllByTagType(tagType);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Tag> getAllByTagTypes (String tagType1, String tagType2){
        try {
            Connection connection = this.dcm.getConnection();
            TagDAO tagDAO = new TagDAO(connection);
            return tagDAO.findAllByTagTypes(tagType1, tagType2);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
