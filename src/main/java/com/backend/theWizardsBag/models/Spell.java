package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.constants.enums.*;

import java.util.List;

public class Spell {

    // ATTs
    private int spellId;
    private SpellLevels level;
    private CastingTIme castingTime;             // enum
    private String range_area;
    private String components;
    private String duration;
    private boolean concentration;
    private boolean ritual;
    private Schools school;
    private String attackOrSave;
    private String damageOrEffect;
    private String description;
    private String imageUrl;

    // LISTs
    private List<SpellTags> spellTags;
    private List<RPGClasses> availableFor;


}
