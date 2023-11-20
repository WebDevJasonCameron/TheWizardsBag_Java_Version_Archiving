CREATE SEQUENCE types_seq start with 10000;

CREATE TABLE types (
                       type_id bigint NOT NULL DEFAULT nextval('types_seq'),
                       name varchar(255) NOT NULL UNIQUE ,

                       PRIMARY KEY (type_id)
);

ALTER SEQUENCE types_seq OWNED BY types.type_id;

INSERT INTO items (name)
VALUES
    ('weapon'),             --   Weapons
    ('melee'),
    ('ranged'),
    ('ammunition'),
    ('thrown'),
    ('firearms'),
    ('armor'),             --   Armor
    ('light'),             --   Light Armor
    ('padded'),
    ('leather'),
    ('studded leather'),
    ('medium'),            --   Med Armor
    ('hide'),
    ('chain shirt'),
    ('scale mail'),
    ('breastplate'),
    ('half plate'),
    ('heavy'),             --   Heavy Armor
    ('ring mail'),
    ('chain mail'),
    ('splint'),
    ('plate'),
    ('shields'),           --   Shields
    ('magical'),           --   Magical Items
    ('rings'),
    ('wands'),
    ('staves'),
    ('rods'),
    ('scrolls'),
    ('potions'),
    ('wondrous items'),
    ('adventure gear'),     --   Adventuring Gear
    ('backpacks'),
    ('bedrolls'),
    ('rations'),
    ('climbing gear'),
    ('camping supplies'),
    ('rope'),
    ('vehicles'),           --   Vehicles
    ('land vehicles'),
    ('water vehicles'),
    ('air vehicles'),
    ('clothing'),           --   Clothing
    ('common clothing'),
    ('noble attire'),
    ('traveller cloaks'),
    ('hats and headgear'),
    ('artifacts'),          --   Artifacts
    ('crafting'),           --   Crafting
    ('alchemical substances'),
    ('crafting materials'),
    ('tools'),              --   Tools
    ('cooking utensils'),
    ('books'),              --    Books
    ('spellbooks'),
    ('tomes of knowledge'),
    ('scrolls'),
    ('ancient scrolls'),
    ('containers'),         --   Containers
    ('bags of holding'),
    ('chests'),
    ('pouches'),
    ('food'),               --   Food
    ('beverages'),
    ('specialized food'),
    ('instruments'),        --   Instruments
    ('musical instruments'),
    ('jewelry'),            --   Jewelry
    ('necklaces'),
    ('bracelets'),
    ('earrings'),
    ('gemstones'),
    ('navigation'),         --   Maps
    ('maps'),
    ('compass'),
    ('nautical charts'),
    ('pets'),               --   Pets
    ('familiars'),
    ('exotic pets'),
    ('poisons'),            --   Poisons
    ('poison weapons'),
    ('ingestible poisons'),
    ('trophies'),           --   Trophies
    ('monster trophies'),
    ('rare specimens'),
    ('documents'),          --   Documents
    ('letters'),
    ('contracts'),
    ('important documents'),
    ('mundane'),            --   Mundane
    ('miscellaneous')      --   Miscellaneous
;