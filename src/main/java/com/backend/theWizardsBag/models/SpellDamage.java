package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellDamage implements DataTransferObject {

    // ATTs
    private long spellDamageID;
    private String damage;

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


    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    // METHs



}
