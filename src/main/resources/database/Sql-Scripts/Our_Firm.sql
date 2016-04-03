use tayani_data;


CREATE TABLE if not exists`OUR_FIRM` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `our_firm_name` varchar(20) NOT NULL DEFAULT '',
  `owner` varchar(20) DEFAULT NULL,
  `date_of_incorporation` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- Describe the table
DESCRIBE OUR_FIRM;

INSERT INTO Person VALUES (1, "Harry Potter", "England");

INSERT INTO Person VALUES (2, "Ron Weasly", "England");