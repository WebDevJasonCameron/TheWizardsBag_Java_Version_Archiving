CREATE SEQUENCE item_condition_seq start 1;

CREATE TABLE item_conditions (
                            item_condition_id bigint NOT NULL DEFAULT nextval('item_condition_seq'),
                            items_item_id bigint,
                            conditions_condition_id bigint,
                            FOREIGN KEY (items_item_id) REFERENCES items(item_id),
                            FOREIGN KEY (conditions_condition_id) REFERENCES conditions(condition_id)
);

ALTER SEQUENCE item_condition_seq OWNED BY item_conditions.item_condition_id;

ALTER SEQUENCE item_condition_seq RESTART WITH 1;
