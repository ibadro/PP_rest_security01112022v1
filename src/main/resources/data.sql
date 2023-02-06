create table db.users
(
    id bigint not null,
    last_name varchar(255),
    first_name varchar(255),
    age bigint,
    email varchar(255),
    password varchar(255),
    primary key (id)
);
create table db.roles
(
    id bigint not null,
    name varchar(255),
    primary key (id)
);

create table bootstrap_db.users_roles
(
    user_id bigint not null,
    roles_id bigint not null,
    primary key (user_id,roles_id),
    foreign key (user_id) references db.users(id),
    foreign key (roles_id) references db.roles(id)
);

        insert into db.roles (id, name)
values  (1, 'ROLE_USER'),
        (2, 'ROLE_ADMIN');
        
insert into db.users (id, first_name, last_name, age, email, password)
values  (1, 'Admin', 'Admin', 25, 'admin@mail.ru', '$2y$10$3Xa//hS0AackFywrS5yoq.pKboOrw4I.6UGZXFMeO4ZEZu1zGXLF6'),
        (2, 'User', 'User', 33, 'user@mail.ru', '$2y$10$3Xa//hS0AackFywrS5yoq.pKboOrw4I.6UGZXFMeO4ZEZu1zGXLF6'),
        (3, 'Test', 'Test', 26, 'test@mail.ru', '$2y$10$3Xa//hS0AackFywrS5yoq.pKboOrw4I.6UGZXFMeO4ZEZu1zGXLF6'),
        (13, 'qwerty', 'qwerty', 37, 'qwerty@mail.ru', '$2y$10$3Xa//hS0AackFywrS5yoq.pKboOrw4I.6UGZXFMeO4ZEZu1zGXLF6');
        
insert into bootstrap_db.users_roles (user_id, roles_id)
values  (1, 1),
        (1, 2),
        (2, 1),
        (3, 1),
        (13, 1);
              
