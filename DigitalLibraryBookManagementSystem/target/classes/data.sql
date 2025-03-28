-- Table creation
CREATE TABLE BOOK (
    BOOK_ID VARCHAR(10) PRIMARY KEY,
    TITLE VARCHAR(100),
    AUTHOR VARCHAR(100),
    GENRE VARCHAR(50),
    STATUS VARCHAR(20)
);

-- Data insertion
INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR, GENRE, STATUS)
VALUES ('B001', 'Spring Boot Basics', 'John Doe', 'Tech', 'Available');

INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR, GENRE, STATUS)
VALUES ('B002', 'Spring Security Fundamentals', 'Jane Doe', 'Tech', 'Available');
