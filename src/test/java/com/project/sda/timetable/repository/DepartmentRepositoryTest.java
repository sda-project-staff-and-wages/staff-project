package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import static com.project.sda.timetable.repository.DefaultDataTest.getDepartment1;
import static com.project.sda.timetable.repository.DefaultDataTest.getDepartment2;
import static com.project.sda.timetable.repository.DefaultDataTest.getDepartment3;
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
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void shouldGetDepartmentById() {
        //given
        Long id = 1L;
        Department department = getDepartment1();

        //when
        Optional<Department> testDepartment = departmentRepository.findById(id);

        //then
        assertThat(testDepartment.isPresent(), is(true));
        assertThat(testDepartment.get(), equalTo(department));
    }

    @Test
    public void shouldGetDepartmentByCodeName() {
        //given
        String codeName = "cn1";
        Department department = getDepartment1();

        //when
        Optional<Department> testDepartment = departmentRepository.findByCodeName(codeName);

        //then
        assertThat(testDepartment.isPresent(), is(true));
        assertThat(testDepartment.get(), equalTo(department));
    }

    @Test
    public void shouldGetAllDepartments() {
        //given
        Department department1 = getDepartment1();
        Department department2 = getDepartment2();

        //when
        List<Department> testDepartments = departmentRepository.findAll();

        //then
        assertThat(testDepartments, hasSize(2));
        assertThat(testDepartments, hasItems(department1, department2));
    }

    @Test
    public void shouldAddDepartment() {
        //given
        Department department = getDepartment3();

        //when
        Department testDepartment = departmentRepository.save(department);

        //then
        assertThat(testDepartment.getId(), is(notNullValue()));
        assertThat(testDepartment.getName(), equalTo(department.getName()));
        assertThat(testDepartment.getCodeName(), equalTo(department.getCodeName()));
    }

    @Test
    public void shouldUpdateDepartment() {
        //given
        Department department = getDepartment1();
        department.setCodeName("cnupd");
        department.setName("name-update");

        //when
        Department testDepartment = departmentRepository.save(department);

        //then
        assertThat(testDepartment, equalTo(department));
    }

    @Test
    public void shouldDeleteDepartment() {
        //given
        Long id = 1L;

        //when
        departmentRepository.deleteById(id);

        //then
        Optional<Department> testDepartment = departmentRepository.findById(id);
        assertThat(testDepartment.isPresent(), is(false));
    }
}
