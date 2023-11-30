package com.backend.theWizardsBag.models;


import java.util.Dictionary;

public class ItemEffect {

    // ATTs
    private long effectId;
    private String effect;
    private String subEffect;
    private Dictionary<String, String> itemEffect;
    private Dictionary<Long, Dictionary> itemEffectObj;

    // CONs
    public ItemEffect() {
    }
    public ItemEffect(long effectId, String effect, String subEffect) {
        this.effect = effect;
        this.subEffect = subEffect;
        this.itemEffect.put(this.effect, this.subEffect);
        this.itemEffectObj.put(effectId, itemEffect);

    }

    // SETs & GETs
    public void setEffectId(long effectId) {this.effectId = effectId;}
    public long getEffectId() {
        return effectId;
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

    public void setItemEffect(String effect, String subEffect) {
        setEffect(effect);
        setSubEffect(subEffect);
        this.itemEffect.put(this.effect, this.subEffect);
    }
    public Dictionary<String, String> getItemEffect() {
        return itemEffect;
    }

    public void setItemEffectObj(long effectId, String  effect, String subEffect) {
        setEffect(effect);
        setSubEffect(subEffect);
        this.itemEffect.put(this.effect, this.subEffect);
        this.itemEffectObj.put(effectId, itemEffect);
    }
    public Dictionary<Long, Dictionary> getItemEffectObj() {
        return itemEffectObj;
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
