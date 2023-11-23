package com.backend.theWizardsBag.constants.enums;

public enum Schools {
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

    Schools(String size) {
        this.school = size;
    }

    @Override
    public String toString() {
        return school;
    }
}
