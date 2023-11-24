CREATE SEQUENCE spell_seq start 10000;

CREATE TABLE spells (
                            spell_id bigint NOT NULL DEFAULT nextval('spell_seq'),
                            level varchar(255) NOT NULL UNIQUE,
                            casting_time varchar(255),
                            range_area varchar(255),
                            Component_visual bool NOT NULL,
                            Component_semantic bool NOT NULL,
                            Component_material bool NOT NULL,
                            Component_materials varchar(255),
                            duration varchar(255),
                            concentration bool NOT NULL,
                            ritual bool NOT NULL,
                            school varchar(255),
                            attack_type varchar(255),
                            save_type varchar(255),
                            damage_type varchar(255),
                            description varchar(255),
                            image_url varchar(255),

                            -- conditions list

                            -- availability list

                            -- spell tags list

                            -- source
                            source_id bigint,

                            PRIMARY KEY (spell_id)
);

ALTER SEQUENCE spell_seq OWNED BY spells.spell_id;

