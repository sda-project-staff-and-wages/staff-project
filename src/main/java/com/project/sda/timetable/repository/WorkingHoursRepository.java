package com.project.sda.timetable.repository;

import com.project.sda.timetable.model.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

}
