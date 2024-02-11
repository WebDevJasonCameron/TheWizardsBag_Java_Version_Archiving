CREATE SEQUENCE type_seq start with 1;

CREATE TABLE types (
                       type_id bigint NOT NULL DEFAULT nextval('type_seq'),
                       type_name varchar(255) NOT NULL ,
                       type_sub_type varchar(255) NOT NULL ,

                       PRIMARY KEY (type_id)
);

ALTER SEQUENCE type_seq OWNED BY types.type_id;

ALTER SEQUENCE type_seq RESTART WITH 1;


INSERT INTO types (type_name, type_sub_type)
VALUES
    ('weapon', ''),                     --   Weapons
    ('weapon melee', ''),               --   Melee Weapons
    ('weapon melee', 'axe'),
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
    ('weapon melee', 'hammer'),
    ('weapon melee', 'knife'),
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
    ('weapon melee', 'staff'),
    ('weapon melee', 'spear'),
    ('weapon melee', 'sword'),
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
    ('weapon ammunition', 'arrow'),
    ('weapon thrown', ''),              --   Thrown Weapons
    ('weapon thrown', 'boomerang'),
    ('weapon thrown', 'javelin'),
    ('weapon thrown', 'net'),
    ('weapon firearms', ''),            --   Firearms Weapons
    ('weapon firearms', 'antimatter rifle'),
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
    ('light armor', ''),             --   Light Armor
    ('light armor', 'pride silk outfit'),
    ('light armor', 'padded'),
    ('light armor', 'leather'),
    ('light armor', 'studded leather'),
    ('medium armor', ''),            --   Med Armor
    ('medium armor', 'hide'),
    ('medium armor', 'chain shirt'),
    ('medium armor', 'scale mail'),
    ('medium armor', 'breastplate'),
    ('medium armor', 'half plate'),
    ('medium armor', 'spiked armor'),
    ('heavy armor', ''),             --   Heavy Armor
    ('heavy armor', 'ring mail'),
    ('heavy armor', 'chain mail'),
    ('heavy armor', 'splint'),
    ('heavy armor', 'plate'),
    ('shield', ''),                    --   Shields
    ('magical', ''),                    --   Magical Items
    ('magical', 'ring'),
    ('magical', 'wand'),
    ('magical', 'staves'),
    ('magical', 'rod'),
    ('magical', 'scroll'),
    ('magical', 'potion'),
    ('magical', 'wondrous items'),
    ('magical', 'spellcasting focus'),
    ('adventure gear', ''),             --   Adventuring Gear
    ('adventure gear', 'backpacks'),
    ('adventure gear', 'bedrolls'),
    ('adventure gear', 'rations'),
    ('adventure gear', 'climbing gear'),
    ('adventure gear', 'camping supplies'),
    ('adventure gear', 'rope'),
    ('adventure gear', 'lantern'),
    ('adventure gear', 'light'),
    ('vehicle', ''),                   --   Vehicles
    ('vehicle', 'land vehicles'),
    ('vehicle', 'water vehicles'),
    ('vehicle', 'air vehicles'),
    ('vehicle', 'mount'),
    ('clothes', ''),                   --   Clothing
    ('clothes', 'common clothing'),
    ('clothes', 'noble attire'),
    ('clothes', 'traveller cloaks'),
    ('clothes', 'boots'),
    ('clothes', 'cloak'),
    ('clothes', 'headband'),
    ('clothes', 'cape'),
    ('clothes', 'bracers'),
    ('clothes', 'belt'),
    ('clothes', 'hats and headgear'),
    ('clothes', 'helm'),
    ('clothes', 'gloves'),
    ('clothes', 'gauntlets'),
    ('clothes', 'robes'),
    ('clothes', 'mantle'),
    ('clothes', 'slippers'),
    ('artifacts', ''),                  --   Artifacts
    ('crafting', ''),                   --   Crafting
    ('crafting', 'alchemical substances'),
    ('crafting', 'crafting materials'),
    ('tools', ''),                      --   Tools
    ('tools', 'cooking utensils'),
    ('book', ''),                      --    Literature/books
    ('book', 'spellbooks'),
    ('book', 'tomes of knowledge'),
    ('book', 'scrolls'),
    ('book', 'ancient scrolls'),
    ('container', ''),                 --   Containers
    ('container', 'bags of holding'),
    ('container', 'chests'),
    ('container', 'pouches'),
    ('food', ''),                       --   Food
    ('food', 'beverages'),
    ('food', 'specialized food'),
    ('instruments', ''),                --   Instruments
    ('instrument', 'musical instruments'),
    ('jewelry', ''),                    --   Jewelry
    ('jewelry', 'necklaces'),
    ('jewelry', 'bracelets'),
    ('jewelry', 'earrings'),
    ('jewelry', 'gemstones'),
    ('jewelry', 'amulet'),
    ('jewelry', 'gem'),
    ('jewelry', 'medallion'),
    ('navigation', ''),                 --   Navigation
    ('navigation', 'maps'),
    ('navigation', 'compass'),
    ('navigation', 'nautical charts'),
    ('pet', ''),                       --   Pets
    ('pet', 'familiars'),
    ('pet', 'exotic pets'),
    ('poison', ''),                    --   Poisons
    ('poison', 'poison weapons'),
    ('poison', 'ingestible poisons'),
    ('trophies', ''),                   --   Trophies
    ('trophies', 'monster trophies'),
    ('trophies', 'rare specimens'),
    ('document', ''),                  --   Documents
    ('document', 'letters'),
    ('document', 'contracts'),
    ('document', 'important documents'),
    ('mundane', ''),                    --   Mundane

    ('miscellaneous', ''),               --   Miscellaneous
    ('miscellaneous', 'gaming set'),
    ('miscellaneous', 'kit'),
    ('miscellaneous', 'supplies'),
    ('miscellaneous', 'trap'),
    ('miscellaneous', 'services'),
    ('miscellaneous', 'shackles'),


    ('gear and equipment', ''),
    ('gear and equipment', 'saddle'),
    ('gear and equipment', 'utility'),

    ('consumables', ''),

    ('building', ''),
    ('building', 'fortress')


;