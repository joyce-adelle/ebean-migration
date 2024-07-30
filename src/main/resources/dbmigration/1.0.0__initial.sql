-- apply changes
create table app-user (
  verified_at                   timestamptz,
  deactivated_at                timestamptz,
  created_at                    timestamptz not null,
  updated_at                    timestamptz not null,
  id                            varchar(255) not null,
  email                         varchar(50),
  password                      varchar(150) not null,
  provider_id                   varchar(50),
  provider                      varchar(20) default 'LOCAL' not null,
  deactivated_by                varchar(255),
  role                          varchar(10),
  constraint ck_app-user_provider check ( provider in ('LOCAL','GOOGLE','FACEBOOK')),
  constraint ck_app-user_role check ( role in ('USER','ADMIN','SUPERADMIN')),
  constraint uq_app-user_email unique (email),
  constraint pk_app-user primary key (id)
);

create table user-profile (
  bio                           TEXT,
  created_at                    timestamptz not null,
  updated_at                    timestamptz not null,
  id                            varchar(255) not null,
  name                          varchar(100),
  user_id                       varchar(255) not null,
  email                         varchar(100),
  picture_url                   varchar(255),
  constraint uq_user-profile_user_id unique (user_id),
  constraint uq_user-profile_email unique (email),
  constraint pk_user-profile primary key (id)
);

-- foreign keys and indices
alter table user-profile add constraint fk_user-profile_user_id foreign key (user_id) references app-user (id) on delete restrict on update restrict;

