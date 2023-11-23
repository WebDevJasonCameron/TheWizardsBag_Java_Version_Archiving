package com.backend.theWizardsBag.constants.enums;

public enum SpellSavesRequired {
    STRENGTH("strength"),
    DEXTERITY("dexterity"),
    CONSTITUTION("constitution"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom"),
    CHARISMA("charisma");

    private final String savesRequired;

    SpellSavesRequired(String savesRequired) {
        this.savesRequired = savesRequired;
    }

    @Override
    public String toString() {
        return savesRequired;
    }
}
