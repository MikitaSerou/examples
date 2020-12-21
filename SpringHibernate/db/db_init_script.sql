
CREATE TABLE Author
(
    id                  BIGSERIAL PRIMARY KEY,
    name                CHARACTER VARYING(128) NOT NULL
);

CREATE TABLE Book
(
    id                  BIGSERIAL PRIMARY KEY,
    name                CHARACTER VARYING(128) NOT NULL
  
);

CREATE TABLE Book_author
(
    id                  BIGSERIAL PRIMARY KEY,
    book_id             BIGINT  NOT NULL REFERENCES Book (id),
    author_id           BIGINT  NOT NULL REFERENCES Author (id)
);


INSERT INTO BOOK(name) VALUES ('Fairy tales');
INSERT INTO BOOK(name) VALUES ('Java 8');
INSERT INTO BOOK(name) VALUES ('Dagon');
INSERT INTO BOOK(name) VALUES ('1984');
INSERT INTO BOOK(name) VALUES ('IT');

INSERT INTO AUTHOR(name) VALUES ('S. King');
INSERT INTO AUTHOR(name) VALUES ('G.P. Lovecraft');
INSERT INTO AUTHOR(name) VALUES ('H. Schildt');
INSERT INTO AUTHOR(name) VALUES ('K. Chukowski');
INSERT INTO AUTHOR(name) VALUES ('J. Oruel');
INSERT INTO AUTHOR(name) VALUES ('M. Hamill');
INSERT INTO AUTHOR(name) VALUES ('G. Milos');
INSERT INTO AUTHOR(name) VALUES ('R. Gosling');

INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (1, 8);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (1, 7);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (1, 6);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (2, 8);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (2, 7);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (3, 2);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (3, 7);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (3, 8);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (4, 5);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (4, 4);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (5, 8);
INSERT INTO BOOK_AUTHOR(book_id, author_id) VALUES (5, 1);