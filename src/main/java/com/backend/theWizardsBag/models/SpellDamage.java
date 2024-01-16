package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellDamage implements DataTransferObject {

    // ATTs
    private long damageID;
    private String damageName;

    // CONs


    // GETs & SETs
    public long getDamageID() {
        return damageID;
    }
    public void setDamageID(long damageID) {
        this.damageID = damageID;
    }

    public String getDamageName() {
        return damageName;
    }
    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellDamage{" +
                "damageID=" + damageID +
                ", damageName='" + damageName + '\'' +
                '}';
    }

    // METHs



}
