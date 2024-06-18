-- -- Account table

-- create table accounts
-- (
--     created_at    timestamp(6) not null,
--     last_login_at timestamp(6),
--     id            uuid         not null
--         primary key,
--     email         varchar(255) not null
--         unique,
--     login         varchar(255) not null
--         unique,
--     password_hash varchar(255) not null,
--     status        varchar(255) not null
-- );
--
-- alter table accounts
--     owner to "dbf0e9e4-d2f0-4bfe-b66b-91c327b2a9b9";



-- -- Profile table

-- create table profiles
-- (
--     birth_date       date         not null,
--     account_id       uuid         not null,
--     id               uuid         not null
--         primary key,
--     contact_info     varchar(255),
--     full_name        varchar(255) not null,
--     gender           varchar(255) not null,
--     preferences      varchar(255),
--     privacy_settings varchar(255),
--     profile_picture  varchar(255)
-- );
--
-- alter table profiles
--     owner to "dbf0e9e4-d2f0-4bfe-b66b-91c327b2a9b9";