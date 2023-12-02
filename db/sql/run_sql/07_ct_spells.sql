CREATE SEQUENCE spell_seq start 10000;

CREATE TABLE spells (
                            spell_id bigint NOT NULL DEFAULT nextval('spell_seq'),
                            name varchar(255) NOT NULL UNIQUE ,
                            level varchar(255) NOT NULL UNIQUE,
                            casting_time varchar(255),
                            range_area varchar(255),
                            Component_visual bool NOT NULL,
                            Component_semantic bool NOT NULL,
                            Component_material bool NOT NULL,
                            Component_materials varchar(255),
                            duration varchar(255),
                            concentration bool NOT NULL,
                            ritual bool NOT NULL,
                            school varchar(255),
                            save_type varchar(255),
                            description text,
                            image_url varchar(255),

                            -- source (Gotten from the sources table)
                            source_id bigint,
                            FOREIGN KEY (source_id) REFERENCES sources(source_id),

                            -- The following are created in Junction Tables
                            -- availability list
                            -- spell tags list
                            -- damage type list

                            PRIMARY KEY (spell_id)
);

ALTER SEQUENCE spell_seq OWNED BY spells.spell_id;


INSERT INTO spells (name, level, casting_time, range_area, Component_visual, Component_semantic, Component_material, Component_materials, duration, concentration, ritual, school,  save_type, description, image_url, source_id)
VALUES
    ('Acid Splash', 'cantrip', '1 action', '60 feet', true, true, false, '', 'instantaneous', false, false, 'conjuration', 'DEX', 'You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage. This spell''s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).', '', 10004),
    ('Alarm', '1', '1 action', '30 feet', true, true, true, 'a tiny bell and a piece of fine silver wire', '8 hour', false, true, 'abjuration', 'DEX', 'You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage. This spell''s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).', '', 10004),
    ('Acid Splash', 'cantrip', '1 action', '60 feet', true, true, false, '', 'instantaneous', false, false, 'conjuration', 'DEX', 'You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage. This spell''s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).', '', 10004)
    ;