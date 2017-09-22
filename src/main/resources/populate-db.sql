DELETE FROM users;
DELETE FROM user_roles;

ALTER SEQUENCE user_seq RESTART WITH 100000;
ALTER SEQUENCE user_role_seq RESTART WITH 1;
ALTER SEQUENCE post_seq RESTART WITH 1;
ALTER SEQUENCE comment_seq RESTART WITH 1;


INSERT INTO users (username, password) VALUES ('user@yandex.ru', 'user');
INSERT INTO users (username, password) VALUES ('admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);