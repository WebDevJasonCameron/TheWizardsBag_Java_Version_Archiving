CREATE SEQUENCE item_type_seq start 10000;

CREATE TABLE item_types (
                            item_type_id bigint NOT NULL DEFAULT nextval('item_type_seq'),
                            items_item_id bigint,
                            types_type_id bigint,
                            FOREIGN KEY (item_type_id) REFERENCES items(item_id),
                            FOREIGN KEY (types_type_id) REFERENCES types(type_id)
);

