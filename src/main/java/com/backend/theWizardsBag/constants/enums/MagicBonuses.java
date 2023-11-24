package com.backend.theWizardsBag.constants.enums;

public enum MagicBonuses {
    PLUS_ONE("+1"),
    PLUS_TWO("+2"),
    PLUS_THREE("+3");

    private final String magicBonuses;

    MagicBonuses(String magicBonuses) {
        this.magicBonuses = magicBonuses;
    }

    @Override
    public String toString() {
        return magicBonuses;
    }
}
