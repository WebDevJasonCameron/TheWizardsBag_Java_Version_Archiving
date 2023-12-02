package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class ItemTag implements DataTransferObject {

    // ATTs
    private long itemTagId;
    private String tag;

    // CONs

    // GETs & SETs
    public long getItemTagId() {
        return itemTagId;
    }
    public void setItemTagId(long itemTagId) {
        this.itemTagId = itemTagId;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }


    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "ItemTag{" +
                "itemTagId=" + itemTagId +
                ", tag='" + tag + '\'' +
                '}';
    }

    // METHs


}
