DELETE FROM department;
DELETE FROM employee;
DELETE FROM users;

INSERT INTO department (id, name, code_name) VALUES (1, "name1", "cn1");
INSERT INTO department (id, name, code_name) VALUES (2, "name2", "cn2");

INSERT INTO employee (id, department_id, name, surname, agreement_type, working_hours_percent, working_hours_hourly, salary, hire_date)
  VALUES (1, 1, "name1", "surname1", "JOB_CONTRACT", 100, 176, 1000, "2017-01-01");

INSERT INTO employee (id, department_id, name, surname, agreement_type, working_hours_percent, working_hours_hourly, salary, hire_date)
  VALUES (2, 2, "name2", "surname2", "JOB_CONTRACT", 50, 88, 2000, "2018-01-01");

INSERT INTO users (id, employee_id, login, password, email) VALUES (1, 1, "login1", "password1", "email@konto1.pl");
INSERT INTO users (id, employee_id, login, password, email) VALUES (2, 2, "login2", "password2", "email@konto2.pl");