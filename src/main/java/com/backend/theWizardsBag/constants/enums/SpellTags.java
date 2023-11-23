package com.backend.theWizardsBag.constants.enums;

public enum SpellTags {
    BANISHMENT("banishment"),
    BUFF("buff"),
    CHARMED("charmed"),
    COMBAT("combat"),
    COMMUNICATION("communication"),
    COMPULSION("compulsion"),
    CONTROL("control"),
    CREATION("creation"),
    DAMAGE("damage"),
    DEBUFF("debuff"),
    DECEPTION("deception"),
    DETECTION("detection"),
    DUNAMANCY("dunamancy"),
    ENVIRONMENT("environment"),
    EXPLORATION("exploration"),
    FOREKNOWLEDGE("foreknowledge"),
    HEALING("healing"),
    MOVEMENT("movement"),
    NEGATION("negation"),
    PSIONIC("psionic"),
    SCRYING("scrying"),
    SHAPECHANGING("shapechanging"),
    SOCIAL("social"),
    SPECIAL("special"),
    SUMMONING("summoning"),
    TELEPORTATION("teleportation"),
    UTILITY("utility"),
    WARDING("warding");

    private final String spellTag;

    SpellTags(String spellTag) {
        this.spellTag = spellTag;
    }

    @Override
    public String toString() {
        return spellTag;
    }
}
