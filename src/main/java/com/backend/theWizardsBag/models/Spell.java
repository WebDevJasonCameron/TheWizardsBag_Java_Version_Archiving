package com.backend.theWizardsBag.models;

import java.util.List;

public class Spell {

    // ATTs
    private int spellId;
    private String level;                       // enum
    private String castingTime;
    private String range_area;
    private String components;
    private String duration;
    private boolean concentration;
    private boolean ritual;
    private String school;                      // enum
    private String attackOrSave;
    private String damageOrEffect;
    private String description;
    private String imageUrl;

    // LISTs
    private List<String> spellTags;             // enum
    private List<String> availableFor;          // enum


}
