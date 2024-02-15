package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.sql.Date;

public class Source implements DataTransferObject {

    // ATTs
    private long sourceId;
    private String sourceName;
    private Date sourcePublishDate;
    private String sourcePublisher;
    private String sourceTTRPG;

    // CONs
    public Source() {
    }

    public Source(long sourceId, String sourceName, Date sourcePublishDate, String sourcePublisher, String sourceTTRPG) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.sourcePublishDate = sourcePublishDate;
        this.sourcePublisher = sourcePublisher;
        this.sourceTTRPG = sourceTTRPG;
    }

    // GETs & SETs
    public long getSourceId() {
        return sourceId;
    }
    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Date getSourcePublishDate() {
        return sourcePublishDate;
    }
    public void setSourcePublishDate(Date sourcePublishDate) {
        this.sourcePublishDate = sourcePublishDate;
    }

    public String getSourcePublisher() {
        return sourcePublisher;
    }
    public void setSourcePublisher(String sourcePublisher) {
        this.sourcePublisher = sourcePublisher;
    }

    public String getSourceTTRPG() {
        return sourceTTRPG;
    }
    public void setSourceTTRPG(String sourceTTRPG) {
        this.sourceTTRPG = sourceTTRPG;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Source{" +
                "sourceId=" + sourceId +
                ", sourceName='" + sourceName + '\'' +
                ", sourcePublishDate='" + sourcePublishDate + '\'' +
                ", sourcePublisher='" + sourcePublisher + '\'' +
                ", sourceTTRPG='" + sourceTTRPG + '\'' +
                '}';
    }
}
