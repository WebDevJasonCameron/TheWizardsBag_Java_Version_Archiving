package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class Effect implements DataTransferObject {

    // ATTs
    private long effectId;
    private String effectName;
    private String effectSubEffect;

    // CONs
    public Effect() {
    }

    public Effect(long effectId, String effectName, String effectSubEffect) {
        this.effectId = effectId;
        this.effectName = effectName;
        this.effectSubEffect = effectSubEffect;
    }

    // GETs & SETs
    public long getEffectId() {
        return effectId;
    }
    public void setEffectId(long effectId) {
        this.effectId = effectId;
    }

    public String getEffectName() {
        return effectName;
    }
    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public String getEffectSubEffect() {
        return effectSubEffect;
    }
    public void setEffectSubEffect(String effectSubEffect) {
        this.effectSubEffect = effectSubEffect;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Effect{" +
                "effectId=" + effectId +
                ", effectName='" + effectName + '\'' +
                ", effectSubEffect='" + effectSubEffect + '\'' +
                '}';
    }
}
