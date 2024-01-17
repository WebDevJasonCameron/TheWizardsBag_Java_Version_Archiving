CREATE SEQUENCE spell_seq start 1;

CREATE TABLE spells (
                            spell_id bigint NOT NULL DEFAULT nextval('spell_seq'),
                            spell_name varchar(999) NOT NULL UNIQUE ,
                            spell_level varchar(255) NOT NULL,
                            spell_casting_time varchar(255),
                            spell_range_area varchar(255),
                            spell_component_visual bool NOT NULL,
                            spell_component_semantic bool NOT NULL,
                            spell_component_material bool NOT NULL,
                            spell_component_materials varchar(999),
                            spell_duration varchar(255),
                            spell_concentration bool NOT NULL,
                            spell_ritual bool NOT NULL,
                            spell_school varchar(255),
                            spell_save_type varchar(255),
                            spell_description text,
                            spell_image_url varchar(255),

                            -- source (Gotten from the sources table)
                            spell_source_id bigint,
                            FOREIGN KEY (spell_source_id) REFERENCES sources(source_id),

                            -- condition list
                            -- availability (class) list
                            -- tags list
                            -- type list

                            PRIMARY KEY (spell_id)
);

ALTER SEQUENCE spell_seq OWNED BY spells.spell_id;

ALTER SEQUENCE spell_seq RESTART WITH 1;


/*
INSERT INTO spells (name, level, casting_time, range_area, component_visual, component_semantic, component_material, component_materials, duration, concentration, ritual, school, save_type, description, image_url, source_id)
VALUES
    ('Acid Splash', 'cantrip', '1 action', '60 feet', true, true, false, '', 'instantaneous', false, false, 'conjuration', 'DEX', 'You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage. This spell''s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).', '', 5),

    ('Alarm', '1', '1 action', '30 feet', true, true, true, 'a tiny bell and a piece of fine silver wire', '8 hour', false, true, 'abjuration', '', 'You set an alarm against unwanted intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot cube. Until the spell ends, an alarm alerts you whenever a Tiny or larger creature touches or enters the warded area. When you cast the spell, you can designate creatures that won''t set off the alarm. You also choose whether the alarm is mental or audible.\n\nA mental alarm alerts you with a ping in your mind if you are within 1 mile of the warded area. This ping awakens you if you are sleeping.\n\nAn audible alarm produces the sound of a hand bell for 10 seconds within 60 feet.', '', 5),

    ('Animal Friendship', '1', '1 action', '30 feet', true, true, true, 'a morsel of food', '24 hours', false, false, 'enchantment', 'WIS', 'This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. If the beast''s Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for the spell''s duration. If you or one of your companions harms the target, the spell ends.', '', 5)
    ;

 */