CREATE SEQUENCE note_seq start with 10000;

CREATE TABLE notes (
                             note_id bigint NOT NULL DEFAULT nextval('note_seq'),
                             name varchar(50) NOT NULL,
                             date date NOT NULL,
                             author varchar(50),

                             PRIMARY KEY (note_id)
);

