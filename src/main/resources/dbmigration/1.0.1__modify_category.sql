-- apply changes
create table category_relationship (
  parent_id                     bigint not null,
  child_id                      bigint not null,
  constraint pk_category_relationship primary key (parent_id,child_id)
);

-- apply alter tables
alter table category add column if not exists has_children boolean default false not null;
alter table category add column if not exists has_parents boolean default false not null;
-- foreign keys and indices
create index ix_category_relationship_category_1 on category_relationship (parent_id);
alter table category_relationship add constraint fk_category_relationship_category_1 foreign key (parent_id) references category (id) on delete restrict on update restrict;

create index ix_category_relationship_category_2 on category_relationship (child_id);
alter table category_relationship add constraint fk_category_relationship_category_2 foreign key (child_id) references category (id) on delete restrict on update restrict;

