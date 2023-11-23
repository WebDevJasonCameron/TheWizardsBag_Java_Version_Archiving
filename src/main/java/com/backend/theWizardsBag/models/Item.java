package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.constants.enums.Rarity;

import java.util.List;

public class Item {

    // ATTs
    private int itemId;
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

    // LISTs
    private List<ItemType> types;
    private List<String> tags;
    private List<Note> notes;
    private List<Spell> attachedSpells;

    /**
     * effects
     */

    // OBJs
    private Source source;


}
