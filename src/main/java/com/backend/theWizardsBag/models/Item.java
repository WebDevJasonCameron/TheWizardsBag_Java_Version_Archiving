package com.backend.theWizardsBag.models;


import java.util.List;

public class Item {

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
    private List<Note> noteList;
    private List<Spell> attachedSpellList;
    private List<ItemEffect> effectList;

    // OBJs
    private Source source;

    // CONs

    // GETs

    // SETs

    // OVRs

    // METHs


}
