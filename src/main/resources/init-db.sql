DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS user_seq;
CREATE SEQUENCE user_seq START 100000;
DROP SEQUENCE IF EXISTS user_role_seq;
CREATE SEQUENCE user_role_seq START 1;
DROP SEQUENCE IF EXISTS post_seq;
CREATE SEQUENCE post_seq START 1;
DROP SEQUENCE IF EXISTS comment_seq;
CREATE SEQUENCE comment_seq START 1;

CREATE TABLE users
(
  id                      INTEGER PRIMARY KEY DEFAULT nextval('user_seq'),
  username                VARCHAR NOT NULL,
  password                VARCHAR NOT NULL,
  registered              TIMESTAMP NOT NULL DEFAULT now(),
  enabled                 BOOL DEFAULT TRUE,
  account_non_expired     BOOL DEFAULT TRUE,
  account_non_Locked      BOOL DEFAULT TRUE,
  credentials_non_expired BOOL DEFAULT TRUE
);

CREATE UNIQUE INDEX unique_username ON USERS (username);


CREATE TABLE user_roles
(
  id      INTEGER PRIMARY KEY DEFAULT nextval('user_role_seq'),
  user_id INTEGER NOT NULL,
  role    VARCHAR NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE posts
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('post_seq'),
  title         VARCHAR NOT NULL,
  preview       TEXT NOT NULL,
  content       TEXT NOT NULL,
  date_сreated  TIMESTAMP NOT NULL DEFAULT now(),
  user_id       INTEGER NOT NULL,
  CONSTRAINT posts_idx UNIQUE (title),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE 
);


CREATE TABLE comments
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('comment_seq'),
  content       TEXT NOT NULL,
  date_сreated  TIMESTAMP NOT NULL DEFAULT now(),
  user_id       INTEGER NOT NULL,
  post_id       INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE ON UPDATE CASCADE
);
