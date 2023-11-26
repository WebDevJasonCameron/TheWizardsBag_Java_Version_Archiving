package com.backend.theWizardsBag.constants.enums;

public enum SpellLevels {
    ZERO("cantrip"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9");

    private final String spellLevel;

    SpellLevels(String spellLevel) {
        this.spellLevel = spellLevel;
    }

    @Override
    public String toString() {
        return spellLevel;
    }
}
