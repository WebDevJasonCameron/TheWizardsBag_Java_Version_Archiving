CREATE SEQUENCE tag_seq start with 1;

CREATE TABLE tags (
                             tag_id bigint NOT NULL DEFAULT nextval('tag_seq'),
                             tag_name varchar(50) NOT NULL UNIQUE,
                             tag_type varchar(50) NOT NULL,

                             PRIMARY KEY (tag_id)
);

ALTER SEQUENCE tag_seq OWNED BY tags.tag_id;

ALTER SEQUENCE tag_seq RESTART WITH 1;


INSERT INTO tags (tag_name, tag_type)
VALUES

    ('Ammunition', 'na'),       --   Used for ranged weapons.
    ('Armor', 'na'),            --   Provides protection.
    ('Artificer', 'item'),

    ('Bane', 'item'),
    ('Banishment', 'both'),
    ('Bard', 'item'),
    ('Belt', 'item'),
    ('Buff', 'both'),

    ('Charmed', 'spell'),
    ('Combat', 'both'),
    ('Communication', 'both'),
    ('Compulsion', 'spell'),
    ('Consumable', 'item'),     --   Depleted after a single use (e.g., potions, scrolls).
    ('Container', 'item'),
    ('Control', 'both'),
    ('Creation', 'both'),
    ('Cursed', 'item'),         --   Has a negative magical Effect or drawback.

    ('Damage', 'both'),
    ('Debuff', 'both'),
    ('Deception', 'both'),
    ('Detection', 'both'),
    ('Divination', 'item'),
    ('Dunamancy', 'spell'),


    ('Eldritch Machine', 'item'),
    ('Enchantment', 'item'),
    ('Environment', 'spell'),
    ('Evocation', 'item'),
    ('Exploration', 'both'),
    ('Eyewear', 'item'),

    ('Finesse', 'na'),          --   Weapons that can use either Strength or Dexterity for attack and damage rolls.
    ('Focus', 'item'),          --   Used as a spellcasting focus for certain classes.
    ('Footwear', 'item'),
    ('Foreknowledge', 'both'),
    ('Foresight', 'spell'),

    ('Handwear', 'item'),
    ('Healing', 'both'),
    ('Held', 'na'),             --   Items held in the hand, such as weapons or shields.
    ('Headwear', 'item'),
    ('Heavy', 'na'),            --   Particularly heavy, affecting movement.

    ('Instrument', 'item'),

    ('Jewelry', 'item'),

    ('Magical', 'na'),          --   Possesses magical properties or enhancements.
    ('Melee', 'na'),            --   Designed for close-quarters combat.
    ('Movement', 'both'),

    ('Necklace', 'item'),
    ('Negates Difficult Terrain', 'item'),
    ('Negation', 'both'),

    ('Outerwear', 'item'),

    ('Ranged', 'na'),           --   Used for attacks at a distance.
    ('Ring', 'na'),             --   A magical ring with specific effects.
    ('Rod', 'na'),              --   A magical rod with specific effects.

    ('Sangromancy', 'spell'),
    ('Sentient', 'item'),
    ('Scroll', 'na'),           --   A magical scroll containing a spell that can be cast.
    ('Scrying', 'both'),
    ('Shield', 'na'),           --   A protective Item.
    ('Shapechanging', 'both'),
    ('Social', 'both'),
    ('Special', 'spell'),
    ('Subclass Feature', 'item'),
    ('Summoning', 'both'),
    ('Symbiotic', 'item'),
    ('Staff', 'na'),            --   A magical staff with specific effects.


    ('Tag', 'item'),
    ('Tags', 'item'),
    ('Teleportation', 'both'),
    ('Thrown', 'na'),           --   Weapons that can be thrown, such as throwing axes or daggers.
    ('Transmutation', 'item'),

    ('Versatile', 'na'),        --   Weapons that can be used one- or two-handed.
    ('Vestige of divergence', 'item'),

    ('Utility', 'both'),        --   Indicates an Item primarily used for non-combat purposes or special functions.

    ('Wand', 'na'),             --   A magical wand with specific effects.
    ('Warding', 'both'),        --   Suggests an Item that provides protection or defense against specific effects.
    ('Warm', 'item'),
    ('Wondrous Item', 'na'),    --   A magical Item with various effects or properties.
    ('Wristwear', 'item')
;


