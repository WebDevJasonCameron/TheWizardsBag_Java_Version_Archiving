package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellDamagetype implements DataTransferObject {

    // ATTs
    private long spellDamagetypeId;
    private long spellsSpellId;
    private long DamagetypesDamagetypeId;

    // CONs
    public SpellDamagetype() {
    }

    public SpellDamagetype(long spellsSpellId, long damagetypesDamagetypeId) {
        this.spellsSpellId = spellsSpellId;
        DamagetypesDamagetypeId = damagetypesDamagetypeId;
    }

    public SpellDamagetype(long spellDamagetypeId, long spellsSpellId, long damagetypesDamagetypeId) {
        this.spellDamagetypeId = spellDamagetypeId;
        this.spellsSpellId = spellsSpellId;
        DamagetypesDamagetypeId = damagetypesDamagetypeId;
    }

    // GETs & SETs
    public long getSpellDamagetypeId() {
        return spellDamagetypeId;
    }
    public void setSpellDamagetypeId(long spellDamagetypeId) {
        this.spellDamagetypeId = spellDamagetypeId;
    }

    public long getSpellsSpellId() {
        return spellsSpellId;
    }
    public void setSpellsSpellId(long spellsSpellId) {
        this.spellsSpellId = spellsSpellId;
    }

    public long getDamagetypesDamagetypeId() {
        return DamagetypesDamagetypeId;
    }
    public void setDamagetypesDamagetypeId(long damagetypesDamagetypeId) {
        DamagetypesDamagetypeId = damagetypesDamagetypeId;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellDamagetype{" +
                "spellDamagetypeId=" + spellDamagetypeId +
                ", spellsSpellId=" + spellsSpellId +
                ", DamagetypesDamagetypeId=" + DamagetypesDamagetypeId +
                '}';
    }

    // METHs



}
