CREATE SEQUENCE items_seq start with 1;

CREATE TABLE items (
                          item_id bigint NOT NULL DEFAULT nextval('items_seq'),
                          name varchar(255) NOT NULL,
                          ttrpg varchar(255),                           --  5
                          rarity varchar(255),                          -- rarity
                          renowned_quality varchar(255),                -- renowned_quality
                          requires_attunement bool,                     -- req_attunement
                          has_charges bool,                             --
                          is_cursed bool,
                          cost double precision,
                          weight varchar(255),
                          description text,
                          image_url varchar(255),
                          magic_bonus_plus_1 bool,                      -- Read the description to get these
                          magic_bonus_plus_2 bool,
                          magic_bonus_plus_3 bool,
                          notes text,                                   -- If doc has "Notes:"

                          source_id bigint,

                          PRIMARY KEY (item_id)
);

ALTER SEQUENCE items_seq OWNED BY items.item_id;

ALTER SEQUENCE items_seq RESTART WITH 1;

/*
INSERT INTO items (name, ttrpg, rarity, renowned_quality, requires_attunement, has_charges, is_cursed, cost, weight, description, image_url)
VALUES
    ('TEST Name', 'TEST TTRPG', 'TEST RARITY', 'TEST RENOWNED QUALITY', false, false, false, 2.55, 'TEST WEIGHT', 'TEST DESCRIPTION', 'TEST IMAGE URL');

 */