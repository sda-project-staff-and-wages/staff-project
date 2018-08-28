package com.project.sda.timetable.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "companys")
public class Companys {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "trade")
    @NotNull
    private String trade;

    @Column(name = "adress")
    @NotNull
    private String adress;

    @Column(name = "nip")
    @NotNull
    private String nip;
}
