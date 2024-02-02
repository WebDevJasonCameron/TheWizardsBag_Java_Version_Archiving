package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellClass implements DataTransferObject {

    // ATTs
    private long spellClassID;                          //   Junction ID
    private long classID;
    private String className;
    private  String classSubClassName;
    private String classDescription;

    // CONs


    // GETs & SETs
    public long getSpellClassID() {
        return spellClassID;
    }
    public void setSpellClassID(long spellClassID) {
        this.spellClassID = spellClassID;
    }

    public long getClassID() {
        return classID;
    }
    public void setClassID(long classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassSubClassName() {
        return classSubClassName;
    }
    public void setClassSubClassName(String classSubClassName) {
        this.classSubClassName = classSubClassName;
    }

    public String getClassDescription() {
        return classDescription;
    }
    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "SpellClass{" +
                "spellClassID=" + spellClassID +
                ", classID=" + classID +
                ", className='" + className + '\'' +
                ", classSubClassName='" + classSubClassName + '\'' +
                ", classDescription='" + classDescription + '\'' +
                '}';
    }

// METHs
}
