CREATE SEQUENCE spell_class_seq start 10000;

CREATE TABLE spell_classes (
                                  spell_class_id bigint NOT NULL DEFAULT nextval('spell_class_seq'),
                                  spells_spell_id bigint,
                                  classes_class_id bigint,
                                  FOREIGN KEY (spells_spell_id) REFERENCES spells(spell_id),
                                  FOREIGN KEY (classes_class_id) REFERENCES rpg_classes(class_id)
);

ALTER SEQUENCE spell_class_seq OWNED BY spell_classes.spell_class_id;

INSERT INTO spell_classes (spells_spell_id, classes_class_id)
VALUES
    (10000, 10013),
    (10000, 10008)
;