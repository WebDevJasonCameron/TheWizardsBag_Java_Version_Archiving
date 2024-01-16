package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellTag implements DataTransferObject {

    // ATTs
    private long spellTagId;
    private String tagName;
    private String tagType;

    // CONs


    // GETS & SETs
    public long getSpellTagId() {
        return spellTagId;
    }
    public void setSpellTagId(long spellTagId) {
        this.spellTagId = spellTagId;
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
                "spellTagId=" + spellTagId +
                ", tagName='" + tagName + '\'' +
                ", tagType='" + tagType + '\'' +
                '}';
    }

// METHs
}
