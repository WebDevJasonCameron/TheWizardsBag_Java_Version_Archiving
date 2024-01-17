package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellTag implements DataTransferObject {

    // ATTs
    private long spellTagID;                          //   Junction ID
    private long tagID;
    private String tagName;
    private String tagType;

    // CONs


    // GETS & SETs
    public long getSpellTagID() {
        return spellTagID;
    }
    public void setSpellTagID(long spellTagID) {
        this.spellTagID = spellTagID;
    }

    public long getTagID() {
        return tagID;
    }
    public void setTagID(long tagID) {
        this.tagID = tagID;
    }

    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagType() {
        return tagType;
    }
    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellTag{" +
                "spellTagID=" + spellTagID +
                ", tagID=" + tagID +
                ", tagName='" + tagName + '\'' +
                ", tagType='" + tagType + '\'' +
                '}';
    }

// METHs
}
