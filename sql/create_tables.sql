CREATE DATABASE IF NOT EXISTS projectsdb;

CREATE TABLE IF NOT EXISTS projectsdb.project (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    short_info VARCHAR(500) NOT NULL,
    created DATE,
    updated DATE,
    PRIMARY KEY (id)
 );

CREATE TABLE IF NOT EXISTS projectsdb.project_description (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    text TEXT NOT NULL,
    created DATE,
    updated DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);

CREATE TABLE IF NOT EXISTS projectsdb.guest (
    id int NOT NULL AUTO_INCREMENT,
    guest_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    age int,
    created DATE,
    updated DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS projectsdb.comment (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    guest_name VARCHAR(20) NOT NULL,
    comment_text TEXT NOT NULL,
    created DATE,
    updated DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS projectsdb.image (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    image_name VARCHAR(20) NOT NULL,
    url VARCHAR(150) NOT NULL,
    image_description VARCHAR(100) NOT NULL,
    created DATE,
    updated DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS projectsdb.file (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    file_name VARCHAR(20) NOT NULL,
    url VARCHAR(150) NOT NULL,
    file_description VARCHAR(100) NOT NULL,
    created DATE,
    updated DATE,
    PRIMARY KEY (id)
);
