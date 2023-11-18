CREATE SEQUENCE items_seq start with 10000;

CREATE TABLE items (
                          item_id bigint NOT NULL DEFAULT nextval('items_seq'),
                          name varchar(50) NOT NULL,
                          source varchar(50) DEFAULT NULL,
                        -- More Later
                          PRIMARY KEY (item_id)
);

ALTER SEQUENCE items_seq OWNED BY items.item_id;

INSERT INTO items (item_id, name, source)
VALUES
    (0, 'TEST Name', 'TEST SOURCE');