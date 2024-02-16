package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.List;

public class Spell implements DataTransferObject {

    // ATTs
    private long spellId;
    private String spellName;
    private String spellLevel;
    private String spellCastingTime;
    private String spellRange;
    private boolean spellComponentsVisual;
    private boolean spellComponentsSemantic;
    private boolean spellComponentsMaterial;
    private String spellComponentsMaterials;
    private String spellDuration;
    private boolean spellConcentration;
    private boolean spellRitual;
    private String spellSchool;
    private String spellSaveType;
    private String spellDescription;
    private String spellImageUrl;

    // LISTs
    private List<SpellTag> spellTagList;
    private List<SpellCondition> spellConditionList;
    private List<SpellDamage> spellDamageList;
    private List<SpellClass> spellClassList;

    // OBJs
    private long spellSource;

    // CONs
    public Spell() {
    }

    public Spell(long spellId, String spellName, String spellLevel, String spellCastingTime, String spellRange, boolean spellComponentsVisual, boolean spellComponentsSemantic, boolean spellComponentsMaterial, String spellComponentsMaterials, String spellDuration, boolean spellConcentration, boolean spellRitual, String spellSchool, String spellSaveType, String spellDescription, String spellImageUrl, long spellSource) {
        this.spellId = spellId;
        this.spellName = spellName;
        this.spellLevel = spellLevel;
        this.spellCastingTime = spellCastingTime;
        this.spellRange = spellRange;
        this.spellComponentsVisual = spellComponentsVisual;
        this.spellComponentsSemantic = spellComponentsSemantic;
        this.spellComponentsMaterial = spellComponentsMaterial;
        this.spellComponentsMaterials = spellComponentsMaterials;
        this.spellDuration = spellDuration;
        this.spellConcentration = spellConcentration;
        this.spellRitual = spellRitual;
        this.spellSchool = spellSchool;
        this.spellSaveType = spellSaveType;
        this.spellDescription = spellDescription;
        this.spellImageUrl = spellImageUrl;
        this.spellSource = spellSource;
    }

    // GETs & SETs
    public long getSpellId() {
        return spellId;
    }
    public void setSpellId(long spellId) {
        this.spellId = spellId;
    }

    public String getSpellName() {
        return spellName;
    }
    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellLevel() {
        return spellLevel;
    }
    public void setSpellLevel(String spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getSpellCastingTime() {
        return spellCastingTime;
    }
    public void setSpellCastingTime(String spellCastingTime) {
        this.spellCastingTime = spellCastingTime;
    }

    public String getSpellRange() {
        return spellRange;
    }
    public void setSpellRange(String spellRange) {
        this.spellRange = spellRange;
    }

    public boolean isSpellComponentsVisual() {
        return spellComponentsVisual;
    }
    public void setSpellComponentsVisual(boolean spellComponentsVisual) {
        this.spellComponentsVisual = spellComponentsVisual;
    }

    public boolean isSpellComponentsSemantic() {
        return spellComponentsSemantic;
    }
    public void setSpellComponentsSemantic(boolean spellComponentsSemantic) {
        this.spellComponentsSemantic = spellComponentsSemantic;
    }

    public boolean isSpellComponentsMaterial() {
        return spellComponentsMaterial;
    }
    public void setSpellComponentsMaterial(boolean spellComponentsMaterial) {
        this.spellComponentsMaterial = spellComponentsMaterial;
    }

    public String getSpellComponentsMaterials() {
        return spellComponentsMaterials;
    }
    public void setSpellComponentsMaterials(String spellComponentsMaterials) {
        this.spellComponentsMaterials = spellComponentsMaterials;
    }

    public String getSpellDuration() {
        return spellDuration;
    }
    public void setSpellDuration(String spellDuration) {
        this.spellDuration = spellDuration;
    }

    public boolean isSpellConcentration() {
        return spellConcentration;
    }
    public void setSpellConcentration(boolean spellConcentration) {
        this.spellConcentration = spellConcentration;
    }

    public boolean isSpellRitual() {
        return spellRitual;
    }
    public void setSpellRitual(boolean spellRitual) {
        this.spellRitual = spellRitual;
    }

    public String getSpellSchool() {
        return spellSchool;
    }
    public void setSpellSchool(String spellSchool) {
        this.spellSchool = spellSchool;
    }

    public String getSpellSaveType() {
        return spellSaveType;
    }
    public void setSpellSaveType(String spellSaveType) {
        this.spellSaveType = spellSaveType;
    }

    public String getSpellDescription() {
        return spellDescription;
    }
    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }

    public String getSpellImageUrl() {
        return spellImageUrl;
    }
    public void setSpellImageUrl(String spellImageUrl) {
        this.spellImageUrl = spellImageUrl;
    }


    // GETs & SETs LISTs
    public List<SpellTag> getSpellTagList() {
        return spellTagList;
    }
    public void setSpellTagList(List<SpellTag> spellTagList) {
        this.spellTagList = spellTagList;
    }

    public List<SpellCondition> getSpellConditionList() {
        return spellConditionList;
    }
    public void setSpellConditionList(List<SpellCondition> spellConditionList) {
        this.spellConditionList = spellConditionList;
    }

    public List<SpellDamage> getSpellDamageList() {
        return spellDamageList;
    }
    public void setSpellDamageList(List<SpellDamage> spellDamageList) {
        this.spellDamageList = spellDamageList;
    }

    public List<SpellClass> getSpellClassList() {
        return spellClassList;
    }
    public void setSpellClassList(List<SpellClass> spellClassList) {
        this.spellClassList = spellClassList;
    }


    // GETs & SETs OBJs
    public long getSpellSource() {
        return spellSource;
    }
    public void setSpellSource(long spellSource) {
        this.spellSource = spellSource;
    }


    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "spellId=" + spellId +
                ", spellName='" + spellName + '\'' +
                ", spellLevel='" + spellLevel + '\'' +
                ", spellCastingTime='" + spellCastingTime + '\'' +
                ", spellRange='" + spellRange + '\'' +
                ", spellComponentsVisual=" + spellComponentsVisual +
                ", spellComponentsSemantic=" + spellComponentsSemantic +
                ", spellComponentsMaterial=" + spellComponentsMaterial +
                ", spellComponentsMaterials='" + spellComponentsMaterials + '\'' +
                ", spellDuration='" + spellDuration + '\'' +
                ", spellConcentration=" + spellConcentration +
                ", spellRitual=" + spellRitual +
                ", spellSchool='" + spellSchool + '\'' +
                ", spellSaveType='" + spellSaveType + '\'' +
                ", spellDescription='" + spellDescription + '\'' +
                ", spellImageUrl='" + spellImageUrl + '\'' +
                ", spellTagList=" + spellTagList +
                ", spellConditionList=" + spellConditionList +
                ", spellDamageList=" + spellDamageList +
                ", spellClassList=" + spellClassList +
                ", spellSource=" + spellSource +
                '}';
    }


}
