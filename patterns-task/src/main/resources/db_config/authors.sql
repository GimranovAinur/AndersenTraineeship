CREATE TABLE IF NOT EXISTS authors (
	id serial NOT NULL PRIMARY KEY,
	name varchar(25) NOT NULL,
	surname varchar(30)
);

CREATE TABLE IF NOT EXISTS publishers (
	id serial PRIMARY KEY,
	name varchar(25)
);

CREATE TABLE IF NOT EXISTS literature (
	id serial NOT NULL PRIMARY KEY,
	title varchar(50) NOT NULL,
	publisher_id serial,
	release_date date,
	release_number int,
	author_id serial,
	FOREIGN KEY (publisher_id) REFERENCES publishers(id),
	FOREIGN KEY (author_id) REFERENCES authors(id)
);

CREATE TABLE IF NOT EXISTS literature_author_ref (
	literature_id serial NOT NULL,
	author_id serial NOT NULL,
	FOREIGN KEY (literature_id) REFERENCES literature(id),
	FOREIGN KEY (author_id) REFERENCES authors(id),
	UNIQUE (literature_id, author_id)
);

INSERT INTO authors(name, surname) VALUES('Лев', 'Толстой');

INSERT INTO publishers(name) VALUES('Легион');

INSERT INTO literature(title, publisher_id, release_date, release_number, author_id) VALUES ('Война и мир', 1, null, null, 1);


