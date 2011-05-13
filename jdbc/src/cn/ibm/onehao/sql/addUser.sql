DELIMITER $$

DROP PROCEDURE IF EXISTS `jdbc`.`addUser` $$
CREATE PROCEDURE `jdbc`.`addUser` (in pname varchar(20), in birthday date, in money float, out pid int)
BEGIN 
	INSERT INTO user(username, birthday, money) values (pname, birthday, money);
	select last_insert_id() into pid;
END $$

DELIMITER ;