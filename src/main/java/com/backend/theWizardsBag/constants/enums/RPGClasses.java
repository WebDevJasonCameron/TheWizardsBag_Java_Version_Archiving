package com.backend.theWizardsBag.constants.enums;

public enum RPGClasses {
    ROGUE("rogue"),
    FIGHTER("fighter"),
    CLERIC("cleric"),
    RANGER("ranger"),
    DRUID("druid"),
    WARLOCK("warlock"),
    PALADIN("paladin"),
    MONK("monk"),
    WIZARD("wizard"),
    BARBARIAN("barbarian"),
    MAGICIAN("magician"),
    ARTIFICER("artificer"),
    BARD("bard");

    private final String rpgClasses;

    RPGClasses(String rpgClasses) {
        this.rpgClasses = rpgClasses;
    }

    @Override
    public String toString() {
        return rpgClasses;
    }
}
