package com.project.sda.timetable.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "group")
public class Group {

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
