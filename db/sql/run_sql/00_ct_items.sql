CREATE SEQUENCE items_seq start with 1;

CREATE TABLE items (
                          item_id bigint NOT NULL DEFAULT nextval('items_seq'),
                          item_name varchar(255) NOT NULL,
                          item_ttrpg varchar(255),                           --  5
                          item_rarity varchar(255),                          -- rarity
                          item_renowned_quality varchar(255),                -- renowned_quality
                          item_requires_attunement bool,                     -- req_attunement
                          item_has_charges bool,                             -- Read description for "charges"
                          item_is_cursed bool,
                          item_cost double precision,
                          item_weight varchar(255),
                          item_description text,
                          item_image_url varchar(255),
                          item_magic_bonus_plus_1 bool,                      -- Read the description to get these
                          item_magic_bonus_plus_2 bool,
                          item_magic_bonus_plus_3 bool,
                          item_description_notes text,                        -- If doc has "Notes:"

                          item_source_id bigint,

                          PRIMARY KEY (item_id)
);

ALTER SEQUENCE items_seq OWNED BY items.item_id;

ALTER SEQUENCE items_seq RESTART WITH 1;

/*
INSERT INTO items (name, ttrpg, rarity, renowned_quality, requires_attunement, has_charges, is_cursed, cost, weight, description, image_url)
VALUES
    ('TEST Name', 'TEST TTRPG', 'TEST RARITY', 'TEST RENOWNED QUALITY', false, false, false, 2.55, 'TEST WEIGHT', 'TEST DESCRIPTION', 'TEST IMAGE URL');

 */