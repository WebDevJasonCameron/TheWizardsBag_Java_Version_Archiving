package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.constants.enums.Rarity;
import com.backend.theWizardsBag.constants.enums.SpellTags;

import java.lang.reflect.Type;
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
    private List<Type> types;
    private List<SpellTags> tags;
    private List<Note> notes;
    private List<Spell> attachedSpells;

    /**
     * effects
     */

    // OBJs
    private Source source;


}
