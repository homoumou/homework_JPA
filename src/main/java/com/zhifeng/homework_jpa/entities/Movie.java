package com.zhifeng.homework_jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_length")
    private String movieLength;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "age_certificate")
    private String ageCertificate;

//    @OneToOne(mappedBy = "movie")
//    private MovieRevene movieRevene;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

//
//    @ManyToMany
//    @JoinTable(name = "movies_actors")
//            joinColumns = @JoinColumn(name = "actor_id"),
//            inverseJoinColumns = @JoinColumn(name = "movie_id")
//    private Set<Actor> actors;
}
