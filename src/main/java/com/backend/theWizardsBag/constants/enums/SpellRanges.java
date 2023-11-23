package com.backend.theWizardsBag.constants.enums;

public enum SpellRanges {
    ONE_MILE("1 mile"),
    TEN_FEET("10 feet"),
    ONE_HUNDRED_TWENTY_FEET("120 feet"),
    ONE_HUNDRED_FIFTY_FEET("150 feet"),
    THIRTY_FEET("30 feet"),
    THREE_HUNDRED_FEET("300 feet"),
    FIVE_HUNDRED_FEET("500 feet"),
    SIXTY_FEET("60 feet"),
    NINETY_FEET("90 feet"),
    SELF_ONE_FOOT_HUNDRED_LINE("Self (100-foot line)"),
    SELF_TEN_FOOT_RADIUS("Self (10-foot radius)"),
    SELF_TEN_FOOT_RADIUS_SPHERE("Self (10-foot-radius sphere)"),
    SELF_FIFTEEN_FOOT_CONE("Self (15-foot cone)"),
    SELF_FIFTEEN_FOOT_CUBE("Self (15-foot cube)"),
    SELF_FIFTEEN_FOOT_RADIUS("Self (15-foot radius)"),
    SELF_SIXTY_FOOT_CONE("Self (60-foot cone)"),
    SELF("Self"),
    SPECIAL("Special"),
    TOUCH("Touch");

    private final String ranges;

    SpellRanges(String ranges) {
        this.ranges = ranges;
    }

    @Override
    public String toString() {
        return ranges;
    }
}
