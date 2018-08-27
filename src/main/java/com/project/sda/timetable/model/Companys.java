package com.project.sda.timetable.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "companys")
public class Companys {

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    @NotNull
    String name;

    @Column(name = "trade")
    @NotNull
    String trade;

    @Column(name = "adress")
    @NotNull
    String adress;

    @Column(name = "nip")
    @NotNull
    Long nip;
}
