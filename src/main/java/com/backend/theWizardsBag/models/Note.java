package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.sql.Date;


public class Note implements DataTransferObject {

    // ATTs
    private long noteId;
    private String noteName;
    private Date noteDate;
    private String noteContent;
    private String noteAuthor;

    // CONs
    public Note() {
    }

    public Note(long noteId, String noteName, Date noteDate, String noteContent, String noteAuthor) {
        this.noteId = noteId;
        this.noteName = noteName;
        this.noteDate = noteDate;
        this.noteContent = noteContent;
        this.noteAuthor = noteAuthor;
    }

    // GETs & SETs
    public long getNoteId() {
        return noteId;
    }
    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getNoteName() {
        return noteName;
    }
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public Date getNoteDate() {
        return noteDate;
    }
    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteAuthor() {
        return noteAuthor;
    }
    public void setNoteAuthor(String noteAuthor) {
        this.noteAuthor = noteAuthor;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteName='" + noteName + '\'' +
                ", noteDate=" + noteDate +
                ", noteContent='" + noteContent + '\'' +
                ", noteAuthor='" + noteAuthor + '\'' +
                '}';
    }
}
