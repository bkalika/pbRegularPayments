CREATE TABLE IF NOT EXISTS sender (
    id bigserial primary key,
    first_name varchar(100),
    last_name varchar(100),
    inn bigserial unique
);
create sequence if not exists client_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS card (
    id bigserial primary key,
    owner_id bigserial references sender(id),
    number bigint unique
);
create sequence if not exists card_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS receiver(
    id bigserial primary key,
    iban varchar(29) unique,
    mfo bigint,
    okpo bigint,
    name varchar(150)
);
create sequence if not exists receiver_sequence start 1000 increment 1;


CREATE TABLE IF NOT EXISTS payment (
    id bigserial primary key,
    card_id bigserial references card(id),
    receiver_id bigserial references receiver(id),
    period varchar(5),
    amount NUMERIC
    );
create sequence if not exists payment_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS journal (
    id bigserial primary key,
    time timestamp,
    payment_id bigserial references payment(id),
    amount NUMERIC,
    status varchar(10)
);
create sequence if not exists journal_sequence start 1000 increment 1;
