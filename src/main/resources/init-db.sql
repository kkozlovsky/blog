DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS user_seq;

CREATE SEQUENCE user_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('user_seq'),
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP NOT NULL DEFAULT now(),
  enabled    BOOL DEFAULT TRUE
);

CREATE UNIQUE INDEX unique_email ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
