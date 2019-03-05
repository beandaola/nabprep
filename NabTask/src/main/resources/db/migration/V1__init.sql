CREATE TABLE `person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `client` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `todo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `summary` VARCHAR(45) NULL,
  `discription` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
insert into person(name , client) value('bean','nab');
insert into person(name , client) value('brian','ea');
