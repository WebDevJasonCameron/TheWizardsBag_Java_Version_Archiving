package com.backend.theWizardsBag.models;

public class Item {

    // ATTs
    private int itemId;                    //   auto
    private String name;
    private String ttrpg;                   //   enum
    private String rarity;
    private String renownedQuality;        //   enum
    private boolean requiresAttunement;
    private boolean isCursed;
    private double price;
    private String description;
    private String imageUrl;

    // LISTs
    /**
     * types
     * tags
     * notes
     * attached_spells
     * effects
     */

    // OBJs
    private String source;                  //   obj


}
