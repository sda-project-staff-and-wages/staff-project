package com.project.sda.timetable.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")

public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    @NonNull
    @ManyToMany
    Long company_id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "login", length = 9)
    @NonNull
    private String login;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "email")
    private String email;

}
