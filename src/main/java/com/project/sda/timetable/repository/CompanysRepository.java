package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.Companys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanysRepository extends JpaRepository<Companys, Long> {
    Optional<Companys> findByName(String name);
    Optional<Companys> findByTrade(String trade);
    Optional<Companys> findByAdress(String adress);
    Optional<Companys> findByNip(Long Nip);
}
