package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellTag implements DataTransferObject {

    // ATTs
    private long spellTagId;
    private long spellsSpellId;
    private long tagsTagId;

    // CONs
    public SpellTag() {
    }

    public SpellTag(long spellsSpellId, long tagsTagId) {
        this.spellsSpellId = spellsSpellId;
        this.tagsTagId = tagsTagId;
    }

    public SpellTag(long spellTagId, long spellsSpellId, long tagsTagId) {
        this.spellTagId = spellTagId;
        this.spellsSpellId = spellsSpellId;
        this.tagsTagId = tagsTagId;
    }

    // GETS & SETs
    public long getSpellTagId() {
        return spellTagId;
    }
    public void setSpellTagId(long spellTagId) {
        this.spellTagId = spellTagId;
    }

    public long getSpellsSpellId() {
        return spellsSpellId;
    }
    public void setSpellsSpellId(long spellsSpellId) {
        this.spellsSpellId = spellsSpellId;
    }

    public long getTagsTagId() {
        return tagsTagId;
    }
    public void setTagsTagId(long tagsTagId) {
        this.tagsTagId = tagsTagId;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellTag{" +
                "spellTagId=" + spellTagId +
                ", spellsSpellId=" + spellsSpellId +
                ", tagsTagId=" + tagsTagId +
                '}';
    }
}
