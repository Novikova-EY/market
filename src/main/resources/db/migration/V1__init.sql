CREATE TABLE categories
(
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(255)
);

INSERT INTO categories (title)
VALUES ('Food');

CREATE TABLE products
(
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    price INT,
    category_id BIGINT REFERENCES categories(id)
);

INSERT INTO products (title, price, category_id)
VALUES ('Meat', 150, 1),
       ('Milk', 50, 1),
       ('Bread', 20, 1);