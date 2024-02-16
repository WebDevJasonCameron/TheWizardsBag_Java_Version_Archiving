package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class RpgClass implements DataTransferObject {

    // ATTs
        private long classId;
        private String className;
        private String classSubclassName;
        private String classDescription;

    // CONs
    public RpgClass() {
    }

    public RpgClass(long classId, String className, String classSubclassName, String classDescription) {
        this.classId = classId;
        this.className = className;
        this.classSubclassName = classSubclassName;
        this.classDescription = classDescription;
    }

    // GETs & SETs
    public long getClassId() {
        return classId;
    }
    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassSubclassName() {
        return classSubclassName;
    }
    public void setClassSubclassName(String classSubclassName) {
        this.classSubclassName = classSubclassName;
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
        return "RpgClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classSubclassName='" + classSubclassName + '\'' +
                ", classDescription='" + classDescription + '\'' +
                '}';
    }
}
