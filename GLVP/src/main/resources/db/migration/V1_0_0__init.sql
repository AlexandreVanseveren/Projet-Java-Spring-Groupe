create table roles (
                       id_user bigint not null,
                       role varchar(255) not null
) engine=InnoDB;

create table users (
                       id_user bigint not null,
                       account_non_expired bit,
                       account_non_locked bit,
                       credentials_non_expired bit,
                       enabled bit,
                       firstname varchar(255) not null,
                       lastname varchar(255) not null,
                       password varchar(255) not null,
                       username varchar(255) not null,
                       primary key (id_user)
) engine=InnoDB;

create table statut (
                        id_stat bigint not null,
                        stat_name varchar(255),
                        primary key (id_stat)

) engine=InnoDB;

create table categories (
                            id_cat bigint not null ,
                            cat_name varchar(255) not null,
                            primary key (id_cat)
) engine=InnoDB;

create table subcat (
                        id_sub bigint not null,
                        sub_name varchar (255) not null,
                        id_catfk bigint not null,
                        primary key (id_sub)

) engine=InnoDB;

create table products (
                          id_prod bigint not null,
                          prod_name varchar(255) not null,
                          rayon date,
                          peremption date,
                          id_subfk bigint not null,
                          id_statfk bigint not null,
                          primary key (id_prod)

) engine=InnoDB;

create index INDEX_USER_ROLE on roles (id_user);

alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);
alter table roles add constraint FK40d4m5dluy4a79sk18r064avh foreign key (id_user) references users (id_user);
alter table subcat add constraint foreign key (id_catfk) references categories (id_cat);
alter table products add constraint foreign key (id_subfk) references subcat (id_sub);
alter table products add constraint foreign key (id_statfk) references statut (id_stat);