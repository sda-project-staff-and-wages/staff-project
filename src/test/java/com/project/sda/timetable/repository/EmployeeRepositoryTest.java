package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.AgreementType;
import com.project.sda.timetable.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static com.project.sda.timetable.repository.DefaultDataTest.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Sql("/defaultData-test.sql")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldGetEmployeeById() {
        //given
        Long id = 1L;
        Employee employee = getEmployee1();

        //when
        Optional<Employee> testEmployee = employeeRepository.findById(id);

        //then
        assertThat(testEmployee.isPresent(), is(true));
        assertThat(testEmployee.get(), equalTo(employee));
    }

    @Test
    public void shouldGetEmployeeBySurname() {
        //given
        String surname = "surname1";
        Employee employee = getEmployee1();

        //when
        Optional<Employee> testEmployee = employeeRepository.findBySurname(surname);

        //then
        assertThat(testEmployee.isPresent(), is(true));
        assertThat(testEmployee.get(), equalTo(employee));
    }

    @Test
    public void shouldGetAllEmployees() {
        //given
        Employee employee1 = getEmployee1();
        Employee employee2 = getEmployee2();

        //when
        List<Employee> testEmployees = employeeRepository.findAll();

        //then
        assertThat(testEmployees, hasSize(2));
        assertThat(testEmployees, hasItems(employee1, employee2));
    }

    @Test
    public void shouldAddEmployee() {
        //given
        Employee employee = getEmployee3();

        //when
        Employee testEmployee = employeeRepository.save(employee);

        //then
        assertThat(testEmployee.getId(), is(notNullValue()));
        assertThat(testEmployee.getName(), equalTo(employee.getName()));
        assertThat(testEmployee.getSurname(), equalTo(employee.getSurname()));
        assertThat(testEmployee.getAgreementType(), equalTo(employee.getAgreementType()));
        assertThat(testEmployee.getWorkingHoursPercent(), equalTo(employee.getWorkingHoursPercent()));
        assertThat(testEmployee.getWorkingHoursHourly(), equalTo(employee.getWorkingHoursHourly()));
        assertThat(testEmployee.getSalary(), equalTo(employee.getSalary()));
        assertThat(testEmployee.getHireDate(), equalTo(employee.getHireDate()));
    }

    @Test
    public void shouldUpdateEmployee() {
        //given
        Employee employee = getEmployee1();
        employee.setName("name-update");
        employee.setSurname("surname-update");
        employee.setAgreementType(AgreementType.COMMISION_CONTRACT);
        employee.setWorkingHoursPercent(80);
        employee.setWorkingHoursHourly(120);
        employee.setSalary(BigDecimal.valueOf(800));
        employee.setHireDate(LocalDate.of(2018,5,31));

        //when
        Employee testEmployee = employeeRepository.save(employee);

        //then
        assertThat(testEmployee, equalTo(employee));
    }

    @Test
    public void shouldDeleteEmployee() {
        //given
        Long id = 1L;

        //when
        employeeRepository.deleteById(id);

        //then
        Optional<Employee> testEmployee = employeeRepository.findById(id);
        assertThat(testEmployee.isPresent(), is(false));
    }
}
