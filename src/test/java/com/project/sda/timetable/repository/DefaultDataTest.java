package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.AgreementType;
import com.project.sda.timetable.model.Department;
import com.project.sda.timetable.model.Employee;
import com.project.sda.timetable.model.Users;
import java.math.BigDecimal;
import java.time.LocalDate;

class DefaultDataTest {

    static Department getDepartment1() {
        Department DEPARTMENT1 = new Department("cn1","name1");
        DEPARTMENT1.setId(1L);
        return DEPARTMENT1;
    }

    static Department getDepartment2() {
        Department DEPARTMENT2 = new Department("cn2","name2");
        DEPARTMENT2.setId(2L);
        return DEPARTMENT2;
    }

    static Department getDepartment3() {
        Department DEPARTMENT3 = new Department("cn3","name3");
        DEPARTMENT3.setId(3L);
        return DEPARTMENT3;
    }

    static Employee getEmployee1() {

        Employee employee1 = new Employee( "name1","surname1");

        employee1.setId(1L);
        employee1.setDepartment(getDepartment1());
        employee1.setAgreementType(AgreementType.JOB_CONTRACT);
        employee1.setWorkingHoursPercent(100);
        employee1.setWorkingHoursHourly(176);
        employee1.setSalary(BigDecimal.valueOf(1000));
        employee1.setHireDate(LocalDate.of(2017, 1, 1));

        return employee1;
    }

    static Employee getEmployee2() {

        Employee employee2 = new Employee( "name2","surname2");

        employee2.setId(2L);
        employee2.setDepartment(getDepartment2());
        employee2.setAgreementType(AgreementType.JOB_CONTRACT);
        employee2.setWorkingHoursPercent(50);
        employee2.setWorkingHoursHourly(88);
        employee2.setSalary(BigDecimal.valueOf(2000));
        employee2.setHireDate(LocalDate.of(2018, 1, 1));

        return employee2;
    }

    static Employee getEmployee3() {

        Employee employee3 = new Employee( "name3","surname3");

        employee3.setId(3L);
        employee3.setDepartment(getDepartment1());
        employee3.setAgreementType(AgreementType.JOB_CONTRACT);
        employee3.setWorkingHoursPercent(100);
        employee3.setWorkingHoursHourly(176);
        employee3.setSalary(BigDecimal.valueOf(1000));
        employee3.setHireDate(LocalDate.of(2018, 1, 1));

        return employee3;
    }

    static Users getUser1() {

        Users user1 = new Users("login1", "password1");

        user1.setId(1L);
        user1.setEmployee(getEmployee1());
        user1.setEmail("email@konto1.pl");

        return user1;
    }

    static Users getUser2() {

        Users user2 = new Users("login2", "password2");

        user2.setId(2L);
        user2.setEmployee(getEmployee2());
        user2.setEmail("email@konto2.pl");

        return user2;
    }

    static Users getUser3() {

        Users user3 = new Users("login3", "password3");

        user3.setId(3L);
        user3.setEmployee(getEmployee2());
        user3.setEmail("email@konto3.pl");

        return user3;
    }
}
