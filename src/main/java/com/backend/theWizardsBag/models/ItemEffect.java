package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class ItemEffect implements DataTransferObject {

    // ATTs
    private long itemEffectJunctionId;
    private long itemEffectId;
    private String effect;
    private String subEffect;


    // CONs


    // SETs & GETs
    public long getItemEffectJunctionId() {
        return itemEffectJunctionId;
    }
    public void setItemEffectJunctionId(long itemEffectJunctionId) {
        this.itemEffectJunctionId = itemEffectJunctionId;
    }

    public long getItemEffectId() {
        return itemEffectId;
    }
    public void setItemEffectId(long itemEffectId) {
        this.itemEffectId = itemEffectId;
    }

    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getSubEffect() {
        return subEffect;
    }
    public void setSubEffect(String subEffect) {
        this.subEffect = subEffect;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "ItemEffect{" +
                "itemEffectJunctionId=" + itemEffectJunctionId +
                ", itemEffectId=" + itemEffectId +
                ", Effect='" + effect + '\'' +
                ", subEffect='" + subEffect + '\'' +
                '}';
    }

// METHs


}
