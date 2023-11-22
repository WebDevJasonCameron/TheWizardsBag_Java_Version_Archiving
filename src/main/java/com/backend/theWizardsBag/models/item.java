package com.backend.theWizardsBag.models;

public class item {

    // ATTs
    private int item_id;                    //   auto
    private String name;
    private String ttrpg;                   //   enum
    private String rarity;
    private String renowned_quality;        //   enum
    private boolean requires_attunement;
    private boolean is_cursed;
    private double price;
    private String description;
    private String image_url;

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
