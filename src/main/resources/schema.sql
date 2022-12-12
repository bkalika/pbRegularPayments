CREATE TABLE IF NOT EXISTS sender (
    id bigserial primary key,
    first_name varchar(100),
    last_name varchar(100),
    inn bigserial unique
);
CREATE SEQUENCE IF NOT EXISTS client_sequence START 1000 INCREMENT 1;

CREATE TABLE IF NOT EXISTS card (
    id bigserial primary key,
    owner_id bigserial references sender(id),
    number bigint unique
);
CREATE SEQUENCE IF NOT EXISTS card_sequence START 1000 INCREMENT 1;

CREATE TABLE IF NOT EXISTS receiver(
    id bigserial primary key,
    iban varchar(29) unique,
    mfo bigint,
    okpo bigint,
    name varchar(150)
);
CREATE SEQUENCE IF NOT EXISTS receiver_sequence START 1000 INCREMENT 1;


CREATE TABLE IF NOT EXISTS payment (
    id bigserial primary key,
    card_id bigserial references card(id),
    receiver_id bigserial references receiver(id),
    period varchar(5),
    amount NUMERIC
    );
CREATE SEQUENCE IF NOT EXISTS payment_sequence START 1000 increment 1;

CREATE TABLE IF NOT EXISTS journal (
    id bigserial primary key,
    time timestamp,
    payment_id bigserial references payment(id),
    amount NUMERIC,
    status varchar(10)
);
CREATE SEQUENCE IF NOT EXISTS journal_sequence START 1000 INCREMENT 1;
