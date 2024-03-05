DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS users;

-- Создание таблицы пользователей
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

-- Создание таблицы ролей
CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL,
                       user_id INT NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Вставка тестовых данных
INSERT INTO users (username, password, enabled) VALUES ('user1', 'password1', true);
INSERT INTO users (username, password, enabled) VALUES ('user2', 'password2', true);
INSERT INTO users (username, password, enabled) VALUES ('moder', 'moder', true);
INSERT INTO roles (role_name, user_id) VALUES ('ROLE_USER', 1);
INSERT INTO roles (role_name, user_id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO roles (role_name, user_id) VALUES ('ROLE_USER', 2);
INSERT INTO roles (role_name, user_id) VALUES ('ROLE_MODERATOR', 3);

SELECT * FROM users;

SELECT * FROM roles;