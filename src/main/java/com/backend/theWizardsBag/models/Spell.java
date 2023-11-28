package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.constants.enums.*;
import com.backend.theWizardsBag.utils.Objects.DataTransferObject;


import java.util.List;

public class Spell implements DataTransferObject {

    // ATTs
    private int spellId;
    private SpellLevels level;
    private SpellCastingTimes castingTime;
    private SpellRanges range;
    private boolean componentsVisual;
    private boolean componentsSemantic;
    private boolean componentsMaterial;
    private String componentsMaterials;
    private String duration;
    private boolean concentration;
    private boolean ritual;
    private SpellSchools school;
    private SpellAttackTypes attack;
    private SpellSaveTypes saveRequired;
    private String description;
    private String imageUrl;

    // LISTs
    private List<SpellTags> spellTags;
    private List<RPGClasses> availableFor;
    private List<SpellDamageTypes> damage;

    // OBJs
    private Source source;

    // CONs

    // GETs & SETs
    public int getSpellId() {
        return spellId;
    }
    public void setSpellId(int spellId) {
        this.spellId = spellId;
    }

    public SpellLevels getLevel() {
        return level;
    }
    public void setLevel(SpellLevels level) {
        this.level = level;
    }

    public SpellCastingTimes getCastingTime() {
        return castingTime;
    }
    public void setCastingTime(SpellCastingTimes castingTime) {
        this.castingTime = castingTime;
    }

    public SpellRanges getRange() {
        return range;
    }
    public void setRange(SpellRanges range) {
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

    public SpellSchools getSchool() {
        return school;
    }
    public void setSchool(SpellSchools school) {
        this.school = school;
    }

    public SpellAttackTypes getAttack() {
        return attack;
    }
    public void setAttack(SpellAttackTypes attack) {
        this.attack = attack;
    }

    public SpellSaveTypes getSaveRequired() {
        return saveRequired;
    }
    public void setSaveRequired(SpellSaveTypes saveRequired) {
        this.saveRequired = saveRequired;
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

    public List<SpellTags> getSpellTags() {
        return spellTags;
    }
    public void setSpellTags(List<SpellTags> spellTags) {
        this.spellTags = spellTags;
    }

    public List<RPGClasses> getAvailableFor() {
        return availableFor;
    }
    public void setAvailableFor(List<RPGClasses> availableFor) {
        this.availableFor = availableFor;
    }

    public List<SpellDamageTypes> getDamage() {
        return damage;
    }
    public void setDamage(List<SpellDamageTypes> damage) {
        this.damage = damage;
    }

    public Source getSource() {
        return source;
    }
    public void setSource(Source source) {
        this.source = source;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    // METHs

}
