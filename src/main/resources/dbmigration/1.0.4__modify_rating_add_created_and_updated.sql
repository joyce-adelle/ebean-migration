-- apply alter tables
alter table rating add column if not exists created_at timestamptz not null;
alter table rating add column if not exists updated_at timestamptz not null;
