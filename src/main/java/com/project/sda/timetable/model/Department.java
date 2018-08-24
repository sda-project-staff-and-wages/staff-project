package com.project.sda.timetable.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code_name")
    @NonNull
    String codeName;

    @Column(name = "name")
    @NonNull
    String name;
}
