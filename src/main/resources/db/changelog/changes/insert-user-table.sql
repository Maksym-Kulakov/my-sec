--liquibase formatted sql
--changeset <root>:<insert-user-table>

INSERT INTO users (age, email, name, password) VALUES (30, 'max@gmail.com', 'max', '1234');

--rollback DELETE FROM users;