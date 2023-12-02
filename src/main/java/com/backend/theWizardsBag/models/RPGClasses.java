package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.Dictionary;

public class RPGClasses implements DataTransferObject {

    // ATTs
    private long rpgClassId;
    private String rpgClassName;
    private Dictionary<Long, String> rpgClassObj;

    // CONs


    // GETs & SETs
    public long getRpgClassId() {
        return rpgClassId;
    }
    public void setRpgClassId(long rpgClassId) {
        this.rpgClassId = rpgClassId;
    }

    public String getRpgClassName() {
        return rpgClassName;
    }
    public void setRpgClassName(String rpgClassName) {
        this.rpgClassName = rpgClassName;
    }

    public Dictionary<Long, String> getRpgClassObj() {
        return rpgClassObj;
    }
    public void setRpgClassObj(Dictionary<Long, String> rpgClassObj) {
        this.rpgClassObj = rpgClassObj;
    }

    public void setRpgClassObj(Long rpgClassId, String rpgClassName) {
        this.rpgClassId = rpgClassId;
        this.rpgClassName = rpgClassName;
        this.rpgClassObj.put(rpgClassId, rpgClassName);
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "RPGClasses{" +
                "rpgClassId=" + rpgClassId +
                ", rpgClassName='" + rpgClassName + '\'' +
                ", rpgClassObj=" + rpgClassObj +
                '}';
    }

    // METHs
}
