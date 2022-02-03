package com.zhifeng.homework_jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue
    @Column(name = "director_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;
}
