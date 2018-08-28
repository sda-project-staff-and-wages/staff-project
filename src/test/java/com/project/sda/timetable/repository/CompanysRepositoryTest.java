package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.Companys;
import com.project.sda.timetable.model.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

public class CompanysRepositoryTest {

    @Autowired
    private CompanysRepository companysRepository;

    @Test
    public void shouldGetCompanysByID() {
        //given
        Long id = 1L;
        Companys company1 = new Companys();

        //when
        Optional<Companys> testCompanys = companysRepository.findById(id);

        //then
        assertThat(testCompanys.isPresent(), is(true));
        assertThat(testCompanys.get(), equalTo(company1));
    }

    @Test
    public void shouldGetCompanyByName() {
        //given
        String name = "company1";
        Companys company1 = new Companys();

        //when
        Optional<Companys> testCompanys = companysRepository.findByName(name);

        //then
        assertThat(testCompanys.isPresent(), is(true));
        assertThat(testCompanys.get(), equalTo(company1));
    }

    @Test
    public void shouldGetCompanyByTrade() {
        //given
        String trade = "trade1";
        Companys company1 = new Companys();

        //when
        Optional<Companys> testCompanys = companysRepository.findByTrade(trade);

        //then
        assertThat(testCompanys.isPresent(), is(true));
        assertThat(testCompanys.get(), equalTo(company1));
    }

    @Test
    public void shouldGetCompanyByAdress() {
        //given
        String adress = "adres1";
        Companys company1 = new Companys();

        //when
        Optional<Companys> testCompanys = companysRepository.findByAdress(adress);

        //then
        assertThat(testCompanys.isPresent(), is(true));
        assertThat(testCompanys.get(), equalTo(company1));
    }

    @Test
    public void shouldGetCompanyByNIP() {
        //given
        Long nip = 1234567890L;
        Companys company1 = new Companys();

        //when
        Optional<Companys> testCompanys = companysRepository.findByNip(nip);

        //then
        assertThat(testCompanys.isPresent(), is(true));
        assertThat(testCompanys.get(), equalTo(company1));
    }

    @Test
    public void shouldGetAllCompanys() {
        //given
        Companys company1 = new Companys();
        Companys company2 = new Companys();

        //when
        List<Companys> testCompanys = companysRepository.findAll();

        //then
        assertThat(testCompanys, hasSize(2));
        assertThat(testCompanys, hasItems(company1, company2));
    }

    @Test
    public void shouldAddCompany() {
        //given
        Companys company1 = new Companys();

        //when
        Companys testCompanys = companysRepository.save(company1);

        //then
        assertThat(testCompanys.getId(), is(notNullValue()));
        assertThat(testCompanys.getName(), equalTo(company1.getName()));
        assertThat(testCompanys.getTrade(), equalTo(company1.getTrade()));
        assertThat(testCompanys.getAdress(), equalTo(company1.getAdress()));
        assertThat(testCompanys.getNip(), equalTo(company1.getNip()));
    }

    @Test
    public void shouldUpdateCompany() {
        //given
        Companys company1 = new Companys();
        company1.setName("company1");
        company1.setTrade("trade1");
        company1.setAdress("adress1");
        company1.setNip(1234567890L);

        //when
        Companys testCompanys = companysRepository.save(company1);

        //then
        assertThat(testCompanys, equalTo(company1));

    }

    @Test
    public void shouldDeleteCompany() {
        //given
        Long id = 1L;

        //when
        companysRepository.deleteById(id);

        //then
        Optional<Companys> testCompanys = companysRepository.findById(id);
        assertThat(testCompanys.isPresent(), is(false));
    }
}
