CREATE SEQUENCE types_seq start with 10000;

CREATE TABLE types (
                       type_id bigint NOT NULL DEFAULT nextval('types_seq'),
                       type varchar(255) NOT NULL ,
                       sub_type varchar(255) NOT NULL ,

                       PRIMARY KEY (type_id)
);

ALTER SEQUENCE types_seq OWNED BY types.type_id;

INSERT INTO types (type, sub_type)
VALUES
    ('weapon', ''),                     --   Weapons
    ('weapon', 'any'),
    ('weapon melee', ''),               --   Melee Weapons
    ('weapon melee', 'battleaxe'),
    ('weapon melee', 'club'),
    ('weapon melee', 'dagger'),
    ('weapon melee', 'double-bladed scimitar'),
    ('weapon melee', 'flail'),
    ('weapon melee', 'glaive'),
    ('weapon melee', 'greataxe'),
    ('weapon melee', 'greatclub'),
    ('weapon melee', 'greatsword'),
    ('weapon melee', 'halberd'),
    ('weapon melee', 'handaxe'),
    ('weapon melee', 'hoopak'),
    ('weapon melee', 'lance'),
    ('weapon melee', 'light hammer'),
    ('weapon melee', 'longsword'),
    ('weapon melee', 'mace'),
    ('weapon melee', 'maul'),
    ('weapon melee', 'morningstar'),
    ('weapon melee', 'pike'),
    ('weapon melee', 'quarterstaff'),
    ('weapon melee', 'rapier'),
    ('weapon melee', 'scimitar'),
    ('weapon melee', 'shortsword'),
    ('weapon melee', 'sickle'),
    ('weapon melee', 'spear'),
    ('weapon melee', 'trident'),
    ('weapon melee', 'war pick'),
    ('weapon melee', 'warhammer'),
    ('weapon melee', 'whip'),
    ('weapon melee', 'yklwa'),
    ('weapon ranged', ''),              --   Ranged Weapons
    ('weapon ranged', 'blowgun'),
    ('weapon ranged', 'crossbow, hand'),
    ('weapon ranged', 'crossbow, heavy'),
    ('weapon ranged', 'crossbow, light'),
    ('weapon ranged', 'hoopak (ranged)'),
    ('weapon ranged', 'longbow'),
    ('weapon ranged', 'shortbow'),
    ('weapon ranged', 'sling'),
    ('weapon ammunition', ''),          --   Ammunition Weapons
    ('weapon ammunition', 'dart'),
    ('weapon thrown', ''),              --   Thrown Weapons
    ('weapon thrown', 'boomerang'),
    ('weapon thrown', 'boomerang'),
    ('weapon thrown', 'javelin'),
    ('weapon thrown', 'net'),
    ('weapon firearms', ''),            --   Firearms Weapons
    ('weapon firearms', 'antimatter riffle'),
    ('weapon firearms', 'bad news'),
    ('weapon firearms', 'blunderbuss'),
    ('weapon firearms', 'firearm'),
    ('weapon firearms', 'hand mortar'),
    ('weapon firearms', 'laser pistol'),
    ('weapon firearms', 'laser rifle'),
    ('weapon firearms', 'musket'),
    ('weapon firearms', 'palm pistol'),
    ('weapon firearms', 'pepperbox'),
    ('weapon firearms', 'pistol'),
    ('weapon firearms', 'pistol, automatic'),
    ('weapon firearms', 'revolver'),
    ('weapon firearms', 'rifle, automatic'),
    ('weapon firearms', 'rifle, hunting'),
    ('weapon firearms', 'shotgun'),



    ('armor', ''),                      --   Armor
    ('armor', 'any'),
    ('light armor', 'any'),             --   Light Armor
    ('light armor', 'pride silk outfit'),
    ('light armor', 'padded'),
    ('light armor', 'leather'),
    ('light armor', 'studded leather'),
    ('medium armor', 'any'),            --   Med Armor
    ('medium armor', 'hide'),
    ('medium armor', 'chain shirt'),
    ('medium armor', 'scale mail'),
    ('medium armor', 'breastplate'),
    ('medium armor', 'half plate'),
    ('medium armor', 'spiked armor'),
    ('heavy armor', 'any'),             --   Heavy Armor
    ('heavy armor', 'ring mail'),
    ('heavy armor', 'chain mail'),
    ('heavy armor', 'splint'),
    ('heavy armor', 'plate'),
    ('shields', ''),                    --   Shields
    ('magical', ''),                    --   Magical Items
    ('magical', 'rings'),
    ('magical', 'wands'),
    ('magical', 'staves'),
    ('magical', 'rods'),
    ('magical', 'scrolls'),
    ('magical', 'potions'),
    ('magical', 'wondrous items'),
    ('adventure gear', ''),             --   Adventuring Gear
    ('adventure gear', 'backpacks'),
    ('adventure gear', 'bedrolls'),
    ('adventure gear', 'rations'),
    ('adventure gear', 'climbing gear'),
    ('adventure gear', 'camping supplies'),
    ('adventure gear', 'rope'),
    ('vehicles', ''),                   --   Vehicles
    ('vehicles', 'land vehicles'),
    ('vehicles', 'water vehicles'),
    ('vehicles', 'air vehicles'),
    ('clothing', ''),                   --   Clothing
    ('clothing', 'common clothing'),
    ('clothing', 'noble attire'),
    ('clothing', 'traveller cloaks'),
    ('clothing', 'hats and headgear'),
    ('artifacts', ''),                  --   Artifacts
    ('crafting', ''),                   --   Crafting
    ('crafting', 'alchemical substances'),
    ('crafting', 'crafting materials'),
    ('tools', ''),                      --   Tools
    ('tools', 'cooking utensils'),
    ('books', ''),                      --    Literature/books
    ('books', 'spellbooks'),
    ('books', 'tomes of knowledge'),
    ('books', 'scrolls'),
    ('books', 'ancient scrolls'),
    ('containers', ''),                 --   Containers
    ('containers', 'bags of holding'),
    ('containers', 'chests'),
    ('containers', 'pouches'),
    ('food', ''),                       --   Food
    ('food', 'beverages'),
    ('food', 'specialized food'),
    ('instruments', ''),                --   Instruments
    ('instruments', 'any'),
    ('instruments', 'musical instruments'),
    ('jewelry', ''),                    --   Jewelry
    ('jewelry', 'any'),
    ('jewelry', 'necklaces'),
    ('jewelry', 'bracelets'),
    ('jewelry', 'earrings'),
    ('jewelry', 'gemstones'),
    ('navigation', ''),                 --   Navigation
    ('navigation', 'maps'),
    ('navigation', 'compass'),
    ('navigation', 'nautical charts'),
    ('pets', ''),                       --   Pets
    ('pets', 'any'),
    ('pets', 'familiars'),
    ('pets', 'exotic pets'),
    ('poisons', ''),                    --   Poisons
    ('poisons', 'poison weapons'),
    ('poisons', 'ingestible poisons'),
    ('trophies', ''),                   --   Trophies
    ('trophies', 'monster trophies'),
    ('trophies', 'rare specimens'),
    ('documents', ''),                  --   Documents
    ('documents', 'any'),
    ('documents', 'letters'),
    ('documents', 'contracts'),
    ('documents', 'important documents'),
    ('mundane', ''),                    --   Mundane
    ('miscellaneous', '')               --   Miscellaneous
;