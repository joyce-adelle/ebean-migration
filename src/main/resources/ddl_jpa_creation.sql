create table `app-user` (is_verified boolean default false not null, created_at datetime(6), updated_at datetime(6), verified_at datetime(6), email varchar(50), provider_id varchar(50), password varchar(150) not null, id varchar(255) not null, provider varchar(20) default 'LOCAL' not null, role enum ('USER','ADMIN','SUPERADMIN'), primary key (id)) engine=InnoDB;
create table `user-profile` (created_at datetime(6), updated_at datetime(6), name varchar(100), bio TEXT, id varchar(255) not null, user_id varchar(255) not null, picture BLOB, primary key (id)) engine=InnoDB;
alter table `app-user` add constraint UK_5omn5u0202euvm3skvr2t59fq unique (email);
alter table `user-profile` add constraint UK_qme97fgpnekfmuvqy9tdy4m19 unique (user_id);
alter table `user-profile` add constraint FKmqt3d3qdlg21q070wu9glv1dq foreign key (user_id) references `app-user` (id);
