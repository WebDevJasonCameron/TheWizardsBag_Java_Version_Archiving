package com.backend.theWizardsBag.constants.enums;

public enum SpellAttackTypes {
    MELEE("melee"),
    RANGED("ranged");

    private final String attackTypes;

    SpellAttackTypes(String attackTypes) {
        this.attackTypes = attackTypes;
    }

    @Override
    public String toString() {
        return attackTypes;
    }
}
