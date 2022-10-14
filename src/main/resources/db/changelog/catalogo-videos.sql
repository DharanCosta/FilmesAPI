USE [catalogo-videos];

CREATE TABLE Responsavel (
	IdResponsavel		int				identity,
	NomeResponsavel		varchar(255)	NOT NULL,
);

ALTER TABLE Responsavel 
ADD CONSTRAINT PK_Responsavel PRIMARY KEY (IdResponsavel);

CREATE TABLE Categoria (
	IdCategoria			int				identity,
	NomeCategoria		varchar(255)	NOT NULL,
);

ALTER TABLE Categoria 
ADD CONSTRAINT PK_Categoria PRIMARY KEY (IdCategoria);

CREATE TABLE Video (
	IdVideo				int				identity,
	TituloVideo			nvarchar(255)   NOT NULL,
	URL					nvarchar(2083)	NOT NULL,
	IdadeMinima			tinyint					,
	IdResponsavel		int				NOT NULL,
);


ALTER TABLE Video 
ADD CONSTRAINT PK_Video PRIMARY KEY (IdVideo);

ALTER TABLE Video 
ADD CONSTRAINT FK_Video_Responsavel FOREIGN KEY (IdResponsavel) 
REFERENCES Responsavel (IdResponsavel);

CREATE TABLE VideoCategoria (
	Id					int				identity,
	IdVideo				int				NOT NULL,
	IdCategoria			int				NOT NULL,
);

ALTER TABLE VideoCategoria 
ADD CONSTRAINT PK_VideoCategoria PRIMARY KEY (Id);

ALTER TABLE VideoCategoria 
ADD CONSTRAINT FK_VideoCategoria_Video FOREIGN KEY (IdVideo) 
REFERENCES Video (IdVideo);

ALTER TABLE VideoCategoria 
ADD CONSTRAINT FK_VideoCategoria_Categoria FOREIGN KEY (IdCategoria) 
REFERENCES Categoria (IdCategoria);