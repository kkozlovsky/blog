DROP TABLE IF EXISTS posts;

DROP SEQUENCE IF EXISTS post_seq;
CREATE SEQUENCE post_seq START 1;

CREATE TABLE posts
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('post_seq'),
  title         VARCHAR NOT NULL,
  preview       TEXT NOT NULL,
  content       TEXT NOT NULL,
  date_сreated  TIMESTAMP NOT NULL DEFAULT now(),
  CONSTRAINT posts_idx UNIQUE (title)
);
