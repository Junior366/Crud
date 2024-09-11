
USE MASTER IF EXISTS (
   SELECT * FROM SYS.databases WHERE NAME = 'bd_centroTreinamento')
DROP DATABASE bd_centroTreinamento
GO
CREATE DATABASE bd_centroTreinamento
GO 
USE bd_centroTreinamento


CREATE TABLE Usuario (

id            INT            IDENTITY,
nome          VARCHAR(100)   NOT NULL,
email         VARCHAR(100)   UNIQUE NOT NULL,
senha         VARCHAR(10)    NOT NULL, 
nivelAcesso   VARCHAR(10)    NOT NULL, -- ADMIN OU USER
foto          VARBINARY(MAX) NULL,
statusUsuario VARCHAR(20)    NOT NULL -- ATIVO ou INATIVO,

PRIMARY KEY (id)

)

CREATE TABLE Membro (

id            INT            IDENTITY,
nome          VARCHAR (100)   NOT NULL, 
cpf          VARCHAR (11)   NOT NULL,
dataNasc      DATETIME        NOT NULL,
telefone      VARCHAR (15)    NOT NULL,
usuario_id    INT             NOT NULL,
statusMembro  VARCHAR (15)    NOT NULL,
PRIMARY KEY (id),
Foreign Key (Usuario_id) REFERENCES Usuario(id)

)
GO
INSERT Membro(nome, cpf, dataNasc, telefone, usuario_id, statusMembro)
VALUES (GETDATE(), 'Junior', '54314195265', '31/05/2006', '11957391387', 'ATIVO')

CREATE TABLE Mensalidade (

id              INT           IDENTITY,
valor           DECIMAL(8,2)            NOT NULL,
dataPgto       DATE           NULL,
dataVcto      DATE           NOT NULL,
membro_id       INT            NOT NULL,
statusPgto     VARCHAR(20)    NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (Membro_id) REFERENCES Membro(id),

)
GO
INSERT Mensalidade(valor, dataPgto, dataVcto, membro_id, )

CREATE TABLE Turma (

id          INT            IDENTITY,
nome        varchar(100)   NOT NULL,
ano		    varchar(10)    NOT NULL,
modalidade      varchar(100)   NOT NULL,
statusTurma varchar(100)  NOT NULL,

Primary Key (id)
)

CREATE TABLE MembroTurma (

id          INT            IDENTITY,
dataEntrada       DATE           NULL,
dataSaida      DATE           NULL,
membro_id   INT            NOT NULL,
turma_id   INT            NOT NULL,
statusMembroTurma varchar(100)  NOT NULL,


Primary Key (id),
Foreign Key (Membro_id) REFERENCES Membro(id),
Foreign Key (Turma_id) REFERENCES Turma(id)

)

CREATE TABLE Plano (

id          INT            IDENTITY,
nome        varchar(100)   NOT NULL,
ano		    varchar(10)    NOT NULL,
descricao     varchar(200)   NOT NULL,
valorMensal           DECIMAL(8,2)            NOT NULL,
valorSemestral           DECIMAL(8,2)            NULL,
valorAnual          DECIMAL(8,2)            NULL,
usuario_id    INT             NOT NULL,
statusPlano varchar(100)  NOT NULL,

Primary Key (id),
Foreign Key (usuario_id) REFERENCES Usuario(id)
)
CREATE TABLE Mensagem
(
	id	            INT			  IDENTITY,
	dataMensagem    SMALLDATETIME NOT NULL,
	emissorMensagem VARCHAR(100)  NOT NULL,
	email 	        VARCHAR(100)  NOT NULL,
	telefone	    VARCHAR(20)       NULL,
	texto 	        VARCHAR(400)  NOT NULL,
	statusMensagem  VARCHAR(10)   NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id)
)
GO
INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem) 
VALUES (GETDATE(), 'Ordnael Zurc', 'ordnael@email.com', '(11) 98765-4123', 'Mensagem de teste', 'ATIVO')
INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem) 
VALUES (GETDATE(), 'Maria Onete', 'maria@email.com', null, 'Segunda mensagem de teste', 'ATIVO')
GO

/*
CREATE TABLE Agenda (

id         INT          IDENTITY,
horario    VARCHAR(100)     NOT NULL, 
dia_semana VARCHAR(100) NOT NULL,
turma_id    INT       NOT NULL,
statusAgenda VARCHAR(20) NOT NULL,

Primary Key (id),
Foreign Key (turma_id) REFERENCES Turma(id)
)


INSERT Usuario
(nome, email, senha, nivelAcesso, foto, statusUsuario)
VALUES
('Ana Sa', 'ana@gmail.com', '123', 'ADMIN', null, 'ATIVO')
INSERT Usuario
(nome, email, senha, nivelAcesso, foto, statusUsuario)
VALUES
('Jo�o Sa', 'Jo�o@gmail.com', '123', 'USER', null, 'ATIVO')

SELECT * FROM Usuario

*/