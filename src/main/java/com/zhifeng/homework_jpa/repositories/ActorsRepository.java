package com.zhifeng.homework_jpa.repositories;

import com.zhifeng.homework_jpa.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ActorsRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastName(String lastName);

    @Query("select a from Actor a where a.firstName = :firstName and a.lastName = :lastName ")
    List<Actor> findByLastNameAndLastName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    @Modifying
    @Query(value = "insert into actors(first_name,last_name,gender,date_Of_Birth) values(?,?,?,?)", nativeQuery = true)
    int insertActor(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("gender") String gender, LocalDate dateOfBirth);

    @Modifying
    @Query("delete from Actor a where a.id = :id")
    void deleteActorById(@Param("id") long id);

    @Modifying
    @Query("UPDATE Actor a set a.firstName=:firstName, a.lastName = :lastName, a.gender = :gender, a.dateOfBirth = :dateOfBirth where a.id = :id")
    void updateActorById(@Param("id") long id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("gender") String gender, @Param("dateOfBirth") LocalDate dateOfBirth);
}
