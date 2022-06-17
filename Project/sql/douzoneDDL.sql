-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema douzone
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema douzone
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `douzone` DEFAULT CHARACTER SET utf8 ;
USE `douzone` ;

-- -----------------------------------------------------
-- Table `douzone`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `douzone`.`manager` (
  `manager_id` INT NOT NULL AUTO_INCREMENT,
  `manager_name` VARCHAR(10) NOT NULL,
  `manager_phone` VARCHAR(15) NULL,
  PRIMARY KEY (`manager_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `douzone`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `douzone`.`student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `student_name` VARCHAR(10) NOT NULL,
  `student_age` INT NOT NULL,
  `student_phone` VARCHAR(15) NULL,
  `student_addr` VARCHAR(20) NULL,
  `student_seatId` VARCHAR(10) NOT NULL,
  `student_attendance` INT NOT NULL DEFAULT 0,
  `student_absent` INT NOT NULL DEFAULT 0,
  `manager_manager_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`student_id`),
  INDEX `fk_student_manager1_idx` (`manager_manager_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_manager1`
    FOREIGN KEY (`manager_manager_id`)
    REFERENCES `douzone`.`manager` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `douzone`.`instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `douzone`.`instructor` (
  `instructor_id` INT NOT NULL AUTO_INCREMENT,
  `instructor_name` VARCHAR(10) NOT NULL,
  `instructor_phone` VARCHAR(15) NULL,
  PRIMARY KEY (`instructor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `douzone`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `douzone`.`course` (
  `course_id` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(10) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `instructor_instructor_id` INT NULL DEFAULT 1,
  PRIMARY KEY (`course_id`),
  INDEX `fk_course_instructor1_idx` (`instructor_instructor_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_instructor1`
    FOREIGN KEY (`instructor_instructor_id`)
    REFERENCES `douzone`.`instructor` (`instructor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `douzone`.`course_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `douzone`.`course_details` (
  `course_details_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  INDEX `fk_student_and_course_student_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_student_and_course_course1_idx` (`course_id` ASC) VISIBLE,
  PRIMARY KEY (`course_details_id`),
  CONSTRAINT `fk_student_and_course_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `douzone`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_and_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `douzone`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;