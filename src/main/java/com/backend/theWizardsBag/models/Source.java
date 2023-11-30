package com.backend.theWizardsBag.models;

public class Source {

    // ATTs
    private long sourceId;
    private String name;
    private String publishDate;

    // CONs
    public Source() {
    }
    public Source(long sourceId, String name, String publishDate) {
        this.sourceId = sourceId;
        this.name = name;
        this.publishDate = publishDate;
    }

    // GETs
    public long getSourceId() {
        return sourceId;
    }
    public String getName() {
        return name;
    }
    public String getPublishDate() {
        return publishDate;
    }

    // SETs
    public void setName(String name) {
        this.name = name;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    // OVRs
    @Override
    public String toString() {
        return "Source{" +
                "sourceId=" + sourceId +
                ", name='" + name + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }

    // METHs


}
