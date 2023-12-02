package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellAccessible implements DataTransferObject {

    // ATTs
    private long spellAccessibleId;
    private String spellAccessibleName;

    // CONs


    // GETs & SETs
    public long getSpellAccessibleId() {
        return spellAccessibleId;
    }
    public void setSpellAccessibleId(long spellAccessibleId) {
        this.spellAccessibleId = spellAccessibleId;
    }

    public String getSpellAccessibleName() {
        return spellAccessibleName;
    }
    public void setSpellAccessibleName(String spellAccessibleName) {
        this.spellAccessibleName = spellAccessibleName;
    }


    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "RPGAccessible{" +
                "spellAccessibleId=" + spellAccessibleId +
                ", spellAccessibleName='" + spellAccessibleName + '\'' +
                '}';
    }

    // METHs
}
