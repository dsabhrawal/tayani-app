use tayani_data;

show tables;

drop table Person;

CREATE TABLE if not exists`Person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- Describe the table
DESCRIBE Person;

INSERT INTO Person VALUES (1, "Harry Potter", "England");

INSERT INTO Person VALUES (2, "Ron Weasly", "England");

INSERT INTO Person VALUES (3, "Hermione Granger", "England");

SELECT * FROM Person;




