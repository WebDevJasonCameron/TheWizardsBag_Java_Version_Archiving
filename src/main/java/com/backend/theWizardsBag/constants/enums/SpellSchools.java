package com.backend.theWizardsBag.constants.enums;

public enum SpellSchools {
    ABJURATION("abjuration"),
    ALTERATION("alteration"),
    CONJURATION("conjuration"),
    DIVINATION("divination"),
    ENCHANTMENT("enchantment"),
    ILLUSION("illusion"),
    INVOCATION("invocation"),
    NECROMANCY("necromancy"),
    TRANSMUTATION("transmutation");

    private final String school;

    SpellSchools(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return school;
    }
}
