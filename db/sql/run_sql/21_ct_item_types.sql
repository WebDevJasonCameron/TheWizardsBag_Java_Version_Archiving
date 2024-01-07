CREATE SEQUENCE item_type_seq start 1;

CREATE TABLE item_types (
                            item_type_id bigint NOT NULL DEFAULT nextval('item_type_seq'),
                            items_item_id bigint,
                            types_type_id bigint,
                            FOREIGN KEY (items_item_id) REFERENCES items(item_id),
                            FOREIGN KEY (types_type_id) REFERENCES types(type_id)
);

ALTER SEQUENCE item_type_seq OWNED BY item_types.item_type_id;

ALTER SEQUENCE item_type_seq RESTART WITH 1;
