create database krwiodawstwo;

use krwiodawstwo;

CREATE TABLE IF NOT EXISTS `krwiodawstwo`.`stacja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rckik` VARCHAR(45) NOT NULL,
  `adres` VARCHAR(50) NOT NULL,
  `miasto` VARCHAR(45) NOT NULL,
  `telefon` INT NOT NULL,
  `url` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `krwiodawstwo`.`statusKrwi` (
  `0rhp` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `Arhp` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `Brhp` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `ABrhp` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `0rhm` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `Arhm` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `Brhm` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `ABrhm` ENUM("bardzo niski", "niski", "średni", "wysoki") NOT NULL,
  `stacja_id` INT NOT NULL,
  INDEX `fk_statusKrwi_stacja_idx` (`stacja_id` ASC) VISIBLE,
  CONSTRAINT `fk_statusKrwi_stacja`
    FOREIGN KEY (`stacja_id`)
    REFERENCES `krwiodawstwo`.`stacja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `krwiodawstwo`.`user` (
  `email` VARCHAR(50) NOT NULL,
  `imie` VARCHAR(45) NOT NULL,
  `nazwisko` VARCHAR(45) NOT NULL,
  `hasło` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;

delimiter $$
create trigger utworzStatus
after insert
on stacja
for each row
begin
	insert into statusKrwi values ("bardzo niski", "bardzo niski", "bardzo niski", "bardzo niski", "bardzo niski", "bardzo niski", "bardzo niski", "bardzo niski", new.id);
end $$
delimiter ;

select * from stacja;			
select * from statusKrwi;
select * from user;

-- insert into statusKrwi values ("wysoki", "średni", "wysoki", "wysoki", "bardzo niski", "bardzo niski", "bardzo niski", "wysoki", 1);
-- insert into statusKrwi values ("wysoki", "wysoki", "wysoki", "wysoki", "średni", "wysoki", "wysoki", "wysoki", 2);
-- insert into statusKrwi values ("wysoki", "wysoki", "wysoki", "wysoki", "wysoki", "wysoki", "wysoki", "wysoki", 3);

insert into stacja values (1, "RCKiK Wrocław", "ul. Czerwonego Krzyża 5-9 50-345", "Wrocław", "713715810", "https://www.rckik.wroclaw.pl/");
insert into stacja values (2, "RCKiK Warszawa", "ul. Saska 63/75 03-948", "Warszawa", "225146000", "https://www.rckik-warszawa.com.pl/");
insert into stacja values (3, "RCKiK Kraków", "ul. Rzeźnicza 11, 31-540", "Kraków", "122618820", "https://rckik.krakow.pl/");

insert into user values ("test@wp.pl", "Adam", "Małysz", "123");