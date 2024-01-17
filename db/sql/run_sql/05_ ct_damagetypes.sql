CREATE SEQUENCE damagetype_seq start with 1;

CREATE TABLE damagetypes (
                       damagetype_id bigint NOT NULL DEFAULT nextval('damagetype_seq'),
                       damagetype_name varchar(50) NOT NULL,

                       PRIMARY KEY (damagetype_id)
);

ALTER SEQUENCE damagetype_seq OWNED BY damagetypes.damagetype_id;

ALTER SEQUENCE damagetype_seq RESTART WITH 1;


INSERT INTO damagetypes (damagetype_name)
VALUES
    ('Acid'),
    ('Bludgeoning'),
    ('Cold'),
    ('Fire'),
    ('Force'),
    ('Lightning'),
    ('Necrotic'),
    ('Piercing'),
    ('Poison'),
    ('Psychic'),
    ('Radiant'),
    ('Slashing'),
    ('Thunder'),
    ('Shortbow'),
    ('Longbow'),
    ('One-Handed Melee Attacks'),
    ('Unarmed Attacks'),
    ('Natural Attacks'),
    ('Melee Weapon Attacks')

;

