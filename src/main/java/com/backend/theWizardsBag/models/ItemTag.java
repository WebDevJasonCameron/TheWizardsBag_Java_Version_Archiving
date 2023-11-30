package com.backend.theWizardsBag.models;

public class ItemTag {

    // ATTs
    private long tagId;
    private String tag;

    // CONs
    public ItemTag() {
    }
    public ItemTag(String tag) {
        this.tag = tag;
    }

    // GETs
    public long getTagId() {
        return tagId;
    }
    public String getTag() {
        return tag;
    }

    // SETs
    public void setTag(String tag) {
        this.tag = tag;
    }

    // OVRs
    @Override
    public String toString() {
        return "ItemTag{" +
                "tagId=" + tagId +
                ", tag='" + tag + '\'' +
                '}';
    }

    // METHs


}
