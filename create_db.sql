-- MySQL Script generated by MySQL Workbench
-- Sun Jun 30 23:55:53 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema logotype
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema logotype
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `logotype` DEFAULT CHARACTER SET utf8 ;
USE `logotype` ;

-- -----------------------------------------------------
-- Table `logotype`.`field`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logotype`.`field` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `is_active` BIT(1) NULL DEFAULT NULL,
  `label` VARCHAR(255) NULL DEFAULT NULL,
  `required` BIT(1) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logotype`.`field_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logotype`.`field_option` (
  `field_id` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `field_option_id_uindex` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logotype`.`responce`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logotype`.`responce` (
  `user_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logotype`.`responce_has_field`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logotype`.`responce_has_field` (
  `responce_id` INT(11) NOT NULL,
  `field_id` INT(11) NOT NULL,
  `value` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`responce_id`, `field_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logotype`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logotype`.`user` (
  `email` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;