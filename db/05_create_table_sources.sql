CREATE SEQUENCE sources_seq start with 10000;

CREATE TABLE sources (
                      source_id bigint NOT NULL DEFAULT nextval('sources_seq'),
                      name varchar(50) NOT NULL UNIQUE,
                      publish_date date,

                      PRIMARY KEY (source_id)
);

ALTER SEQUENCE sources_seq OWNED BY sources.source_id;

INSERT INTO sources (name, publish_date)
VALUES
    ('Acquisition Incorporate', 2019-06-18),
    ('Adventure Atlas: The Mortuary', 2023-10-17),
    ('Against the Giants', 1981-01-01),
    ('Baldurs Gate Gazetteer', 2023-08-22),
    ('Basic Rules, 5e', 2014-07-03),
    ('Bigby Presents: Glory of Giants', 2023-08-15),
    ('Candleeep Mysteries', 2021-03-16),
    ('Critical Role', 2022-01-18),
    ('Critical Role: Call of the Netherdeep', 2022-03-15),
    ('Curse of Strahd: Character Options', 1800-01-01 ),
    ('Dead in Thay', 2014-04-01),
    ('Divine Contention', 1800-01-01),
    ('Domains of Delight: A Feywild Accessory', 2021-09-01),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),
    (''),

    ('')
;