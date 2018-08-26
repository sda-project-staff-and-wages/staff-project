package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.Companys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanysRepository extends JpaRepository<Companys, Long> {
    @Override
    Optional<Companys> findById(Long aLong);
}
