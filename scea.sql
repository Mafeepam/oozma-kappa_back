
CREATE SCHEMA IF NOT EXISTS scea;


CREATE TABLE IF NOT EXISTS scea.usuario (
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    funcao VARCHAR(50) CHECK (funcao IN ('admin', 'professor'))
);



CREATE TABLE IF NOT EXISTS scea.professores (
 	id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    curso VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS scea.reservas(
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fim TIME NOT NULL,
    espaco VARCHAR(100) NOT NULL  -- Atualmente, os registros gravam um ID (texto) – iremos atualizar para o nome
);


CREATE TABLE IF NOT EXISTS scea.espacosfisicos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(100) CHECK (tipo IN ('sala', 'auditorio', 'laboratorio')) NOT NULL,
    capacidade INT NOT NULL
);



INSERT INTO scea.usuario (email, senha, funcao) VALUES
    ('fernando.borges@pro.ucsal.br', '1234', 'professor'),
    ('admin@ucsal.br', 'admin123', 'admin');


INSERT INTO scea.professores (nome, email, curso) VALUES
    ('Ana Silva', 'ana@pro.ucsal.br', 'Análise e Desenvolvimento de Sistemas'),
    ('Bruno Costa', 'bruno@pro.ucsal.br', 'Engenharia Civil'),
    ('Clara Souza', 'clara@pro.ucsal.br', 'Engenharia Química'),
    ('Daniel Santos', 'daniel@pro.ucsal.br', 'Engenharia Mecânica'),
    ('Fernando Borges1', 'fernando.borgess@pro.ucsal.br', 'Engenharia de Software');

INSERT INTO scea.reservas (data, hora_inicio, hora_fim, espaco) VALUES 

INSERT INTO scea.espacosfisicos (nome, tipo, capacidade) VALUES
    ('Lami 1', 'laboratorio', 30),
    ('Lami 2', 'laboratorio', 30),
    ('Lami 3', 'laboratorio', 40),
    ('Aud. 1', 'auditorio', 200),
    ('Aud. 3', 'auditorio', 150),
    ('B411', 'sala', 50),
    ('B412', 'sala', 60);


UPDATE scea.reservas r
SET espaco = e.nome
FROM scea.espacosfisicos e
WHERE r.espaco ~ '^[0-9]+$'
  AND r.espaco::int = e.id;


SELECT * FROM scea.reservas;
