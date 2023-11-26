package com.backend.theWizardsBag.constants.enums;

public enum SpellCastingTimes {
    ONE_ACTION("1 action"),
    ONE_BONUS_ACTION("1 bonus action"),
    ONE_REACTION("1 reaction"),
    ONE_MINUTE("1 minute"),
    TEN_MINUTES("10 minutes"),
    ONE_HOUR("1 hour"),
    EIGHT_HOURS("8 hours"),
    TWELVE_HOURS("12 hours"),
    TWENTY_FOUR_HOURS("24 hours");

    private final String castingTimes;

    SpellCastingTimes(String castingTimes) {
        this.castingTimes = castingTimes;
    }

    @Override
    public String toString() {
        return castingTimes;
    }
}
