-- apply changes
create table otp (
  email                         varchar(255) not null,
  otp                           varchar(255) not null,
  created_at                    datetime(6),
  expired_at                    datetime(6) not null,
  confirmed_at                  datetime(6),
  constraint pk_otp primary key (email)
);

-- apply alter tables
alter table app-user add column deactivated_by varchar(255);
alter table app-user add column deactivated_at datetime(6);
alter table user-profile add column email varchar(50);
alter table user-profile add column picture_url varchar(255);
