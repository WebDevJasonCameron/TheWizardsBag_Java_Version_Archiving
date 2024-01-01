CREATE SEQUENCE spell_damagetypes_seq start 1;

CREATE TABLE spell_damagetypes (
                                  spell_damagetype_id bigint NOT NULL DEFAULT nextval('spell_damagetypes_seq'),
                                  spells_spell_id bigint,
                                  damagetypes_damagetype_id bigint,
                                  FOREIGN KEY (spells_spell_id) REFERENCES spells(spell_id),
                                  FOREIGN KEY (damagetypes_damagetype_id) REFERENCES damagetypes(damagetype_id)
);

ALTER SEQUENCE spell_damagetypes_seq OWNED BY spell_damagetypes.spell_damagetype_id;

INSERT INTO spell_damagetypes (spells_spell_id,damagetypes_damagetype_id)
VALUES
    (1, 1)
;