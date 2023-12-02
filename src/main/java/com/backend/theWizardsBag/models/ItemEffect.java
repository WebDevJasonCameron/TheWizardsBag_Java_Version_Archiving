package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class ItemEffect implements DataTransferObject {

    // ATTs
    private long effectJunctionId;
    private long effectId;
    private String effect;
    private String subEffect;


    // CONs

    // SETs & GETs
    public void setEffectJunctionId(long effectJunctionId) {this.effectJunctionId = effectJunctionId;}
    public long getEffectJunctionId() {
        return effectJunctionId;
    }

    public long getEffectId() {
        return effectId;
    }
    public void setEffectId(long effectId) {
        this.effectId = effectId;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
    public String getEffect() {
        return effect;
    }

    public void setSubEffect(String subEffect) {
        this.subEffect = subEffect;
    }
    public String getSubEffect() {
        return subEffect;
    }


    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "ItemEffect{" +
                "effectJunctionId=" + effectJunctionId +
                ", effect='" + effect + '\'' +
                ", subEffect='" + subEffect + '\'' +
                '}';
    }

    // METHs


}
