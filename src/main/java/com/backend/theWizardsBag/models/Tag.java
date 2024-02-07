package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class Tag implements DataTransferObject {

    // ATTs
    private long tagID;
    private String tagName;
    private String tagType;

    // CONs

    // GETs & SETs
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

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagID=" + tagID +
                ", tagName='" + tagName + '\'' +
                ", tagType='" + tagType + '\'' +
                '}';
    }
}
