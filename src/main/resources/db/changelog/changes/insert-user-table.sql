/*--liquibase formatted sql
--changeset <root>:<insert-user-table>

INSERT INTO users (age, email, name, password, role) VALUES (30, 'max@gmail.com', 'max', '1234', 'USER');

--rollback DELETE FROM users;*/