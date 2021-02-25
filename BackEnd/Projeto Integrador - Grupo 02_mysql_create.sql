CREATE TABLE `Categoria` (
	`Id_Categoria` bigint(5) NOT NULL AUTO_INCREMENT,
	`Nome_Categoria` varchar(30) NOT NULL,
	`Tema` varchar(30) NOT NULL,
	`Nacionalidade` varchar(20) NOT NULL,
	PRIMARY KEY (`Id_Categoria`)
);

CREATE TABLE `Produto` (
	`Id_Produto` bigint(5) NOT NULL AUTO_INCREMENT,
	`Nome_Produto` varchar(150) NOT NULL,
	`Preco` DECIMAL(6,2) NOT NULL,
	`Qtd_Estoque` bigint(3) NOT NULL,
	`Imagem` varchar(2000) NOT NULL,
	`Categoria_Id` bigint(5) NOT NULL,
	PRIMARY KEY (`Id_Produto`)
);

CREATE TABLE `Usuario` (
	`Nome_Usuario` varchar(100) NOT NULL,
	`Senha` varchar(16) NOT NULL,
	`Email` varchar(50) NOT NULL,
	PRIMARY KEY (`Email`)
);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk0` FOREIGN KEY (`Categoria_Id`) REFERENCES `Categoria`(`Id_Categoria`);

