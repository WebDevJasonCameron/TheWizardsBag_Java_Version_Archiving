package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class SpellClass implements DataTransferObject {

    // ATTs
    private long classID;
    private String className;
    private  String subClassName;
    private String classDescription;

    // CONs


    // GETs & SETs
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

    public String getSubClassName() {
        return subClassName;
    }
    public void setSubClassName(String subClassName) {
        this.subClassName = subClassName;
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
                "classID=" + classID +
                ", className='" + className + '\'' +
                ", subClassName='" + subClassName + '\'' +
                ", classDescription='" + classDescription + '\'' +
                '}';
    }

// METHs
}
