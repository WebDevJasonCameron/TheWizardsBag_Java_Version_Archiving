package com.backend.theWizardsBag.models;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.sun.tools.javac.util.Pair;

public class ItemType {

    // ATTs
    private String type;
    private String subType;
    private Pair<String, String> itemType;

    // CONs
    public ItemType() {
    }
    public ItemType(String type, String subType) {
        this.type = type;
        this.subType = subType;
        this.itemType = new Pair<>(this.type, this.subType);
    }

    // GETs
    public String getType() {
        return type;
    }
    public String getSubType() {
        return subType;
    }
    public Pair<String, String> getItemType() {
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
        this.itemType = new Pair<>(type, subType);
    }

    // OVRs
    @Override
    public String toString() {
        return "ItemType{" +
                "type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", itemType=" + itemType +
                '}';
    }

    // METHs


}
