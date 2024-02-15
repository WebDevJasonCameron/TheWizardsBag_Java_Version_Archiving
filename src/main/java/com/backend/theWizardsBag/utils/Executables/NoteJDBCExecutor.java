package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Note;
import com.backend.theWizardsBag.utils.DAOs.NoteDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NoteJDBCExecutor {

    // ATTs
    final Keys keys = new Keys();
    final String password = keys.jdbcPassword();
    final DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "the_wizards_db", "postgres", password);

    // MTHs
    public Note create(String noteName, Date noteDate, String noteContent, String noteAuthor){
        try {
            Connection connection = this.dcm.getConnection();
            NoteDAO noteDAO = new NoteDAO(connection);
            Note note = new Note();

            note.setNoteName(noteName);
            note.setNoteDate(noteDate);
            note.setNoteContent(noteContent);
            note.setNoteAuthor(noteAuthor);
            return noteDAO.create(note);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Note getById(long id){
        try {
            Connection connection = this.dcm.getConnection();
            NoteDAO noteDAO = new NoteDAO(connection);
            return noteDAO.findById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Note> getAll (){
        try {
            Connection connection = this.dcm.getConnection();
            NoteDAO noteDAO = new NoteDAO(connection);
            return noteDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Note> getAllByAuthor (String noteAuthor){
        try {
            Connection connection = this.dcm.getConnection();
            NoteDAO noteDAO = new NoteDAO(connection);
            return noteDAO.findAllByAuthor(noteAuthor);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Note update(Note noteNewData){
        try {
            Connection connection = this.dcm.getConnection();
            NoteDAO noteDAO = new NoteDAO(connection);

            Note note = noteDAO.findById(noteNewData.getNoteId());

            note.setNoteName(noteNewData.getNoteName());
            note.setNoteDate(noteNewData.getNoteDate());
            note.setNoteContent(noteNewData.getNoteContent());
            note.setNoteAuthor(noteNewData.getNoteAuthor());
            note = noteDAO.update(note);

            return note;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try {
            Connection connection = this.dcm.getConnection();
            NoteDAO noteDAO = new NoteDAO(connection);
            Note noteBeingDeleted = noteDAO.findById(id);
            noteDAO.delete(id);
            System.out.println("Deleted: " + noteBeingDeleted.getNoteName());  // <R> Delete after test

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
