

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

CREATE TABLE IF NOT EXISTS `mydb`.`theater` (
  `theater_id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(128) NULL,
  `name` VARCHAR(64) NULL,
  `bio` VARCHAR(256) NULL,
  PRIMARY KEY (`theater_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`hall` (
  `hall_id` INT NOT NULL AUTO_INCREMENT,
  `theater_id` INT,
  `num` INT,
  PRIMARY KEY (`hall_id`),
  INDEX `pl_ha_idx` (`hall_id` ASC),
  CONSTRAINT `ha_th`
    FOREIGN KEY (`theater_id`)
    REFERENCES `mydb`.`theater` (`theater_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`places` (
  `place_id` INT NOT NULL AUTO_INCREMENT,
  `hall_id` INT,
  `row_num` INT NULL,
  `num` INT NULL,
  `type` INT NULL,
  PRIMARY KEY (`place_id`),
  INDEX `pl_ha_idx` (`hall_id` ASC),
  CONSTRAINT `pl_ha`
    FOREIGN KEY (`hall_id`)
    REFERENCES `mydb`.`hall` (`hall_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`scenario` (
  `scenario_id` INT NOT NULL AUTO_INCREMENT,
  `source_name` VARCHAR(256) NULL,
  `Author` VARCHAR(128) NULL,
  PRIMARY KEY (`scenario_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`shows` (
  `show_id` INT NOT NULL AUTO_INCREMENT,
  `hall_id` INT NULL,
  `dat` DATETIME NULL,
  `scenario_id` INT NULL,
  `Duration` INT NULL,
  PRIMARY KEY (`show_id`),
  INDEX `sh_pl_idx` (`hall_id` ASC),
  INDEX `sh_sc_idx` (`scenario_id` ASC),
  CONSTRAINT `sh_pl`
    FOREIGN KEY (`hall_id`)
    REFERENCES `mydb`.`hall` (`hall_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `sh_sc`
    FOREIGN KEY (`scenario_id`)
    REFERENCES `mydb`.`scenario` (`scenario_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`place_for_sell` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` INT NULL,
  `free` INT NULL,
  `show_id` INT NOT NULL,
  `place_id` INT NOT NULL,
  PRIMARY KEY(`id`), 
  CONSTRAINT `se_pl`
    FOREIGN KEY (`place_id`)
    REFERENCES `mydb`.`places` (`place_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `se_sh`
    FOREIGN KEY (`show_id`)
    REFERENCES `mydb`.`shows` (`show_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`worker` (
  `worker_id` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `bio` VARCHAR(256) NULL,
  PRIMARY KEY (`worker_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`worker_in_theater` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `worker_id` INT NOT NULL,
  `theater_id` INT NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY(`id`),
  CONSTRAINT `wo_th`
    FOREIGN KEY (`theater_id`)
    REFERENCES `mydb`.`theater` (`theater_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `wo_wor`
    FOREIGN KEY (`worker_id`)
    REFERENCES `mydb`.`worker` (`worker_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`worker_in_show` (  
  `id` INT NOT NULL AUTO_INCREMENT,
  `worker_id` INT NOT NULL,
  `show_id` INT NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY(`id`),
  CONSTRAINT `wosh_wo`
    FOREIGN KEY (`worker_id`)
    REFERENCES `mydb`.`worker` (`worker_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `wosh_sh`
    FOREIGN KEY (`show_id`)
    REFERENCES `mydb`.`shows` (`show_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `place_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY(`id`),
  CONSTRAINT `bo_plse`
    FOREIGN KEY (`place_id`)
    REFERENCES `mydb`.`place_for_sell` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `bo_cl`
    FOREIGN KEY (`client_id`)
    REFERENCES `mydb`.`client` (`client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;