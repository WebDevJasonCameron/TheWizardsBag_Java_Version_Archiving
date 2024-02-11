package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class Type implements DataTransferObject {

    // ATTs
    private long typeId;
    private String typeName;
    private String typeSubType;

    // CONs
    public Type() {
    }

    public Type(long typeId, String typeName, String typeSubType) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeSubType = typeSubType;
    }

    // GETs & SETs
    public long getTypeId() {
        return typeId;
    }
    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeSubType() {
        return typeSubType;
    }
    public void setTypeSubType(String typeSubType) {
        this.typeSubType = typeSubType;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeSubType='" + typeSubType + '\'' +
                '}';
    }

    // MTHs
}
