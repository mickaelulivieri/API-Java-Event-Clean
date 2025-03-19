--v1_criar_tabela_evento.sql

CREATE TABLE Eventos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    Description VARCHAR(255),
    Identifier VARCHAR(255) UNIQUE NOT NULL,
    Data_inicio TIMESTAMP NOT NULL,
    Data_fim TIMESTAMP NOT NULL,
    Local VARCHAR(255),
    Organizador VARCHAR(255),
    Tipo_de_evento ENUM('WORKSHOP', 'PALESTRA', 'MUSICA', 'SEMINARIO') NOT NULL
);
