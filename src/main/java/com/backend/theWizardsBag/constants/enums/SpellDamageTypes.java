package com.backend.theWizardsBag.constants.enums;

public enum SpellDamageTypes {
    ACID("melee"),
    BLUDGEONING("ranged"),
    COLD("cold"),
    FIRE("fire"),
    FORCE("force"),
    LIGHTNING("lightning"),
    NECROTIC("necrotic"),
    PIERCING("piercing"),
    POISON("poison"),
    PSYCHIC("psychic"),
    RADIANT("radiant"),
    SLASHING("slashing"),
    SHORTBOW("shortbow"),
    LONGBOW("longbow"),
    ONE_HANDED_MELEE("one handed melee"),
    UNARMED_ATTACKS("unarmed attacks"),
    NATURAL_ATTACKS("natural attacks"),
    MELEE_WEAPON_ATTACKS("melee weapon attacks");

    private final String damageTypes;

    SpellDamageTypes(String damageTypes) {
        this.damageTypes = damageTypes;
    }

    @Override
    public String toString() {
        return damageTypes;
    }
}
