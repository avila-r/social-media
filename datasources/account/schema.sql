-- TODO: Define account table
create table if not exists accounts (
    id uuid primary key not null unique
);

-- TODO: Define profile table
create table if not exists profiles (
    id uuid primary key not null unique,
    account_id uuid not null unique references accounts(id)
);