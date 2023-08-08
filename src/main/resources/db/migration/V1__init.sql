create table security_users
(
    id       serial not null,
    username varchar,
    password varchar,
    primary key (id)
);

create table roles
(
    id   serial not null,
    name varchar(255),
    primary key (id)
);

create table security_users_roles
(
    security_user_id  integer not null,
    roles_id integer not null,
    constraint unique_roles_id unique (roles_id),
    constraint fk_roles_id
        foreign key (roles_id)
            references roles,
    constraint fk_user_id
        foreign key (security_user_id)
            references security_users
);
