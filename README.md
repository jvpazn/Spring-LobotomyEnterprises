<div align="Center">
<h1> Projeto Java - LOS MUCHACHOS DEL LAG </h1>
<h5>Grupo L</h5>

<br>

<h2>Programação 2</h2>


Técnico em desenvolvimento de sistemas
Matutino

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

João Victor da Paz https://github.com/JoaoPazn/

Matheus Luciano de Caldas https://github.com/Matheus-LucianoC

Renan Aprigio Dias https://github.com/renandias3158

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

<br>

<h3>Título do projeto</h3>

<h2>SPRING - LOBOTOMY ENTERPRISE</h2>

uma pequena empresa com o nome referenciando o universo da project moon.

O grupo irá junto fazer tanto UML quanto a codificação. Planejamos concluir o projeto até a data de entrega ou até antes.

Enfim : o projeto irá utilizar questões de associação, agregação e composição. Planejamos fazer um projeto simples, entendível e funcional.

<h2>Especificações</h2>

<h4>1. Telas de Cadastro de ao menos três entidades básicas. Uma delas deve ter, obrigatoriamente, uma associação que também deverá estar no cadastro. (Ex: cadastrar Aluno e também a Instituição onde estudou anteriormente).</h4>

<h4>2. Telas com a consulta das três entidades, onde deverá ser fornecido algum tipo de filtro. (Ex: busca de aluno por matrícula ou por nome,etc.)</h4>

<h4>3. A partir da tela de consulta, permitir as operações de updade e de delete destas duas entidades.</h4>

<h2>MODELO DO BANCO DE DADOS UTILIZADO</h2>

CREATE DATABASE IF NOT EXISTS lobotomy_enterprises;
USE lobotomy_enterprises;

CREATE TABLE setor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    id_setor VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE cargo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    nivelSalarialMinimo INT NOT NULL,
    requisitos TEXT
);

CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    dataDeNascimento DATE NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    emailPessoal VARCHAR(100) UNIQUE NOT NULL,
    emailEmpresarial VARCHAR(100) UNIQUE NOT NULL,
    nivelFormacao VARCHAR(100),
    horasSemanais INT,
    salario INT,
    matricula VARCHAR(50) UNIQUE NOT NULL,
    setor_id BIGINT,
    cargo_id BIGINT,
    CONSTRAINT fk_func_setor
        FOREIGN KEY (setor_id) REFERENCES setor(id),
    CONSTRAINT fk_func_cargo
        FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);


