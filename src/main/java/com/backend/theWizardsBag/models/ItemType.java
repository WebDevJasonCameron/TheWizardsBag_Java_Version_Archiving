package com.backend.theWizardsBag.models;

import java.util.Dictionary;

public class ItemType {

    // ATTs
    private int typeId;
    private String type;
    private String subType;
    private Dictionary<String, String> itemType;

    // CONs
    public ItemType() {
    }
    public ItemType(String type, String subType) {
        this.type = type;
        this.subType = subType;
        this.itemType.put(this.type, this.subType);
    }

    // GETs
    public int getItemTypeID(){return typeId; }
    public String getType() {
        return type;
    }
    public String getSubType() {
        return subType;
    }
    public Dictionary<String, String> getItemType() {
        return itemType;
    }

    // SETs
    public void setType(String type) {
        this.type = type;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }
    public void setItemType(String type, String subType){
        setType(type);
        setSubType(subType);
        this.itemType.put(type, subType);
    }

    // OVRs
    @Override
    public String toString() {
        return "ItemType{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", itemType=" + itemType +
                '}';
    }


    // METHs


}
