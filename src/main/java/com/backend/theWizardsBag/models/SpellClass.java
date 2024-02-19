package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellClass implements DataTransferObject {

    // ATTs
    private long spellClassId;
    private long classesClassId;
    private long spellsSpellId;

    // CONs
    public SpellClass() {
    }

    public SpellClass(long classesClassId, long spellsSpellId) {
        this.classesClassId = classesClassId;
        this.spellsSpellId = spellsSpellId;
    }

    public SpellClass(long spellClassId, long classesClassId, long spellsSpellId) {
        this.spellClassId = spellClassId;
        this.classesClassId = classesClassId;
        this.spellsSpellId = spellsSpellId;
    }

    // GETs & SETs
    public long getSpellClassId() {
        return spellClassId;
    }
    public void setSpellClassId(long spellClassId) {
        this.spellClassId = spellClassId;
    }

    public long getClassesClassId() {
        return classesClassId;
    }
    public void setClassesClassId(long classesClassId) {
        this.classesClassId = classesClassId;
    }

    public long getSpellsSpellId() {
        return spellsSpellId;
    }
    public void setSpellsSpellId(long spellsSpellId) {
        this.spellsSpellId = spellsSpellId;
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
                ", classesClassId=" + classesClassId +
                ", spellsSpellId=" + spellsSpellId +
                '}';
    }

// METHs
}
