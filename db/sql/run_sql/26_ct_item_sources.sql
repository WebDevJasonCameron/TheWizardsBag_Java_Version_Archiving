CREATE SEQUENCE item_source_seq start 1;

CREATE TABLE item_sources (
                                item_source_id bigint NOT NULL DEFAULT nextval('item_source_seq'),
                                items_item_id bigint,
                                sources_source_id bigint,
                                FOREIGN KEY (items_item_id) REFERENCES items(item_id),
                                FOREIGN KEY (sources_source_id) REFERENCES sources(source_id)
);

ALTER SEQUENCE item_source_seq OWNED BY item_sources.item_source_id;