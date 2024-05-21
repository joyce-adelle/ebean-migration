-- apply changes
create table app-user (
  id                            varchar(255) not null,
  email                         varchar(50),
  is_verified                   boolean default false not null,
  password                      varchar(150) not null,
  provider_id                   varchar(50),
  provider                      varchar(20) default 'LOCAL' not null,
  verified_at                   datetime(6),
  role                          varchar(5),
  created_at                    datetime(6) not null,
  updated_at                    datetime(6) not null,
  constraint uq_app-user_email unique (email),
  constraint pk_app-user primary key (id)
);

create table user-profile (
  id                            varchar(255) not null,
  name                          varchar(100),
  user_id                       varchar(255) not null,
  bio                           TEXT,
  picture                       longblob,
  created_at                    datetime(6) not null,
  updated_at                    datetime(6) not null,
  constraint uq_user-profile_user_id unique (user_id),
  constraint pk_user-profile primary key (id)
);

-- foreign keys and indices
alter table user-profile add constraint fk_user-profile_user_id foreign key (user_id) references app-user (id) on delete restrict on update restrict;

