CREATE SEQUENCE spell_class_seq start 1;

CREATE TABLE spell_classes (
                                  spell_class_id bigint NOT NULL DEFAULT nextval('spell_class_seq'),
                                  spells_spell_id bigint,
                                  classes_class_id bigint,
                                  FOREIGN KEY (spells_spell_id) REFERENCES spells(spell_id),
                                  FOREIGN KEY (classes_class_id) REFERENCES rpg_classes(class_id)
);

ALTER SEQUENCE spell_class_seq OWNED BY spell_classes.spell_class_id;

ALTER SEQUENCE spell_class_seq RESTART WITH 1;



/*
INSERT INTO spell_classes (spells_spell_id, classes_class_id)
VALUES
    (1, 14),
    (1, 9),
    (2, 4),
    (2, 9),
    (3, 13),
    (3, 5),
    (3, 4)
;

 */