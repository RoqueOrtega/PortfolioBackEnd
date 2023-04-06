-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_portfolio` DEFAULT CHARACTER SET utf8mb4 ;
USE `bd_portfolio` ;

-- -----------------------------------------------------
-- Table `bd_portfolio`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `descripcion` VARCHAR(100) NULL,
  `acercade` VARCHAR(500) NULL,
  `imagen` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `telefono` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`localidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`localidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_domicilio_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `bd_portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`experiencia_laboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`experiencia_laboral` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `puesto` VARCHAR(50) NULL,
  `empresa` VARCHAR(50) NULL,
  `imagen` VARCHAR(100) NULL,
  `fecha_desde` DATE NULL,
  `fecha_hasta` DATE NULL,
  `descripcion` VARCHAR(500) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_experiencia_laboral_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `bd_portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`educacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NULL,
  `entidad_otorgante` VARCHAR(50) NULL,
  `imagen` VARCHAR(100) NULL,
  `fecha_desde` DATE NULL,
  `fecha_hasta` DATE NULL,
  `descripcion` VARCHAR(500) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_educacion_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `bd_portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`habilidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`habilidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `porcentaje` INT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tecnologias_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `bd_portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`proyectos` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(50) NULL,
  `fecha_desde` DATE NULL,
  `fecha_hasta` DATE NULL,
  `descripcion` VARCHAR(500) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_proyectos_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `bd_portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_portfolio`.`provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_portfolio`.`provincias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `provinciascol` VARCHAR(45) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_provincias_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `bd_portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
