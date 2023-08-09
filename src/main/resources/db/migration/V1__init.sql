create table security_users
(
    id       serial not null,
    username varchar(255),
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
    security_user_id integer not null,
    roles_id         integer not null,
    constraint unique_roles_id unique (roles_id),
    constraint fk_roles_id
        foreign key (roles_id)
            references roles,
    constraint fk_user_id
        foreign key (security_user_id)
            references security_users
);

create table employees
(
    id                     serial not null,
    name                   varchar(255),
    middle_name            varchar(255),
    last_name              varchar(255),
    birthday               date,
    gender                 varchar(255),
    phone                  varchar(255),
    email                  varchar(255),
    city                   varchar(255),
    specialization         varchar(255),
    education              text,
    languages              text,
    skills                 text,
    auto                   text,
    additional_information text,
    hobby                  text,
    primary key (id)
);

create table places_of_work
(
    id          serial not null,
    name        varchar(255),
    start       date,
    finish      date,
    duration    text,
    city        varchar(255),
    position    text,
    description text,
    primary key (id)
);

create table employees_place_of_work
(
    employee_id      integer not null,
    place_of_work_id integer not null,
    constraint fk_places_of_work_id
        foreign key (place_of_work_id)
            references places_of_work,
    constraint fk_employees_id
        foreign key (employee_id)
            references employees
);