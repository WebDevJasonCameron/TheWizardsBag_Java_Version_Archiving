package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.Dictionary;

public class SpellTag implements DataTransferObject {

    // ATTs
    private long spellTagId;
    private String tag;
    private Dictionary<Long, String> spellTagObj;

    // CONs



    // GETS & SETs
    public long getSpellTagID() {
        return spellTagId;
    }
    public void setSpellTagID(long spellTagId) {
        this.spellTagId = spellTagId;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public Dictionary<Long, String> getSpellTagObj() {
        return spellTagObj;
    }
    public void setSpellTagObj(Dictionary<Long, String> spellTagObj) {
        this.spellTagObj = spellTagObj;
    }
    public void setSpellTagObj(Long spellTagId, String tag){
        this.spellTagObj.put(spellTagId, tag);
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellTag{" +
                "spellTagID=" + spellTagId +
                ", tag='" + tag + '\'' +
                '}';
    }

    // METHs
}
