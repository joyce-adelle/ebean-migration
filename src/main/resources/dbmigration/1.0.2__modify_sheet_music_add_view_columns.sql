-- apply alter tables
alter table sheet-music add column if not exists last_viewed_at timestamptz;
alter table sheet-music add column if not exists view_count bigint default 0 not null;
