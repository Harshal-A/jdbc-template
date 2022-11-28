CREATE TABLE course(
    course_id integer NOT NULL AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    description VARCHAR(255) NOT NULL,
    link VARCHAR(100) NOT NULL,
    CONSTRAINT PK_course_course_id PRIMARY KEY (course_id)
);