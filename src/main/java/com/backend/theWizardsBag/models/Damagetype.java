package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class Damagetype implements DataTransferObject {

    // ATTs
    private long damagetypeId;
    private String damagetypeName;

    // CONs
    public Damagetype() {
    }

    public Damagetype(long damagetypeId, String damagetypeName) {
        this.damagetypeId = damagetypeId;
        this.damagetypeName = damagetypeName;
    }

    // GETs & SETs
    public long getDamagetypeId() {
        return damagetypeId;
    }
    public void setDamagetypeId(long damagetypeId) {
        this.damagetypeId = damagetypeId;
    }

    public String getDamagetypeName() {
        return damagetypeName;
    }
    public void setDamagetypeName(String damagetypeName) {
        this.damagetypeName = damagetypeName;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Damagetype{" +
                "damagetypeId=" + damagetypeId +
                ", damagetypeName='" + damagetypeName + '\'' +
                '}';
    }
}
