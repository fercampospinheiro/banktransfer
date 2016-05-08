create database IF NOT EXISTS `bank-transfer`;
CREATE TABLE IF NOT EXISTS `bank-transfer`.account_bank (
    id_account_bank INTEGER NOT NULL AUTO_INCREMENT,
    balance DECIMAL(19 , 2 ),
    `limitValue` DECIMAL(19 , 2 ),
    number VARCHAR(7),
    id_holder_account INTEGER,
    PRIMARY KEY (id_account_bank)
);
CREATE TABLE IF NOT EXISTS `bank-transfer`.bank (
    id_bank INTEGER NOT NULL AUTO_INCREMENT,
    code INTEGER,
    name VARCHAR(255),
    PRIMARY KEY (id_bank)
);
CREATE TABLE IF NOT EXISTS `bank-transfer`.holder_account (
    id_holder_account INTEGER NOT NULL AUTO_INCREMENT,
    birthDate DATETIME,
    name VARCHAR(255),
    PRIMARY KEY (id_holder_account)
);
CREATE TABLE IF NOT EXISTS `bank-transfer`.scheduled_transactions (
    id_scheduled_transactions INTEGER NOT NULL AUTO_INCREMENT,
    dateScheduled DATETIME,
    value DECIMAL(19 , 2 ),
    id_account_destination INTEGER,
    id_account_origin INTEGER,
    PRIMARY KEY (id_scheduled_transactions)
);
CREATE TABLE IF NOT EXISTS `bank-transfer`.extract_account (
    id_extract_account INTEGER NOT NULL AUTO_INCREMENT,
    date_extract DATETIME,
    id_account_movimentation INTEGER,
    type_account TINYINT(1),  
    value DECIMAL(19 , 2 ),
    number_account_destination VARCHAR(7),
    currency_balance DECIMAL(19,2),
    PRIMARY KEY (id_extract_account)
);
ALTER TABLE `bank-transfer`.`scheduled_transactions` 
ADD COLUMN `status_processing` VARCHAR(20) NULL AFTER `id_account_origin`;
ALTER TABLE `bank-transfer`.`extract_account` 
CHANGE COLUMN `type_account` `type_account` VARCHAR(30) NULL DEFAULT NULL ;

