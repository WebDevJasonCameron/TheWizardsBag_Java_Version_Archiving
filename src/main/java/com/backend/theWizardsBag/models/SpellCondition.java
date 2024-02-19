package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellCondition implements DataTransferObject {

    // ATTs
    private long spellConditionId;
    private long spellsSpellId;
    private long conditionsConditionId;

    // CONs
    public SpellCondition() {
    }

    public SpellCondition(long spellsSpellId, long conditionsConditionId) {
        this.spellsSpellId = spellsSpellId;
        this.conditionsConditionId = conditionsConditionId;
    }

    public SpellCondition(long spellConditionId, long spellsSpellId, long conditionsConditionId) {
        this.spellConditionId = spellConditionId;
        this.spellsSpellId = spellsSpellId;
        this.conditionsConditionId = conditionsConditionId;
    }


    // GETs & SETs
    public long getSpellConditionId() {
        return spellConditionId;
    }
    public void setSpellConditionId(long spellConditionId) {
        this.spellConditionId = spellConditionId;
    }

    public long getSpellsSpellId() {
        return spellsSpellId;
    }
    public void setSpellsSpellId(long spellsSpellId) {
        this.spellsSpellId = spellsSpellId;
    }

    public long getConditionsConditionId() {
        return conditionsConditionId;
    }
    public void setConditionsConditionId(long conditionsConditionId) {
        this.conditionsConditionId = conditionsConditionId;
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
                ", spellsSpellId=" + spellsSpellId +
                ", conditionsConditionId=" + conditionsConditionId +
                '}';
    }
}
