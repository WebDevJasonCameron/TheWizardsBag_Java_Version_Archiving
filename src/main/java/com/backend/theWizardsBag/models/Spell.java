package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.constants.enums.*;
import java.util.List;

public class Spell {

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

    // GETs

    // SETs

    // OVRs

    // METHs

}
