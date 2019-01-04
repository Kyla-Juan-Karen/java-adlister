
insert into users (username, email, password, isAdmin)
values ('admin', 'admin', 'admin', true),
       ('test', 'test', 'test', false);

insert into ads (title, description, user_id)
values ('first post', 'description', 1),
       ('second post', 'description', 2),
       ('third post', 'description', 2);

insert into category (category)
values ('humor'),
       ('help wanted'),
       ('for sale'),
       ('fyi'),
       ('radical news');
