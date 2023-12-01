package com.backend.theWizardsBag.models;


import java.util.Dictionary;

public class ItemEffect {

    // ATTs
    private long effectJTId;
    private long effectId;                                  //   <R>
    private String effect;
    private String subEffect;
    private Dictionary<String, String> effectObj;           //   <R>
    private Dictionary<Long, Dictionary> effectObjObj;      //   <R>

    // CONs
    public ItemEffect() {
    }
    public ItemEffect(long effectJTId, String effect, String subEffect) {
        this.effect = effect;
        this.subEffect = subEffect;
        this.effectObj.put(this.effect, this.subEffect);
        this.effectObjObj.put(effectJTId, effectObj);

    }

    // SETs & GETs
    public void setEffectJTId(long effectJTId) {this.effectJTId = effectJTId;}
    public long getEffectJTId() {
        return effectJTId;
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

    //   <R>
    public void setEffectObj(String effect, String subEffect) {
        setEffect(effect);
        setSubEffect(subEffect);
        this.effectObj.put(this.effect, this.subEffect);
    }
    public Dictionary<String, String> getEffectObj() {
        return effectObj;
    }

    //   <R>
    public void setItemEffectObj(long effectJTId, String  effect, String subEffect) {
        setEffect(effect);
        setSubEffect(subEffect);
        this.effectObj.put(this.effect, this.subEffect);
        this.effectObjObj.put(effectJTId, effectObj);
    }
    public Dictionary<Long, Dictionary> getItemEffectObj() {
        return effectObjObj;
    }


    // OVRs
    @Override
    public String toString() {
        return "ItemEffect{" +
                "effectJTId=" + effectJTId +
                ", effect='" + effect + '\'' +
                ", subEffect='" + subEffect + '\'' +
                ", effectObj=" + effectObj +
                '}';
    }

    // METHs


}
