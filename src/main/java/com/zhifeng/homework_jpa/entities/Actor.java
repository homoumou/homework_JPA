package com.zhifeng.homework_jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //indicating that it is a JPA entity
@Data  //lombok getter + setter
@Table(name = "actors") // this entity is mapped to a table named actors
public class Actor {

    @Id // annotated as primary key
    @GeneratedValue // indicate that the ID should be generated automatically.
    @Column(name = "actor_id") // without column anotation. It is assumed that they are mapped to columns that share the same names as the properties themselves.
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


}
