CREATE SEQUENCE items_seq start with 10000;

CREATE TABLE items (
                          item_id bigint NOT NULL DEFAULT nextval('items_seq'),
                          name varchar(255) NOT NULL,
                          ttrpg varchar(255),
                          rarity varchar(255),
                          renowned_quality varchar(255),
                          req_attunement bool,
                          is_cursed bool,
                          price double precision,
                          description text,
                          source varchar(255) DEFAULT NULL,

                          PRIMARY KEY (item_id)
);

ALTER SEQUENCE items_seq OWNED BY items.item_id;

INSERT INTO items (name, ttrpg, rarity, renowned_quality, req_attunement, is_cursed, price, description, source)
VALUES
    ('TEST Name', 'TEST TTRPG', 'TEST RARITY', 'TEST RENOWNED QUALITY', false, false, 2.55, 'TEST DESCRIPTION', 'TEST SOURCE');