CREATE SEQUENCE class_seq start with 0;

CREATE TABLE rpg_classes (
                       class_id bigint NOT NULL DEFAULT nextval('class_seq'),
                       class_name varchar(255) NOT NULL ,

                       PRIMARY KEY (class_id)
);

ALTER SEQUENCE class_seq OWNED BY rpg_classes.class_id;

INSERT INTO rpg_classes (class_name)
VALUES
    ('rouge'),
    ('fighter'),
    ('cleric'),
    ('ranger'),
    ('druid'),
    ('warlock'),
    ('paladin'),
    ('monk'),
    ('wizard'),
    ('barbarian'),
    ('magician'),
    ('artificer'),
    ('bard'),
    ('sorcerer')
;