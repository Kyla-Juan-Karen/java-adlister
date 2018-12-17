insert into users (username, email, password)
values ('username', 'email', 'password1'),
       ('username2', 'email2', 'password2');

insert into ads (title, description, user_id)
values ('first post', 'description', 1),
       ('second post', 'description', 2),
       ('third post', 'description', 2);

insert into category (category)
values ('category1'),
       ('category2'),
       ('category3'),
       ('category4');

insert into ads_category (ad_id, category_id)
values (1, 1),
       (1, 2),
       (1, 4);
