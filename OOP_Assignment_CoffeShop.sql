-- MySQL Script generated by MySQL Workbench
-- Sat May 29 16:55:33 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema coffeeshopdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema coffeeshopdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `coffeeshopdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `coffeeshopdb` ;

-- -----------------------------------------------------
-- Table `coffeeshopdb`.`ban`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`ban` (
  `maBan` INT NOT NULL,
  `sucChua` INT NOT NULL,
  `tinhTrang` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`maBan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`bophan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`bophan` (
  `maBP` INT NOT NULL,
  `tenBP` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`maBP`),
  UNIQUE INDEX `tenBP_UNIQUE` (`tenBP` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`nuocuong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`nuocuong` (
  `maNU` INT NOT NULL,
  `tenNU` VARCHAR(50) NOT NULL,
  `giaBan` DECIMAL(10,0) NOT NULL,
  `tinhTrang` VARCHAR(50) NOT NULL,
  `thoidiemBan` VARCHAR(50) NOT NULL,
  `danhMuc` VARCHAR(50) NOT NULL,
  `loaiNU` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`maNU`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`thucan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`thucan` (
  `maTA` INT NOT NULL,
  `tenTA` VARCHAR(50) NOT NULL,
  `giaBan` INT NOT NULL,
  `tinhTrang` VARCHAR(50) NOT NULL,
  `thoidiemBan` VARCHAR(50) NOT NULL,
  `danhMuc` VARCHAR(50) NOT NULL,
  `loaiTA` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`maTA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`chitiethoadon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`chitiethoadon` (
  `maHD` INT NOT NULL AUTO_INCREMENT,
  `maTA` INT NULL DEFAULT NULL,
  `soLuongTA` INT NULL DEFAULT NULL,
  `maNU` INT NULL DEFAULT NULL,
  `soLuongNU` INT NULL DEFAULT NULL,
  `maBan` INT NULL DEFAULT NULL,
  `giaTien` INT NULL DEFAULT NULL,
  PRIMARY KEY (`maHD`),
  INDEX `fk_chitiethoadon_thucan_idx` (`maTA` ASC) VISIBLE,
  INDEX `fk_chitiethoadon_nuocuong_idx` (`maNU` ASC) VISIBLE,
  INDEX `fk_chitiethoadon_ban_idx` (`maBan` ASC) VISIBLE,
  CONSTRAINT `fk_chitiethoadon_ban`
    FOREIGN KEY (`maBan`)
    REFERENCES `coffeeshopdb`.`ban` (`maBan`),
  CONSTRAINT `fk_chitiethoadon_nuocuong`
    FOREIGN KEY (`maNU`)
    REFERENCES `coffeeshopdb`.`nuocuong` (`maNU`),
  CONSTRAINT `fk_chitiethoadon_thucan`
    FOREIGN KEY (`maTA`)
    REFERENCES `coffeeshopdb`.`thucan` (`maTA`))
ENGINE = InnoDB
AUTO_INCREMENT = 148
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`nhanvien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`nhanvien` (
  `maNV` INT NOT NULL AUTO_INCREMENT,
  `hotenNV` VARCHAR(50) NOT NULL,
  `gioiTinh` VARCHAR(45) NOT NULL,
  `queQuan` VARCHAR(45) NOT NULL,
  `ngaySinh` DATE NOT NULL,
  `ngayVaoLam` DATE NOT NULL,
  `maBP` INT NOT NULL,
  PRIMARY KEY (`maNV`),
  INDEX `fk_nhanvien_bophan_idx` (`maBP` ASC) VISIBLE,
  CONSTRAINT `fk_nhanvien_bophan`
    FOREIGN KEY (`maBP`)
    REFERENCES `coffeeshopdb`.`bophan` (`maBP`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`hoadon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`hoadon` (
  `maHD` INT NOT NULL,
  `maNV` INT NOT NULL,
  `OrderDate` DATE NOT NULL,
  PRIMARY KEY (`maHD`),
  INDEX `fk_hoadon_nhanvien_idx` (`maNV` ASC) VISIBLE,
  CONSTRAINT `fk_hoadon_nhanvien`
    FOREIGN KEY (`maNV`)
    REFERENCES `coffeeshopdb`.`nhanvien` (`maNV`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`thanhtoan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`thanhtoan` (
  `tenSP` VARCHAR(50) NOT NULL DEFAULT '',
  `soLuong` BIGINT NOT NULL DEFAULT '0',
  `giaTien` DECIMAL(30,0) NOT NULL DEFAULT '0')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `coffeeshopdb`.`thongke`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeeshopdb`.`thongke` (
  `tenSP` VARCHAR(50) NOT NULL,
  `soLuong` INT NULL DEFAULT NULL,
  `giaTien` INT NULL DEFAULT NULL,
  PRIMARY KEY (`tenSP`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
