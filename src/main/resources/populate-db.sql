DELETE FROM users;
DELETE FROM user_roles;

ALTER SEQUENCE user_seq RESTART WITH 100000;
ALTER SEQUENCE user_role_seq RESTART WITH 1;
ALTER SEQUENCE post_seq RESTART WITH 1;
ALTER SEQUENCE comment_seq RESTART WITH 1;


INSERT INTO users (username, password) VALUES ('user', '$2a$06$D6TDSmWujthEQ83iCFLa5.CcRsXec.c78VGbGHkedViBEL6Hf9PBy');
INSERT INTO users (username, password) VALUES ('admin', '$2a$06$tmSSdvhNSNww6GNU6/jRI.9mM8ilWnOb2DzmhsTiCyFQZrYoPa60u');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);