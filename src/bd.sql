CREATE TABLE users(
                      user_id BIGSERIAL NOT NULL PRIMARY KEY,
                      user_name VARCHAR(50) NOT NULL,
                      login VARCHAR(50) NOT NULL,
                      password VARCHAR(30) NOT NULL,
                      date_of_creating TIMESTAMP DEFAULT Now() NOT NULL,
                      date_of_changing TIMESTAMP DEFAULT NOW() NOT NULL
);

CREATE TABLE roles(
                      role_id BIGSERIAL NOT NULL PRIMARY KEY,
                      role_name VARCHAR(50) NOT NULL
);
ALTER TABLE users ADD role_id INT;
ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES  roles(role_id);

INSERT INTO roles (role_name)
VALUES ('Разработчик'), ('Аналитик'), ('Тестировщик'), ('Менеджер'), ('Дизайнер'), ('По умолчанию');

INSERT INTO users (user_name, login, password)
VALUES ('Misha', 'Michael', 'Rassadin');

SELECT * FROM users;

UPDATE users SET password = 'aa' WHERE user_id = 1;