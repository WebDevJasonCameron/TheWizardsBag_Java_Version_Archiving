package com.backend.theWizardsBag.utils.Executables;

import com.backend.theWizardsBag.constants.keys.Keys;
import com.backend.theWizardsBag.models.Note;
import com.backend.theWizardsBag.utils.DAOs.NoteDAO;
import com.backend.theWizardsBag.utils.Managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

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




}
