package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class Condition implements DataTransferObject {

    // ATTs
    private long conditionId;
    private String conditionName;
    private String conditionDescription;

    // CONs
    public Condition() {
    }

    public Condition(long conditionId, String conditionName, String conditionDescription) {
        this.conditionId = conditionId;
        this.conditionName = conditionName;
        this.conditionDescription = conditionDescription;
    }

    // GETs & SETs
    public long getConditionId() {
        return conditionId;
    }
    public void setConditionId(long conditionId) {
        this.conditionId = conditionId;
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
        return "Condition{" +
                "conditionId=" + conditionId +
                ", conditionName='" + conditionName + '\'' +
                ", conditionDescription='" + conditionDescription + '\'' +
                '}';
    }
}
