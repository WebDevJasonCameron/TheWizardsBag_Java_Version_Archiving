package com.backend.theWizardsBag.constants.enums;

public enum Rarity {
    COMMON("common"),
    UNCOMMON("uncommon"),
    RARE("rare"),
    VERY_RARE("very rare"),
    LEGENDARY("legendary"),
    ARTIFACT("artifact"),
    VARIES("varies"),
    UNKNOWN_RARITY("unknown rarity");

    private final String rarity;

    Rarity(String rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return rarity;
    }
}
