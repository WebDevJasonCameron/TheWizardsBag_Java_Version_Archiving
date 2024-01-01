CREATE SEQUENCE damagetype_seq start with 0;

CREATE TABLE damagetypes (
                       damagetype_id bigint NOT NULL DEFAULT nextval('damagetype_seq'),
                       damage varchar(50) NOT NULL,

                       PRIMARY KEY (damagetype_id)
);

ALTER SEQUENCE damagetype_seq OWNED BY damagetypes.damagetype_id;

INSERT INTO damagetypes (damage)
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

