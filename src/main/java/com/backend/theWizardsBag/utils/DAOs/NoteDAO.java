package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Note;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.util.List;

public class NoteDAO extends DataAccessObject<Note> {

    // SQLs
    private final static String INSERT = "INSERT INTO notes " +
            "(note_name, note_date, note_content, note_author) " +
            "VALUES (?, ?, ?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM notes " +
            "WHERE note_id = ? ";

    private final static String GET_ALL = "SELECT * FROM notes ";

    private final static String UPDATE = "UPDATE notes " +
            "SET note_name = ?, note_date = ?, note_content = ?, note_author = ? " +
            "WHERE note_id = ? ";

    private final static String DELETE = "DELETE FROM notes " +
            "WHERE note_id = ? ";


    // CONs
    public NoteDAO(Connection connection) {
        super(connection);
    }

    // OVRs
    @Override
    public Note findById(long id) {
        return null;
    }

    @Override
    public List<Note> findAll() {
        return null;
    }

    @Override
    public Note update(Note dto) {
        return null;
    }

    @Override
    public Note create(Note dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    // MTHs

}
