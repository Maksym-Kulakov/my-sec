--liquibase formatted sql
--changeset <root>:<create-user-table>

CREATE TABLE users (
                         id bigint NOT NULL AUTO_INCREMENT,
                         age int NOT NULL,
                         email varchar(255) DEFAULT NULL,
                         name varchar(255) DEFAULT NULL,
                         role varchar(255) DEFAULT NULL,
                         password varchar(255) DEFAULT NULL,
                         PRIMARY KEY (id)
);

--rollback DROP TABLE books;
