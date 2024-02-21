package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class Tag implements DataTransferObject {

    // ATTs
    private long tagId;
    private String tagName;
    private String tagType;

    // CONs
    public Tag() {
    }

    public Tag(long tagId, String tagName, String tagType) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagType = tagType;
    }

    // GETs & SETs
    public long getTagId() {
        return tagId;
    }
    public void setTagId(long tagId) {
        this.tagId = tagId;
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
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", tagType='" + tagType + '\'' +
                '}';
    }
}
