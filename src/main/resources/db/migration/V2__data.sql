insert into security_users(username, password)
values ('Mike',
        '$2a$12$8v7vCL9vQjo.IhTQTEcfZurlQh1ivTJucDtjrPFoJ3xUT/FiNGe22');

insert into roles (name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into security_users_roles (security_user_id, roles_id)
values (1, 1),
       (1, 2);