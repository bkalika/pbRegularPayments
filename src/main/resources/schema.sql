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
    period varchar(6),
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

-- BEGIN;
--     INSERT INTO sender(first_name, last_name, inn) VALUES (
--         'First sender first name', 'First sender last name', 565216791);
--     INSERT INTO sender(first_name, last_name, inn) VALUES (
--         'Second sender first name', 'Second sender last name', 565216792);
--     INSERT INTO card(owner_id, number) VALUES (
--         1, 4567234512348920);
--     INSERT INTO card(owner_id, number) VALUES (
--         2, 4567234512348955);
--     INSERT INTO receiver(iban, mfo, okpo, name) VALUES (
--         'UA123456789012345678901234091', 555554, 878701, 'First receiver');
--     INSERT INTO receiver(iban, mfo, okpo, name) VALUES (
--        'UA123456789012349678901234092', 555534, 878001, 'Second receiver');
--     INSERT INTO receiver(iban, mfo, okpo, name) VALUES (
--        'UA123416789012349678901234082', 550534, 808001, 'Third receiver');
--     INSERT INTO payment(card_id, receiver_id, period, amount) VALUES (
--         1, 1, 'MINUTE', 1000);
--     INSERT INTO payment(card_id, receiver_id, period, amount) VALUES (
--         2, 2, 'HOUR', 2000);
--     INSERT INTO payment(card_id, receiver_id, period, amount) VALUES (
--         2, 3, 'DAY', 3000);
-- COMMIT;
