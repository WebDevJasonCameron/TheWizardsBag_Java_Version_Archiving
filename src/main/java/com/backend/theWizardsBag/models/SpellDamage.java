package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.Dictionary;

public class SpellDamage  implements DataTransferObject {

    // ATTs
    private long spellDamageID;
    private String damage;
    private Dictionary<Long, String> damageObj;

    // CONs


    // GETs & SETs
    public long getSpellDamageID() {
        return spellDamageID;
    }
    public void setSpellDamageID(long spellDamageID) {
        this.spellDamageID = spellDamageID;
    }

    public String getDamage() {
        return damage;
    }
    public void setDamage(String damage) {
        this.damage = damage;
    }

    public Dictionary<Long, String> getDamageObj() {
        return damageObj;
    }
    public void setDamageObj(Dictionary<Long, String> damageObj) {
        this.damageObj = damageObj;
    }

    public void setDamageObj(long spellDamageID, String damage) {
        this.spellDamageID = spellDamageID;
        this.damage = damage;
        this.damageObj.put(spellDamageID, damage);
    }



    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    // METHs



}
