
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema my_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema my_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `my_db` DEFAULT CHARACTER SET utf8 ;
USE `my_db` ;

-- -----------------------------------------------------
-- Table `my_db`.`developers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`developers` (
  `developer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`developer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`Skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`Skills` (
  `Skill_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `level` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Skill_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`projects` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`project_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`companies` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `specification` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`company_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`customers` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`Developers_projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`Developers_projects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `developer_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `dev_id_idx` (`developer_id` ASC) VISIBLE,
  INDEX `prj_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `dev_id`
    FOREIGN KEY (`developer_id`)
    REFERENCES `my_db`.`developers` (`developer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `prj_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `my_db`.`projects` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`developers_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`developers_skills` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `developer_id` INT NOT NULL,
  `skill_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `develop_id_idx` (`developer_id` ASC) VISIBLE,
  INDEX `skill_id_idx` (`skill_id` ASC) VISIBLE,
  CONSTRAINT `develop_id`
    FOREIGN KEY (`developer_id`)
    REFERENCES `my_db`.`developers` (`developer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `skill_id`
    FOREIGN KEY (`skill_id`)
    REFERENCES `my_db`.`Skills` (`Skill_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`projects_developers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`projects_developers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NOT NULL,
  `developer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `devp_id_idx` (`developer_id` ASC) VISIBLE,
  INDEX `proj_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `devp_id`
    FOREIGN KEY (`developer_id`)
    REFERENCES `my_db`.`developers` (`developer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `proj_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `my_db`.`projects` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`companies_projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`companies_projects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `comp_id_idx` (`company_id` ASC) VISIBLE,
  INDEX `prj_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `comp_id`
    FOREIGN KEY (`company_id`)
    REFERENCES `my_db`.`companies` (`company_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `projects_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `my_db`.`projects` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_db`.`customers_projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`customers_projects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cust_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `project_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `cust_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `my_db`.`customers` (`customer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `my_db`.`projects` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO `my_db`.`companies` (`company_id`, `name`, `specification`) VALUES ('1', 'ITG', 'Game');
INSERT INTO `my_db`.`companies` (`company_id`, `name`, `specification`) VALUES ('2', 'ITW', 'Web');
INSERT INTO `my_db`.`companies` (`company_id`, `name`, `specification`) VALUES ('3', 'ITS', 'Software');
INSERT INTO `my_db`.`companies` (`company_id`, `name`, `specification`) VALUES ('4', 'ITA', 'Android');


INSERT INTO `my_db`.`customers` (`customer_id`, `name`, `gender`) VALUES ('1', 'Xander', 'male');
INSERT INTO `my_db`.`customers` (`customer_id`, `name`, `gender`) VALUES ('2', 'Liza', 'female');
INSERT INTO `my_db`.`customers` (`customer_id`, `name`, `gender`) VALUES ('3', 'Sasha', 'male');
INSERT INTO `my_db`.`customers` (`customer_id`, `name`, `gender`) VALUES ('4', 'Masha', 'female');


INSERT INTO `my_db`.`developers` (`developer_id`, `name`, `gender`, `age`) VALUES ('1', 'Vadim', 'male', '21');
INSERT INTO `my_db`.`developers` (`developer_id`, `name`, `gender`, `age`) VALUES ('2', 'Sasha', 'male', '25');
INSERT INTO `my_db`.`developers` (`developer_id`, `name`, `gender`, `age`) VALUES ('3', 'Masha', 'female', '19');
INSERT INTO `my_db`.`developers` (`developer_id`, `name`, `gender`, `age`) VALUES ('4', 'Katya', 'female', '26');
INSERT INTO `my_db`.`developers` (`developer_id`, `name`, `gender`, `age`) VALUES ('5', 'Vasya', 'male', '24');


INSERT INTO `my_db`.`projects` (`project_id`, `name`, `description`, `date`) VALUES ('1', 'Game_1', 'game', '12.6.18');
INSERT INTO `my_db`.`projects` (`project_id`, `name`, `description`, `date`) VALUES ('2', 'Soft', 'SoftWare', '15.7.19');
INSERT INTO `my_db`.`projects` (`project_id`, `name`, `description`, `date`) VALUES ('3', 'WWW', 'WEb', '1.9.19');
INSERT INTO `my_db`.`projects` (`project_id`, `name`, `description`, `date`) VALUES ('4', 'Ando', 'Android', '5.4.19');
INSERT INTO `my_db`.`projects` (`project_id`, `name`, `description`, `date`) VALUES ('5', 'Game_2', 'game', '1.2.18');
INSERT INTO `my_db`.`projects` (`project_id`, `name`, `description`, `date`) VALUES ('6', 'WEb', 'Web', '4.7.19');


INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('1', 'Java', 'Middle');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('2', 'Java', 'Junior');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('3', 'C++', 'Senior');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('4', 'C++', 'Junior');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('5', 'JS', 'middle');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('6', 'JS', 'Senior');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('7', 'Kotlin', 'middle');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('8', 'C#', 'Senior');
INSERT INTO `my_db`.`skills` (`Skill_id`, `name`, `level`) VALUES ('9', 'C#', 'Junior');



INSERT INTO `my_db`.`companies_projects` (`id`, `company_id`, `project_id`) VALUES ('1', '1', '1');
INSERT INTO `my_db`.`companies_projects` (`id`, `company_id`, `project_id`) VALUES ('2', '1', '5');
INSERT INTO `my_db`.`companies_projects` (`id`, `company_id`, `project_id`) VALUES ('3', '2', '3');
INSERT INTO `my_db`.`companies_projects` (`id`, `company_id`, `project_id`) VALUES ('4', '2', '6');
INSERT INTO `my_db`.`companies_projects` (`id`, `company_id`, `project_id`) VALUES ('5', '3', '2');
INSERT INTO `my_db`.`companies_projects` (`id`, `company_id`, `project_id`) VALUES ('6', '4', '4');


INSERT INTO `my_db`.`customers_projects` (`id`, `customer_id`, `project_id`) VALUES ('1', '1', '2');
INSERT INTO `my_db`.`customers_projects` (`id`, `customer_id`, `project_id`) VALUES ('2', '1', '4');
INSERT INTO `my_db`.`customers_projects` (`id`, `customer_id`, `project_id`) VALUES ('3', '2', '3');
INSERT INTO `my_db`.`customers_projects` (`id`, `customer_id`, `project_id`) VALUES ('4', '2', '5');
INSERT INTO `my_db`.`customers_projects` (`id`, `customer_id`, `project_id`) VALUES ('5', '3', '1');
INSERT INTO `my_db`.`customers_projects` (`id`, `customer_id`, `project_id`) VALUES ('6', '4', '6');


INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('1', '1', '5');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('2', '1', '2');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('3', '2', '3');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('4', '2', '2');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('5', '3', '4');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('6', '3', '1');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('7', '4', '2');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('8', '4', '1');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('9', '5', '2');
INSERT INTO `my_db`.`developers_projects` (`id`, `developer_id`, `project_id`) VALUES ('10', '5', '6');



INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('1', '1', '2');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('2', '1', '4');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('3', '2', '1');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('4', '2', '6');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('5', '3', '7');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('6', '3', '4');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('7', '4', '8');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('8', '4', '3');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('9', '5', '5');
INSERT INTO `my_db`.`developers_skills` (`id`, `developer_id`, `skill_id`) VALUES ('10', '5', '9');




INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('1', '1', '4');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('2', '1', '3');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('3', '2', '1');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('4', '2', '2');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('5', '2', '4');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('6', '2', '5');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('7', '3', '2');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('8', '4', '3');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('9', '5', '1');
INSERT INTO `my_db`.`projects_developers` (`id`, `project_id`, `developer_id`) VALUES ('10', '6', '5');


ALTER TABLE `my_db`.`developers`
    ADD COLUMN `salary` INT NOT NULL AFTER `age`;



UPDATE `my_db`.`developers` SET `salary` = '80000' WHERE (`developer_id` = '1');
UPDATE `my_db`.`developers` SET `salary` = '100000' WHERE (`developer_id` = '2');
UPDATE `my_db`.`developers` SET `salary` = '65000' WHERE (`developer_id` = '3');
UPDATE `my_db`.`developers` SET `salary` = '45000' WHERE (`developer_id` = '4');
UPDATE `my_db`.`developers` SET `salary` = '30000' WHERE (`developer_id` = '5');


ALTER TABLE `my_db`.`projects`
    ADD COLUMN `cost` INT NOT NULL AFTER `date`;

UPDATE `my_db`.`projects` SET `cost` = '500000' WHERE (`project_id` = '1');
UPDATE `my_db`.`projects` SET `cost` = '150000' WHERE (`project_id` = '2');
UPDATE `my_db`.`projects` SET `cost` = '200000' WHERE (`project_id` = '3');
UPDATE `my_db`.`projects` SET `cost` = '100000' WHERE (`project_id` = '4');
UPDATE `my_db`.`projects` SET `cost` = '750000' WHERE (`project_id` = '5');
UPDATE `my_db`.`projects` SET `cost` = '450000' WHERE (`project_id` = '6');
