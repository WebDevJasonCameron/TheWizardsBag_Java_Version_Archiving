CREATE SEQUENCE tags_seq start with 10000;

CREATE TABLE tags (
                             tag_id bigint NOT NULL DEFAULT nextval('tags_seq'),
                             name varchar(50) NOT NULL UNIQUE,

                             PRIMARY KEY (tag_id)
);

ALTER SEQUENCE tags_seq OWNED BY tags.tag_id;

INSERT INTO tags (name)
VALUES

    ('ammunition'),     --   Used for ranged weapons.
    ('armor'),          --   Provides protection.
    ('artificer'),

    ('bane'),
    ('banishment'),
    ('bard'),
    ('belt'),
    ('buff'),

    ('combat'),
    ('communication'),
    ('consumable'),     --   Depleted after a single use (e.g., potions, scrolls).
    ('container'),
    ('control'),
    ('creation'),
    ('cursed'),         --   Has a negative magical effect or drawback.

    ('damage'),
    ('deception'),
    ('detection'),
    ('debuf'),
    ('divination'),

    ('eldritch machine'),
    ('enchantment'),
    ('evocation'),
    ('exploration'),
    ('eyewear'),

    ('finesse'),        --   Weapons that can use either Strength or Dexterity for attack and damage rolls.

    ('focus'),          --   Used as a spellcasting focus for certain classes.
    ('footwear'),
    ('foreknowledge'),

    ('healing'),
    ('held'),           --   Items held in the hand, such as weapons or shields.
    ('headwear'),
    ('heavy'),          --   Particularly heavy, affecting movement.

    ('instrument'),

    ('jewelry'),

    ('magical'),        --   Possesses magical properties or enhancements.
    ('melee'),          --   Designed for close-quarters combat.
    ('movement'),

    ('necklace'),
    ('negates difficult terrain'),
    ('negation'),

    ('outerwear'),

    ('ranged'),         --   Used for attacks at a distance.
    ('ring'),           --   A magical ring with specific effects.
    ('rod'),            --   A magical rod with specific effects.

    ('sentient'),
    ('scroll'),         --   A magical scroll containing a spell that can be cast.
    ('shield'),         --   A protective item.
    ('shapechanging'),
    ('social'),
    ('subclass feature'),
    ('summoning'),
    ('symbiotic'),
    ('staff'),          --   A magical staff with specific effects.
    ('scrying'),

    ('tag'),
    ('tags'),
    ('teleportation'),
    ('thrown'),         --   Weapons that can be thrown, such as throwing axes or daggers.
    ('transmutation'),

    ('versatile'),      --   Weapons that can be used one- or two-handed.
    ('vestige of divergence'),

    ('utility'),        --   Indicates an item primarily used for non-combat purposes or special functions.

    ('wand'),           --   A magical wand with specific effects.
    ('warding'),        --   Suggests an item that provides protection or defense against specific effects.
    ('warm'),
    ('wondrous item'),  --   A magical item with various effects or properties.
    ('wristwear')
;


