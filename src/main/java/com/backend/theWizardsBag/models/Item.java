package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.constants.enums.MagicBonuses;
import com.backend.theWizardsBag.constants.enums.Rarity;

import java.util.List;

public class Item {

    // ATTs
    private long itemId;
    private String name;
    private String ttrpg;
    private boolean magical;                //   No Null
    private Rarity rarity;
    private boolean requiresAttunement;     //   No Null
    private boolean hasCharges;             //   No Null
    private boolean isCursed;
    private double price;
    private String description;
    private String imageUrl;
    private MagicBonuses magicBonus;

    // LISTs
    private List<ItemType> types;
    private List<ItemTag> tags;
    private List<Note> notes;
    private List<Spell> attachedSpells;
    private List<ItemEffect> effects;

    // OBJs
    private Source source;

    // CONs

    // GETs

    // SETs

    // OVRs

    // METHs


}
