package com.project.sda.timetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;

public class WorkingHours {

    @Id
    @Column(name = "workday")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    @NotNull
    private Data workday;

    @Column(name = "employee_id")
    @NotNull
    //@ManyToOne
    private int employee_id;

    @Column(name = "start_hour")
    @NotNull
    private int start_hour;

    @Column(name = "start_minut")
    private int start_minut = 0;

    @Column(name = "end_hour")
    @NotNull
    private int end_hour;

    @Column(name = "end_minut")
    private int end_minut = 0;

    @Column(name = "work_time")
    private int work_time;

    @Column(name = "absence_type")
    private String absence_type;
}
