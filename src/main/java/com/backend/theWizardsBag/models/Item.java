package com.backend.theWizardsBag.models;


import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

import java.util.List;

public class Item implements DataTransferObject {

    // ATTs
    private long itemId;
    private String name;
    private String ttrpg;
    private boolean magical;                //   Not Null
    private String rarity;
    private boolean requiresAttunement;     //   Not Null
    private boolean hasCharges;             //   Not Null
    private boolean isCursed;
    private double price;
    private String description;
    private String imageUrl;
    private String magicBonus;

    // LISTs
    private List<ItemType> typeList;
    private List<ItemTag> tagList;
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

    public boolean isMagical() {
        return magical;
    }
    public void setMagical(boolean magical) {
        this.magical = magical;
    }

    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
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

    public String getMagicBonus() {
        return magicBonus;
    }
    public void setMagicBonus(String magicBonus) {
        this.magicBonus = magicBonus;
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
                ", magical=" + magical +
                ", rarity='" + rarity + '\'' +
                ", requiresAttunement=" + requiresAttunement +
                ", hasCharges=" + hasCharges +
                ", isCursed=" + isCursed +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", magicBonus='" + magicBonus + '\'' +
                ", typeList=" + typeList +
                ", tagList=" + tagList +
                ", noteList=" + noteList +
                ", attachedSpellList=" + attachedSpellList +
                ", effectList=" + effectList +
                ", source=" + source +
                '}';
    }


    // METHs


}
