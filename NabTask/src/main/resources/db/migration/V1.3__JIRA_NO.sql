ALTER TABLE `todo` 
ADD COLUMN `person_id` BIGINT(11) NOT NULL AFTER `description`;