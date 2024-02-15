CREATE SEQUENCE source_seq start with 1;

CREATE TABLE sources (
                      source_id bigint NOT NULL DEFAULT nextval('source_seq'),
                      source_name varchar(50) NOT NULL UNIQUE,
                      source_publish_date date,
                      source_publisher varchar(250),
                      source_ttrpg varchar(250),

                      PRIMARY KEY (source_id)
);

ALTER SEQUENCE source_seq OWNED BY sources.source_id;

ALTER SEQUENCE source_seq RESTART WITH 1;


INSERT INTO sources (source_name, source_publish_date)
VALUES
    ('Acquisition Incorporate', '2019-06-18'),
    ('Adventure Atlas: The Mortuary', '2023-10-17'),
    ('Against the Giants', '1981-01-01'),
    ('Baldurs Gate Gazetteer', '2023-08-22'),
    ('Basic Rules, 5e', '2014-07-03'),
    ('Bigby Presents: Glory of Giants', '2023-08-15'),
    ('Candleeep Mysteries', '2021-03-16'),
    ('Critical Role', '2022-01-18'),
    ('Critical Role: Call of the Netherdeep', '2022-03-15'),
    ('Curse of Strahd: Character Options', '1800-01-01' ),
    ('Dead in Thay', '2014-04-01'),
    ('Divine Contention', '1800-01-01'),
    ('Domains of Delight: A Feywild Accessory', '2021-09-01'),
    ('Dragon of Icespire Peak', '1800-01-01'),
    ('Dragonlance: Shadow of the Dragon Queen', '2022-12-01'),
    ('Dragons of Stormwreck Isle', '2022-04-01'),
    ('Dungeon Masters Guid, 5e', '2014-12-09'),
    ('Dragons & Dragons vs. Rick and Morty', '2022-02-01'),
    ('Eberron: Rising from the Last War', '2019-11-19'),
    ('Elemental Evil Players Companion', '2015-01-01'),
    ('Explorers Guide to Wildermount', '2020-03-17'),
    ('Fizbans Treasury of Dragons', '2021-10-26'),
    ('Frozen Sick', '2020-03-17'),
    ('Ghosts of Saltmarsh', '2019-05-21'),
    ('Giants of the Star Forge', '2023-08-16'),
    ('Guildmasters Guide to Ravnica', '2018-11-20'),
    ('Hoard of the Dragon Queen', '2014-08-14'),
    ('Hunt for the Thessalhydra', '2019-05-01'),
    ('Icewind Dale: Rime of the Frostmaiden', '2020-09-15'),
    ('Infernal Machine Rebuild', '2019-11-01'),
    ('Intro to Stormwreck Isle', '2022-04-21'),
    ('Journeys through the Radiant Citadel', '2022-07-19'),
    ('Keys from the Golden Vault', '2023-02-21'),
    ('Legendary Magic Items', '2023-03-31'),
    ('Lightning Keep', '2023-09-26'),
    ('Locathah Rising', '2019-09-19'),
    ('Lost Laboratory of Kwalish', '2018-11-10'),
    ('Lost Mine of Phandelver', '2014-01-01'),
    ('Misplaced Monsters: Volume One', '2023-05-02'),
    ('Monster Manual, 5e', '2022-05-10'),
    ('Monstrous Compendium Vol. 1: Spelljammer Creatures', '2022-05-21'),
    ('Monstrous Compendium Vol. 2: Dragonlance Creatures', '2022-12-05'),
    ('Monstrous Compendium Vol. 3: Minecraft Creatures', '2023-03-28'),
    ('Monstrous Compendium Vol. 4: Eldraine Creatures', '2023-09-21'),
    ('Mordenkainen Presents: Monsters of the Multiverse', '2022-05-10'),
    ('Mordenkainens Tome of Foes', '2018-05-29'),
    ('Mordenkainens Fiendish Folio Volume 1', '2019-12-03'),
    ('Mythic Odysseys of Theros', '2020-07-21'),
    ('One Grung Above', '2017-10-11'),
    ('Out of the Abyss', '2015-09-01'),
    ('Phandelver and Below: The Shattered Obelisk', '2023-09-19'),
    ('Planescape: Adventures in the Multiverse', '2023-10-17'),
    ('Players Handbook, 5e', '2014-09-19'),
    ('Princes of the Apocalypse', '2015-04-07'),
    ('Prisoner 13', '2023-03-15'),
    ('Rise of Tiamat', '2014-10-21'),
    ('Rrakkma', '2018-05-29'),
    ('Sleeping Dragons Wake', '2019-09-04'),
    ('Spelljammer Academy', '2022-07-11'),
    ('Spelljammer: Adventures in Space', '2022-08-16'),
    ('Storm Kings Thunder', '2016-09-06'),
    ('Storm Lords Wrath', '2019-09-04'),
    ('Strixhaven: A Curriculum of Chaos', '2021-12-07'),
    ('Sword Coast Adventurers Guide', '2015-11-03'),
    ('Tal Dorei Campaign Setting Reborn', '2022-01-18'),
    ('Tales from the Yawning Portal', '2017-04-04'),
    ('The Book of Many Things', '2022-08-01'),
    ('The Forge of Fury', '2000-11-01'),
    ('The Hidden Shrine of Tamoachan', '1980-01-01'),
    ('The Sunless Citadel', '2017-01-01'),
    ('The Tortle Package', '2017-09-15'),
    ('The Vecna Dossier', '2022-06-01'),
    ('The Wild Beyond the Witchlight', '2021-09-21'),
    ('Thieves Gallery', '2023-03-06'),
    ('Tomb of Annihilation', '2017-09-08'),
    ('Tomb of Horrors', '1975-01-01'),
    ('Tyranny of Dragons', '2014-08-01'),
    ('Van Richtens Guide to Ravenloft', '2021-05-18'),
    ('Volos Guide to Monsters', '2016-11-15'),
    ('Waterdeep: Dragon Heist', '2018-09-18'),
    ('Waterdeep: Dungeon of the Mad Mage', '2018-11-20'),
    ('Wayfinders Guide to Eberron', '2018-07-24'),
    ('White Plume Mountain', '1979-01-01'),
    ('Xanathars Guide to Everything', '2017-11-21')
;

ALTER TABLE IF EXISTS spells
    ADD FOREIGN KEY (spell_source_id)
    REFERENCES sources (source_id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS item
    ADD FOREIGN KEY (item_source_id)
        REFERENCES sources (source_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION;