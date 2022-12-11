CREATE TABLE IF NOT EXISTS client (
    id bigserial primary key,
    first_name varchar(100),
    last_name varchar(100),
    inn bigserial unique
);
create sequence if not exists client_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS account (
    id bigserial primary key,
    client_id bigserial references client(id),
    account_number bigint unique,
    card_number bigint unique,
    mfo bigint,
    okpo bigint
);
create sequence if not exists account_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS payment (
    id bigserial primary key,
    sender_id bigserial references client(id),
    receiver_id bigserial references client(id),
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
