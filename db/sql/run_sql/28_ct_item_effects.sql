CREATE SEQUENCE item_effect_seq start 1;

CREATE TABLE item_effects (
                             item_effect_id bigint NOT NULL DEFAULT nextval('item_effect_seq'),
                             items_item_id bigint,
                             effects_effect_id bigint,
                             FOREIGN KEY (items_item_id) REFERENCES items(item_id),
                             FOREIGN KEY (effects_effect_id) REFERENCES effects(effect_id)
);

ALTER SEQUENCE item_effect_seq OWNED BY item_effects.item_effect_id;

ALTER SEQUENCE item_effect_seq RESTART WITH 1;
