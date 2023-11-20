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
    ('consumable'),     --   Depleted after a single use (e.g., potions, scrolls).
    ('cursed'),         --   Has a negative magical effect or drawback.
    ('focus'),          --   Used as a spellcasting focus for certain classes.
    ('held'),           --   Items held in the hand, such as weapons or shields.
    ('magical'),        --   Possesses magical properties or enhancements.
    ('melee'),          --   Designed for close-quarters combat.
    ('ranged'),         --   Used for attacks at a distance.
    ('ring'),           --   A magical ring with specific effects.
    ('rod'),            --   A magical rod with specific effects.
    ('scroll'),         --   A magical scroll containing a spell that can be cast.
    ('shield'),         --   A protective item.
    ('staff'),          --   A magical staff with specific effects.
    ('wand'),           --   A magical wand with specific effects.
    ('wondrous item'),  --   A magical item with various effects or properties.
    ('heavy'),          --   Particularly heavy, affecting movement.
    ('finesse'),        --   Weapons that can use either Strength or Dexterity for attack and damage rolls.
    ('versatile'),      --   Weapons that can be used one- or two-handed.
    ('thrown'),         --   Weapons that can be thrown, such as throwing axes or daggers.
    ('utility'),        --   Indicates an item primarily used for non-combat purposes or special functions.
    ('warding');        --   Suggests an item that provides protection or defense against specific effects.