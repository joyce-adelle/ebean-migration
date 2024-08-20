-- apply changes
create table sheet_music_languages (
  sheet_music_id                varchar(255) not null,
  languages                     varchar(255) not null
);

-- foreign keys and indices
create index ix_sheet_music_languages_sheet_music_id on sheet_music_languages (sheet_music_id);
alter table sheet_music_languages add constraint fk_sheet_music_languages_sheet_music_id foreign key (sheet_music_id) references sheet-music (id) on delete restrict on update restrict;

