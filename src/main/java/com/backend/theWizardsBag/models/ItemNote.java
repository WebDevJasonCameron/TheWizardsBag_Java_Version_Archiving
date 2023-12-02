package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class ItemNote implements DataTransferObject {

    // ATTs
    private long itemNoteId;
    private String date;
    private String note;
    private int authorId;       //   User Id

    // CONs


    // GETs & SETs
    public long getItemNoteId() {
        return itemNoteId;
    }
    public void setItemNoteId(long itemNoteId) {
        this.itemNoteId = itemNoteId;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "ItemNote{" +
                "itemNoteId=" + itemNoteId +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                ", authorId=" + authorId +
                '}';
    }

    // METHs


}
