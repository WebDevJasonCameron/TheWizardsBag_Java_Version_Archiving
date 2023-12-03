package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellCondition implements DataTransferObject {

    // ATTs
    private long spellConditionId;
    private String condition;

    // CONs

    // GETs & SETs
    public long getSpellConditionId() {
        return spellConditionId;
    }
    public void setSpellConditionId(long spellConditionId) {
        this.spellConditionId = spellConditionId;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellCondition{" +
                "spellConditionId=" + spellConditionId +
                ", condition='" + condition + '\'' +
                '}';
    }

    // METHs
}
