use spring;

-- Criação da tabela veiculos
CREATE TABLE IF NOT EXISTS veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    veiculo VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    cor VARCHAR(100) NOT NULL,
    ano INT,
    descricao TEXT,
    vendido BOOLEAN,
    created DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Inserção de 20 registros
INSERT INTO veiculos (veiculo, marca, cor, ano, descricao, vendido) VALUES
('Fiesta', 'Ford', 'Prata', 2012, 'Compacto econômico e confortável', false),
('Civic', 'Honda', 'Preto', 2018, 'Sedã médio com ótimo desempenho', false),
('Corolla', 'Toyota', 'Branco', 2020, 'Sedã confiável e confortável', true),
('Onix', 'Chevrolet', 'Vermelho', 2021, 'Hatch mais vendido do Brasil', false),
('Gol', 'Volkswagen', 'Azul', 2015, 'Popular robusto e confiável', true),
('HB20', 'Hyundai', 'Cinza', 2019, 'Hatch moderno com bom consumo', false),
('Kwid', 'Renault', 'Branco', 2022, 'Carro compacto de entrada', false),
('Compass', 'Jeep', 'Preto', 2021, 'SUV médio com tecnologia avançada', true),
('Renegade', 'Jeep', 'Verde', 2020, 'SUV compacto off-road', false),
('Sandero', 'Renault', 'Prata', 2016, 'Hatch espaçoso e econômico', true),
('Argo', 'Fiat', 'Vermelho', 2021, 'Hatch moderno da Fiat', false),
('Cronos', 'Fiat', 'Branco', 2020, 'Sedã derivado do Argo', false),
('Toro', 'Fiat', 'Cinza', 2019, 'Picape urbana de médio porte', true),
('S10', 'Chevrolet', 'Azul', 2018, 'Picape robusta para trabalho', true),
('Ranger', 'Ford', 'Preto', 2021, 'Picape média moderna e potente', false),
('Hilux', 'Toyota', 'Branco', 2022, 'Picape líder de vendas', false),
('City', 'Honda', 'Prata', 2019, 'Sedã compacto premium', false),
('HR-V', 'Honda', 'Cinza', 2020, 'SUV compacto urbano', true),
('Polo', 'Volkswagen', 'Amarelo', 2018, 'Hatch premium com bom desempenho', false),
('T-Cross', 'Volkswagen', 'Preto', 2021, 'SUV compacto moderno', true);
