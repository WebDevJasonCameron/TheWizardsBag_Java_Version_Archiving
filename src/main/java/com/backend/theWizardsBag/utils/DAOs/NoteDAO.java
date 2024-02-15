package com.backend.theWizardsBag.utils.DAOs;

import com.backend.theWizardsBag.models.Note;
import com.backend.theWizardsBag.utils.Objects.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO extends DataAccessObject<Note> {

    // SQLs
    private final static String INSERT = "INSERT INTO notes " +
            "(note_name, note_date, note_content, note_author) " +
            "VALUES (?, ?, ?, ?)";

    private final static String GET_BY_ID = "SELECT * FROM notes " +
            "WHERE note_id = ? ";

    private final static String GET_ALL = "SELECT * FROM notes ";

    private final static String GET_ALL_BY_AUTHOR = "SELECT * FROM notes " +
            "WHERE LOWER(note_author) = LOWER( ? )";

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
    public Note create(Note dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1, dto.getNoteName());
            statement.setDate(2, dto.getNoteDate());
            statement.setString(3, dto.getNoteContent());
            statement.setString(4, dto.getNoteAuthor());
            statement.execute();
            long id = this.getLastVal(NOTE_SEQUENCE);
            return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Note findById(long id) {
        Note note = new Note();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);){
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                note.setNoteId(rs.getLong("note_id"));
                note.setNoteName(rs.getString("note_name"));
                note.setNoteDate(rs.getDate("note_date"));
                note.setNoteContent(rs.getString("note_content"));
                note.setNoteAuthor(rs.getString("note_author"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return note;    }

    @Override
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();

        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Note note = new Note();

                note.setNoteId(rs.getLong("note_id"));
                note.setNoteName(rs.getString("note_name"));
                note.setNoteDate(rs.getDate("note_date"));
                note.setNoteContent(rs.getString("note_content"));
                note.setNoteAuthor(rs.getString("note_author"));

                notes.add(note);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return notes;    }

    @Override
    public Note update(Note dto) {
        Note note = null;

        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getNoteName());
            statement.setDate(2, dto.getNoteDate());
            statement.setString(3, dto.getNoteContent());
            statement.setString(4, dto.getNoteAuthor());
            statement.setLong(5, dto.getNoteId());
            statement.execute();

            note = this.findById(dto.getNoteId());

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return note;
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
    public List<Note> findAllByAuthor(String noteAuthor) {
        List<Note> notes = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_BY_AUTHOR);){
            statement.setString(1, noteAuthor);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Note note = new Note();

                note.setNoteId(rs.getLong("note_id"));
                note.setNoteName(rs.getString("note_name"));
                note.setNoteDate(rs.getDate("note_date"));
                note.setNoteContent(rs.getString("note_content"));
                note.setNoteAuthor(rs.getString("note_author"));

                notes.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return notes;
    }
}
