-- MySQL Script generated by MySQL Workbench
-- Thu Sep 27 02:40:48 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_sys_vendas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_sys_vendas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_sys_vendas` DEFAULT CHARACTER SET utf8 ;
USE `db_sys_vendas` ;

-- -----------------------------------------------------
-- Table `db_sys_vendas`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`categorias` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 73
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Tabela de fornecedores';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`clientes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `sobreNome` VARCHAR(45) NULL DEFAULT NULL,
  `nascimento` DATE NULL DEFAULT NULL,
  `pessoa` ENUM('FISICA', 'JURIDICA') NULL DEFAULT NULL,
  `sexo` ENUM('M', 'F') NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `celular` VARCHAR(45) NULL DEFAULT NULL,
  `situacao` ENUM('ATIVO', 'BLOQUEADO') NULL DEFAULT NULL,
  `observacao` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `uf` VARCHAR(45) NULL DEFAULT NULL,
  `cep` VARCHAR(45) NULL DEFAULT NULL,
  `fone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Tabela de Clientes';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`enderecos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`enderecos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `uf` VARCHAR(2) NULL DEFAULT NULL,
  `cep` VARCHAR(45) NULL DEFAULT NULL,
  `fone` VARCHAR(45) NULL DEFAULT NULL,
  `observacao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`enderecos_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`enderecos_clientes` (
  `fk_endereco` INT(11) NULL DEFAULT NULL,
  `fk_cliente` INT(11) NULL DEFAULT NULL,
  INDEX `fk_ender_clien_cliente_idx` (`fk_cliente` ASC) VISIBLE,
  INDEX `fk_ender_client_ender_idx` (`fk_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_ender_clien_cliente`
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `db_sys_vendas`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ender_client_ender`
    FOREIGN KEY (`fk_endereco`)
    REFERENCES `db_sys_vendas`.`enderecos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Relacao Endereco e Clientes';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`estoques`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`estoques` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `qtdEntrada` INT(11) NULL DEFAULT '0',
  `qtdSaida` INT(11) NULL DEFAULT '0',
  `qtdMinima` INT(11) NULL DEFAULT '0',
  `qtdDisponivel` INT(11) GENERATED ALWAYS AS ((`qtdEntrada` - `qtdSaida`)) VIRTUAL,
  `status` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 52
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`fornecedores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `pessoa` ENUM('FISICA', 'JURIDICA') NULL DEFAULT NULL,
  `cnpjCpf` VARCHAR(45) NULL DEFAULT NULL,
  `cep` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `uf` VARCHAR(2) NULL DEFAULT NULL,
  `fone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `observacao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Tabela de fornecedores assoiada a produtos';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`orcamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`orcamentos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_cliente` INT(11) NULL DEFAULT NULL,
  `fk_usuario` INT(11) NULL DEFAULT NULL,
  `subtotal` INT(11) NULL DEFAULT NULL,
  `descontos` INT(11) NULL DEFAULT NULL,
  `total` INT(11) NULL DEFAULT NULL,
  `dataLancamento` DATE NULL DEFAULT NULL,
  `confirmado` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_orcamento_usuarios` (`fk_usuario` ASC) VISIBLE,
  INDEX `fk_orcamento_clientes_idx` (`fk_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_orcamento_clientes`
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `db_sys_vendas`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_orcamento_usuarios`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `db_sys_vendas`.`usuarios` (`id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabela de orcamentos';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`produtos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_categoria` INT(11) NULL DEFAULT NULL,
  `fk_estoque` INT(11) NULL DEFAULT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  `indicacao` VARCHAR(45) NULL DEFAULT NULL,
  `volume` VARCHAR(45) NULL DEFAULT NULL,
  `custoUnid` INT(11) NULL DEFAULT NULL,
  `sugestaoVenda` INT(11) NULL DEFAULT NULL,
  `imagem` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_categorias_idx` (`fk_categoria` ASC) VISIBLE,
  INDEX `fk_produtos_estoques_idx` (`fk_estoque` ASC) VISIBLE,
  CONSTRAINT `fk_produtos_categorias`
    FOREIGN KEY (`fk_categoria`)
    REFERENCES `db_sys_vendas`.`categorias` (`id`),
  CONSTRAINT `fk_produtos_estoques`
    FOREIGN KEY (`fk_estoque`)
    REFERENCES `db_sys_vendas`.`estoques` (`id`)
    ON UPDATE SET NULL)
ENGINE = InnoDB
AUTO_INCREMENT = 63
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`orcamentos_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`orcamentos_produtos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_orcamento` INT(11) NULL DEFAULT NULL,
  `fk_produto` INT(11) NULL DEFAULT NULL,
  `qtd` INT(11) NULL DEFAULT NULL,
  `sub_total` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orcamentoproduto_orcamentos_idx` (`fk_orcamento` ASC) VISIBLE,
  INDEX `fk_orcamentoproduto_produtos_idx` (`fk_produto` ASC) VISIBLE,
  CONSTRAINT `fk_orcamentoproduto_orcamentos`
    FOREIGN KEY (`fk_orcamento`)
    REFERENCES `db_sys_vendas`.`orcamentos` (`id`),
  CONSTRAINT `fk_orcamentoproduto_produtos`
    FOREIGN KEY (`fk_produto`)
    REFERENCES `db_sys_vendas`.`produtos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Tabela carrinho';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`pagamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`pagamentos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_orcamento` INT(11) NULL DEFAULT NULL,
  `valorTotal` INT(11) NULL DEFAULT NULL,
  `qtdParcelas` INT(11) NULL DEFAULT NULL,
  `valorParcela` INT(11) NULL DEFAULT NULL,
  `diaVencimento` INT(2) NULL DEFAULT NULL,
  `parcelasPagas` INT(11) NULL DEFAULT NULL,
  `status` ENUM('EM_ATRASO', 'EM_DIAS', 'QUITADO') NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pagamentos_orcamentos_idx` (`fk_orcamento` ASC) VISIBLE,
  CONSTRAINT `fk_pagamentos_orcamentos`
    FOREIGN KEY (`fk_orcamento`)
    REFERENCES `db_sys_vendas`.`orcamentos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Tabela de pagamentos associada ao orcamento';


-- -----------------------------------------------------
-- Table `db_sys_vendas`.`produtos_fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_vendas`.`produtos_fornecedores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_produto` INT(11) NULL DEFAULT NULL,
  `fk_fornecedor` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_id_idx` (`fk_produto` ASC) VISIBLE,
  INDEX `fk_fornecedor_id_idx` (`fk_fornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_id`
    FOREIGN KEY (`fk_fornecedor`)
    REFERENCES `db_sys_vendas`.`fornecedores` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_produtos_id`
    FOREIGN KEY (`fk_produto`)
    REFERENCES `db_sys_vendas`.`produtos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 57
DEFAULT CHARACTER SET = utf8
COMMENT = 'Relacionamento entre produtos e fornecedores';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
