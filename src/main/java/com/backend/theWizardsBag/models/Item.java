package com.backend.theWizardsBag.models;


import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.List;

public class Item implements DataTransferObject {

    // ATTs
    private long itemId;
    private String name;
    private String ttrpg;
    private String rarity;
    private String renownedQuality;
    private boolean requiresAttunement;
    private boolean hasCharges;
    private boolean isCursed;
    private double price;
    private String weight;
    private String description;
    private String imageUrl;
    private boolean magicBonusPlus1;
    private boolean magicBonusPlus2;
    private boolean magicBonusPlus3;
    private String descriptionNotes;

    // LISTs
    private List<ItemType> typeList;
    private List<ItemTag> tagList;
    private List<ItemCondition> conditionList;
    private List<ItemNote> noteList;
    private List<Spell> attachedSpellList;
    private List<ItemEffect> effectList;

    // OBJs
    private Source source;

    // CONs

    // GETs & SETs
    public long getItemId() {
        return itemId;
    }
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTtrpg() {
        return ttrpg;
    }
    public void setTtrpg(String ttrpg) {
        this.ttrpg = ttrpg;
    }

    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRenownedQuality() {
        return renownedQuality;
    }
    public void setRenownedQuality(String renownedQuality) {
        this.renownedQuality = renownedQuality;
    }

    public boolean isRequiresAttunement() {
        return requiresAttunement;
    }
    public void setRequiresAttunement(boolean requiresAttunement) {
        this.requiresAttunement = requiresAttunement;
    }

    public boolean isHasCharges() {
        return hasCharges;
    }
    public void setHasCharges(boolean hasCharges) {
        this.hasCharges = hasCharges;
    }

    public boolean isCursed() {
        return isCursed;
    }
    public void setCursed(boolean cursed) {
        isCursed = cursed;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
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

    public boolean isMagicBonusPlus1() {
        return magicBonusPlus1;
    }
    public void setMagicBonusPlus1(boolean magicBonusPlus1) {
        this.magicBonusPlus1 = magicBonusPlus1;
    }

    public boolean isMagicBonusPlus2() {
        return magicBonusPlus2;
    }
    public void setMagicBonusPlus2(boolean magicBonusPlus2) {
        this.magicBonusPlus2 = magicBonusPlus2;
    }

    public boolean isMagicBonusPlus3() {
        return magicBonusPlus3;
    }
    public void setMagicBonusPlus3(boolean magicBonusPlus3) {
        this.magicBonusPlus3 = magicBonusPlus3;
    }

    public String getDescriptionNotes() {
        return descriptionNotes;
    }
    public void setDescriptionNotes(String descriptionNotes) {
        this.descriptionNotes = descriptionNotes;
    }

    // LISTs
    public List<ItemType> getTypeList() {
        return typeList;
    }
    public void setTypeList(List<ItemType> typeList) {
        this.typeList = typeList;
    }

    public List<ItemTag> getTagList() {
        return tagList;
    }
    public void setTagList(List<ItemTag> tagList) {
        this.tagList = tagList;
    }

    public List<ItemCondition> getConditionList() {
        return conditionList;
    }
    public void setConditionList(List<ItemCondition> conditionList) {
        this.conditionList = conditionList;
    }

    public List<ItemNote> getNoteList() {
        return noteList;
    }
    public void setNoteList(List<ItemNote> noteList) {
        this.noteList = noteList;
    }

    public List<Spell> getAttachedSpellList() {
        return attachedSpellList;
    }
    public void setAttachedSpellList(List<Spell> attachedSpellList) {
        this.attachedSpellList = attachedSpellList;
    }

    public List<ItemEffect> getEffectList() {
        return effectList;
    }
    public void setEffectList(List<ItemEffect> effectList) {
        this.effectList = effectList;
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

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", ttrpg='" + ttrpg + '\'' +
                ", rarity='" + rarity + '\'' +
                ", renownedQuality='" + renownedQuality + '\'' +
                ", requiresAttunement=" + requiresAttunement +
                ", hasCharges=" + hasCharges +
                ", isCursed=" + isCursed +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", magicBonusPlus1=" + magicBonusPlus1 +
                ", magicBonusPlus2=" + magicBonusPlus2 +
                ", magicBonusPlus3=" + magicBonusPlus3 +
                ", descriptionNotes='" + descriptionNotes + '\'' +
                ", typeList=" + typeList +
                ", tagList=" + tagList +
                ", conditionList=" + conditionList +
                ", noteList=" + noteList +
                ", attachedSpellList=" + attachedSpellList +
                ", effectList=" + effectList +
                ", source=" + source +
                '}';
    }

// METHs


}
