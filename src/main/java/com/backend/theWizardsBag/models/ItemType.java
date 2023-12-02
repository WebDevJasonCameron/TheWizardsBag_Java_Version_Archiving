package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class ItemType implements DataTransferObject {

    // ATTs
    private long itemTypeJunctionId;
    private long itemTypeId;
    private String type;
    private String subType;

    // CONs

    // GETs & SETs
    public long getItemTypeJunctionId() {
        return itemTypeJunctionId;
    }
    public void setItemTypeJunctionId(long itemTypeJunctionId) {
        this.itemTypeJunctionId = itemTypeJunctionId;
    }

    public long getItemTypeId() {
        return itemTypeId;
    }
    public void setItemTypeId(long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "itemTypeId=" + itemTypeId +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                '}';
    }


    // METHs


}
