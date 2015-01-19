-- MySQL Script generated by MySQL Workbench
-- 01/18/15 18:02:45
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `cedUsuario` INT(11) NOT NULL,
  `nomUsuario` VARCHAR(45) NOT NULL,
  `dirUsuario` VARCHAR(45) NOT NULL,
  `telUsuario` VARCHAR(12) NULL,
  PRIMARY KEY (`cedUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Proveedor` (
  `rucProveedor` INT(15) NOT NULL,
  `razonProveedor` VARCHAR(45) NOT NULL,
  `nomComProveedor` VARCHAR(45) NULL,
  `dirProveedor` VARCHAR(45) NOT NULL,
  `telProveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rucProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Factura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Factura` (
  `idFactura` INT(11) NOT NULL AUTO_INCREMENT,
  `fecFactura` DATE NOT NULL,
  `subtFactura` FLOAT NOT NULL,
  `descFactura` FLOAT NULL,
  `ivaFactura` FLOAT NULL,
  `totFactura` FLOAT NOT NULL,
  `respFactura` VARCHAR(45) NULL,
  `tipFactura` VARCHAR(45) NOT NULL,
  `iceFactura` VARCHAR(45) NULL,
  `Usuario_cedUsuario` INT(11) NOT NULL,
  `Proveedor_rucProveedor` INT(15) NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Usuario_idx` (`Usuario_cedUsuario` ASC),
  INDEX `fk_Factura_Proveedor1_idx` (`Proveedor_rucProveedor` ASC),
  CONSTRAINT `fk_Factura_Usuario`
    FOREIGN KEY (`Usuario_cedUsuario`)
    REFERENCES `mydb`.`Usuario` (`cedUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Proveedor1`
    FOREIGN KEY (`Proveedor_rucProveedor`)
    REFERENCES `mydb`.`Proveedor` (`rucProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`control`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`control` ;

CREATE TABLE IF NOT EXISTS `mydb`.`control` (
  `nomUsuario` VARCHAR(30) NOT NULL,
  `claUsuario` VARCHAR(45) NOT NULL,
  `preUsuario` VARCHAR(45) NOT NULL,
  `pisUsuario` VARCHAR(45) NULL,
  PRIMARY KEY (`nomUsuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;