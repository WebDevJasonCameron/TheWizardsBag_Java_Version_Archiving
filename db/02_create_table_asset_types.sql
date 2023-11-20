CREATE SEQUENCE assets_seq start with 10000;

CREATE TABLE asset_types (
                       asset_type_id bigint NOT NULL DEFAULT nextval('assets_seq'),
                       name varchar(50) NOT NULL,

                       PRIMARY KEY (asset_type_id)
);