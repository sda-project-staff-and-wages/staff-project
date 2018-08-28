SET FOREIGN_KEY_CHECKS = 0;
drop table if exists department;
drop table if exists employee;
drop table if exists users;
drop table if exists companys;
drop table if exists working_hours;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE department (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	company_id bigint(20) NOT NULL,
	name varchar(50) NOT NULL,
	code_name varchar(5) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(company_id) REFERENCES companys(id)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE employee (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  department_id bigint(20) NOT NULL,
  company_id bigint(20) NOT NULL,
  name varchar(30) NOT NULL,
  surname varchar(80) NOT NULL,
  agreement_type varchar(30) NOT NULL,
  working_hours_percent integer NOT NULL,
  working_hours_hourly integer NOT NULL,
  salary decimal NOT NULL,
  hire_date date NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(department_id) REFERENCES department(id),
  FOREIGN KEY(company_id) REFERENCES companys(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE users(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  company_id bigint(20) NOT NULL,
  employee_id bigint(20),
  login varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(80) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(company_id) REFERENCES companys(id),
  FOREIGN KEY(employee_id) REFERENCES employee(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE companys(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  trade varchar(50) NOT NULL,
  adress varchar(50) NOT NULL,
  nip bigint(10) NOT NULL,
  PRIMARY KEY(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE working_hours(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  workday date NOT NULL,
  employee_id bigint(20) NOT NULL,
  start_hour int(2) NOT NULL,
  start_minut int(2) DEFAULT 0,
  end_hour int(2) NOT NULL,
  end_minut int(2) DEFAULT 0,
  work_time int(2),
  absence_type varchar(50),
  PRIMARY KEY(id),
  FOREIGN KEY(employee_id) REFERENCES employee(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;