-- apply changes
create table otp (
  created_at                    timestamptz,
  expired_at                    timestamptz not null,
  confirmed_at                  timestamptz,
  email                         varchar(255) not null,
  otp                           varchar(255) not null,
  constraint pk_otp primary key (email)
);

