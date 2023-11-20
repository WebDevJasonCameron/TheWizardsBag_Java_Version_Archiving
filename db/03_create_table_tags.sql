CREATE SEQUENCE tags_seq start with 10000;

CREATE TABLE tags (
                             tag_id bigint NOT NULL DEFAULT nextval('tags_seq'),
                             name varchar(50) NOT NULL,

                             PRIMARY KEY (tag_id)
);

ALTER SEQUENCE tags_seq OWNED BY tags.tag_id;

INSERT INTO tags (name)
VALUES
    ('TEST Name');