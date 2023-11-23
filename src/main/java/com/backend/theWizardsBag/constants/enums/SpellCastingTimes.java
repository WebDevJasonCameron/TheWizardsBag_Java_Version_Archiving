package com.backend.theWizardsBag.constants.enums;

public enum SpellCastingTimes {
    ONE_ACTION("1 Action"),
    ONE_BONUS_ACTION("1 Bonus Action"),
    ONE_REACTION("1 Reaction"),
    ONE_MINUTE("1 Minute"),
    TEN_MINUTES("10 Minutes"),
    ONE_HOUR("1 Hour"),
    EIGHT_HOURS("8 Hours"),
    TWELVE_HOURS("12 Hours"),
    TWENTY_FOUR_HOURS("24 Hours");

    private final String castingTimes;

    SpellCastingTimes(String castingTimes) {
        this.castingTimes = castingTimes;
    }

    @Override
    public String toString() {
        return castingTimes;
    }
}
