-- drop dependencies
alter table sheet-music drop constraint if exists ck_sheet-music_tempo;
-- apply alter tables
alter table sheet-music alter column tempo type varchar(11) using tempo::varchar(11);
alter table sheet-music alter column tempo drop not null;
alter table sheet-music add column if not exists time_signature_numerator integer;
alter table sheet-music add column if not exists time_signature_denominator integer;
-- apply post alter
alter table sheet-music add constraint ck_sheet-music_tempo check ( tempo in ('GRAVE','LENTO','LARGO','LARGHETTO','ADAGIO','ADAGIETTO','ANDANTE','ANDANTINO','MODERATO','ALLEGRETTO','ALLEGRO','VIVACE','VIVO','PRESTO','PRESTISSIMO','RUBATO'));
