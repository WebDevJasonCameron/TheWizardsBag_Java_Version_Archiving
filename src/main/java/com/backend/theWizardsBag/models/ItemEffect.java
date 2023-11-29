package com.backend.theWizardsBag.models;


import java.util.Dictionary;

public class ItemEffect {

    // ATTs
    private int effectId;
    private String effect;
    private String subEffect;
    private Dictionary<String, String> itemEffect;

    // CONs
    public ItemEffect() {
    }
    public ItemEffect(String effect, String subEffect) {
        this.effect = effect;
        this.subEffect = subEffect;
        this.itemEffect.put(this.effect, this.subEffect);

    }

    // GETs
    public int getEffectId() {
        return effectId;
    }
    public String getEffect() {
        return effect;
    }
    public String getSubEffect() {
        return subEffect;
    }
    public Dictionary<String, String> getItemEffect() {
        return itemEffect;
    }

    // SETs
    public void setEffect(String effect) {
        this.effect = effect;
    }
    public void setSubEffect(String subEffect) {
        this.subEffect = subEffect;
    }
    public void setItemEffect(String effect, String subEffect) {
        setEffect(effect);
        setSubEffect(subEffect);
        this.itemEffect.put(this.effect, this.subEffect);
    }

    // OVRs
    @Override
    public String toString() {
        return "ItemEffect{" +
                "effectId=" + effectId +
                ", effect='" + effect + '\'' +
                ", subEffect='" + subEffect + '\'' +
                ", itemEffect=" + itemEffect +
                '}';
    }

    // METHs


}
