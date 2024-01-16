package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellClass implements DataTransferObject {

    // ATTs
    private long spellClassId;
    private String spellClassName;
    private  String spellSubClassName;
    private String spellDescription;

    // CONs


    // GETs & SETs
    public long getSpellClassId() {
        return spellClassId;
    }
    public void setSpellClassId(long spellClassId) {
        this.spellClassId = spellClassId;
    }

    public String getSpellClassName() {
        return spellClassName;
    }
    public void setSpellClassName(String spellClassName) {
        this.spellClassName = spellClassName;
    }

    public String getSpellSubClassName() {
        return spellSubClassName;
    }
    public void setSpellSubClassName(String spellSubClassName) {
        this.spellSubClassName = spellSubClassName;
    }

    public String getSpellDescription() {
        return spellDescription;
    }
    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellClass{" +
                "spellClassId=" + spellClassId +
                ", spellClassName='" + spellClassName + '\'' +
                ", spellSubClassName='" + spellSubClassName + '\'' +
                ", spellDescription='" + spellDescription + '\'' +
                '}';
    }

// METHs
}
