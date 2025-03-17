CREATE DATABASE IF NOT EXISTS smartlist_db;
USE smartlist_db;

CREATE TABLE IF NOT EXISTS Lists (
    lists_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_price DECIMAL(10,2) DEFAULT 0.00,
    total_available DECIMAL(10,2) DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS Items (
    items_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    lists_id BIGINT,
    FOREIGN KEY (lists_id) REFERENCES Lists(lists_id) ON DELETE CASCADE
);


INSERT INTO Lists (name, total_price, total_available) VALUES ('Supermercado Mensal', 0.00, 500.00);
INSERT INTO Lists (name, total_price, total_available) VALUES ('Compras da Semana', 0.00, 200.00);
INSERT INTO Items (name, price, quantity, lists_id) VALUES ('Arroz', 5.50, 2, 1);
INSERT INTO Items (name, price, quantity, lists_id) VALUES ('Feijão', 7.90, 1, 1);
INSERT INTO Items (name, price, quantity, lists_id) VALUES ('Macarrão', 3.20, 3, 2);
INSERT INTO Items (name, price, quantity, lists_id) VALUES ('Leite', 4.50, 2, 2);

-- Atualiza o total_price das listas
UPDATE Lists
SET total_price = (
    SELECT COALESCE(SUM(price * quantity), 0) 
    FROM Items 
    WHERE Items.items_id= Lists.lists_id
);

