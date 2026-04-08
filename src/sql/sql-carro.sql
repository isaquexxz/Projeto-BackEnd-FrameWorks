CREATE TABLE carro (
    id INT PRIMARY KEY, 
    nome_carro VARCHAR(100) NOT NULL,
    valor_carro VARCHAR(20) NOT NULL,
    ano_carro VARCHAR(20) NOT NULL
);

INSERT INTO carro (id, nome_carro, valor_carro, ano_carro) VALUES (?, ?, ?, ?);
SELECT * FROM carro;
UPDATE carro SET nome_carro = ?, valor_carro = ?, ano_carro = ? WHERE id = ?;
DELETE FROM carro WHERE id = ?;