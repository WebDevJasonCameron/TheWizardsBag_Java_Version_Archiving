package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellCondition implements DataTransferObject {

    // ATTs
    private long conditionID;
    private String conditionName;
    private String conditionDescription;

    // CONs

    // GETs & SETs
    public long getConditionID() {
        return conditionID;
    }
    public void setConditionID(long conditionID) {
        this.conditionID = conditionID;
    }

    public String getConditionName() {
        return conditionName;
    }
    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }
    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellCondition{" +
                "conditionID=" + conditionID +
                ", conditionName='" + conditionName + '\'' +
                ", conditionDescription='" + conditionDescription + '\'' +
                '}';
    }

// METHs
}
