package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.List;

public class Spell implements DataTransferObject {

    // ATTs
    private long spellId;
    private String name;
    private String level;
    private String castingTime;
    private String range;
    private boolean componentsVisual;
    private boolean componentsSemantic;
    private boolean componentsMaterial;
    private String componentsMaterials;
    private String duration;
    private boolean concentration;
    private boolean ritual;
    private String school;
    private String saveType;
    private String description;
    private String imageUrl;

    // LISTs
    private List<SpellTag> tagList;
    private List<SpellCondition> conditionList;
    private List<SpellDamage> damageList;
    private List<SpellAccessible> accessibleList;

    // OBJs
    private long source;

    // CONs

    // GETs & SETs
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getSpellId() {
        return spellId;
    }
    public void setSpellId(long spellId) {
        this.spellId = spellId;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public String getCastingTime() {
        return castingTime;
    }
    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getRange() {
        return range;
    }
    public void setRange(String range) {
        this.range = range;
    }

    public boolean isComponentsVisual() {
        return componentsVisual;
    }
    public void setComponentsVisual(boolean componentsVisual) {
        this.componentsVisual = componentsVisual;
    }

    public boolean isComponentsSemantic() {
        return componentsSemantic;
    }
    public void setComponentsSemantic(boolean componentsSemantic) {
        this.componentsSemantic = componentsSemantic;
    }

    public boolean isComponentsMaterial() {
        return componentsMaterial;
    }
    public void setComponentsMaterial(boolean componentsMaterial) {
        this.componentsMaterial = componentsMaterial;
    }

    public String getComponentsMaterials() {
        return componentsMaterials;
    }
    public void setComponentsMaterials(String componentsMaterials) {
        this.componentsMaterials = componentsMaterials;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isConcentration() {
        return concentration;
    }
    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public boolean isRitual() {
        return ritual;
    }
    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    public String getSaveType() {
        return saveType;
    }
    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // G&S LISTs
    public List<SpellTag> getTagList() {
        return tagList;
    }
    public void setTagList(List<SpellTag> tagList) {
        this.tagList = tagList;
    }

    public List<SpellCondition> getConditionList() {
        return conditionList;
    }
    public void setConditionList(List<SpellCondition> conditionList) {
        this.conditionList = conditionList;
    }

    public List<SpellAccessible> getAccessibleList() {
        return accessibleList;
    }
    public void setAccessibleList(List<SpellAccessible> accessibleList) {
        this.accessibleList = accessibleList;
    }

    public List<SpellDamage> getDamageList() {
        return damageList;
    }
    public void setDamageList(List<SpellDamage> damageList) {
        this.damageList = damageList;
    }

    // G&S OBJs
    public long getSource() {
        return source;
    }
    public void setSource(long source) {
        this.source = source;
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
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", castingTime='" + castingTime + '\'' +
                ", range='" + range + '\'' +
                ", componentsVisual=" + componentsVisual +
                ", componentsSemantic=" + componentsSemantic +
                ", componentsMaterial=" + componentsMaterial +
                ", componentsMaterials='" + componentsMaterials + '\'' +
                ", duration='" + duration + '\'' +
                ", concentration=" + concentration +
                ", ritual=" + ritual +
                ", school='" + school + '\'' +
                ", saveType='" + saveType + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tagList=" + tagList +
                ", conditionList=" + conditionList +
                ", damageList=" + damageList +
                ", accessibleList=" + accessibleList +
                ", source=" + source +
                '}';
    }

// METHs

}
