SET FOREIGN_KEY_CHECKS = 0;
drop table if exists department;
drop table if exists employee;
drop table if exists users;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE department (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	code_name varchar(5) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE employee (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  department_id bigint(20) NOT NULL,
  name varchar(30) NOT NULL,
  surname varchar(80) NOT NULL,
  agreement_type varchar(30) NOT NULL,
  working_hours_percent integer NOT NULL,
  working_hours_hourly integer NOT NULL,
  salary decimal NOT NULL,
  hire_date date NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(department_id) REFERENCES department(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE users(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  employee_id bigint(20),
  login varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(80) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(employee_id) REFERENCES employee(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
