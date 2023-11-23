package com.backend.theWizardsBag.constants.enums;

public enum SpellLevels {
    ZERO("cantrip"),
    ONE("1st"),
    TWO("2nd"),
    THREE("3rd"),
    FOUR("4th"),
    FIVE("5th"),
    SIX("6th"),
    SEVEN("7th"),
    EIGHT("8th"),
    NINE("9th");

    private final String spellLevel;

    SpellLevels(String spellLevel) {
        this.spellLevel = spellLevel;
    }

    @Override
    public String toString() {
        return spellLevel;
    }
}
