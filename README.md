<div align="Center">
<h1> Projeto Java - losJMR </h1>
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

uma pequena empresa com o nome referenciando o universo da project moon. Dessa vez com Springboot.

A versão é mais minimalista, dessa vez só temos 3 identidades, sendo elas funcionario, cargo e setor.

<h2>Especificações</h2>

<h4>1. Telas de Cadastro de ao menos três entidades básicas. Uma delas deve ter, obrigatoriamente, uma associação que também deverá estar no cadastro. (Ex: cadastrar Aluno e também a Instituição onde estudou anteriormente).</h4>

<h4>2. Telas com a consulta das três entidades, onde deverá ser fornecido algum tipo de filtro. (Ex: busca de aluno por matrícula ou por nome,etc.)</h4>

<h4>3. A partir da tela de consulta, permitir as operações de updade e de delete destas duas entidades.</h4>

<h2>NÃO SE ESQUEÇA DE ADICIONAR O BANCO DE DADOS NO APPLICATION_PROPERTIES</h2>

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

-- OPCIONAL, INSERTS PARA JÁ DEIXAR O BANCO POPULADO

INSERT INTO cargo (titulo, descricao, nivelSalarialMinimo, requisitos) VALUES
('Gerente', 'Gerencia os funcionários no setor onde está', 23000, 'Saúde mental forte, ensino superior completo'),
('Pleno', 'Trabalhador de cargo médio, segue as ordens dos superiores', 4000, 'Ensino fundamental completo e experiência média no mercado de trabalho'),
('Trabalhador Junior', 'Trabalhador Iniciante e novo as tradições da empresa, não confundir com estagiário', 2000, 'Ensino fundamental completo'),
('Trabalhador Sênior', 'Trabalhador experiente e preparado para as tradições da empresa', 6100, 'Ensino Superior completo e uma boa experiência como funcionário na empresa');

INSERT INTO setor (nome, id_setor) VALUES
('SETOR DE DESENVOLVIMENTO DE JOGOS', '1'),
('SETOR DE RELACOES PESSOAIS', '2'),
('SETOR DE FINANCAS', '3');

INSERT INTO funcionario (nome, senha, dataDeNascimento, cpf, emailPessoal, emailEmpresarial, nivelFormacao, horasSemanais, salario, matricula, setor_id, cargo_id) VALUES
('John T. Mantleholder', 'ERAMJohn', '1974-10-05', '938747182-43', 'eramjohnmantle@gmail.com', 'jtm@funcionario.lobEnterprise.com', 'Doutorado', 70, 23000, 'Newlobloblob20XX-854', 2, 1),
('Renan Aprigio dias de Moura', 'CARROSLEGAIS123', '2008-05-31', '857439285-54', 'RenanDias3158@gmail.com', 'radm@funcionario.lobEnterprise.com', 'Doutorado', 70, 25000, 'Newlobloblob20XX-341', 3, 1),
('Roland Orlandofurioso Nascimento', '1m1ssmyw1f3_123', '1993-11-23', '954837214-52', 'orlandofuriosoAngelica@gmail.com', 'ron@funcionario.lobEnterprise.com', 'Pos-Doutorado', 120, 30000, 'Newlobloblob20XX-182', 1, 1),
('BongBong Library of ruina', 'Bong123bomg', '1993-04-15', '536574234-64', 'bonghehe123@gmail.com', 'bbg@funcionario.lobEnterprise.com', 'Ensino Superior Completo', 60, 7000, 'Newlobloblob20XX-524', 2, 4),
('Jailma Oliveira', 'CIENCIASS0CIAIS', '1975-08-17', '943179329-55', 'JailmaOliveira12345@gmail.com', 'jo@funcionario.lobEnterprise.com', 'Mestrado', 60, 5600, 'Newlobloblob20XX-283', 3, 2),
('Joao Victor da Paz Nascimento', 'joaoGatinhosF0F1nhos', '2009-05-28', '582917283-91', 'joaovitor223344joao@gmail.com', 'jvpn@funcionario.lobEnterprise.com', 'Doutorado', 80, 6210, 'Newlobloblob20XX-845', 1, 4),
('Viktor henrique da silva', '7123e1h893UHQaS&*', '2000-10-05', '847632823-12', 'vikorhsilva@gmail.com', 'vhs@funcionario.lobEnterprise.com', 'Ensino Medio Completo', 45, 2500, 'Newlobloblob20XX-192', 1, 3),
('Matheus Luciano de Cabritos Figueiredo', 'KONOMATH3U5DA', '2008-09-29', '593274837-23', 'MatheusCabritinhos@gmail.com', 'mlcf@funcionario.lobEnterprise.com', 'Bacharelado', 45, 5900, 'Newlobloblob20XX-593', 3, 2);

