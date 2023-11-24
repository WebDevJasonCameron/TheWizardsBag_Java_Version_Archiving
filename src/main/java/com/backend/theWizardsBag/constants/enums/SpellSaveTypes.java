package com.backend.theWizardsBag.constants.enums;

public enum SpellSaveTypes {
    STRENGTH("strength"),
    DEXTERITY("dexterity"),
    CONSTITUTION("constitution"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom"),
    CHARISMA("charisma");

    private final String saveTypes;

    SpellSaveTypes(String saveTypes) {
        this.saveTypes = saveTypes;
    }

    @Override
    public String toString() {
        return saveTypes;
    }
}
