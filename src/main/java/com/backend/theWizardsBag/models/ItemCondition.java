package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class ItemCondition implements DataTransferObject {

    // ATTs
    private long itemConditionId;
    private String condition;

    // CONs


    // GETs & SETs
    public long getItemConditionId() {
        return itemConditionId;
    }
    public void setItemConditionId(long itemConditionId) {
        this.itemConditionId = itemConditionId;
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
        return "ItemCondition{" +
                "itemConditionId=" + itemConditionId +
                ", condition='" + condition + '\'' +
                '}';
    }

    // METHs


}
