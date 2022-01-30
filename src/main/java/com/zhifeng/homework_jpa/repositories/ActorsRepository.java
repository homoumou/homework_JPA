package com.zhifeng.homework_jpa.repositories;

import com.zhifeng.homework_jpa.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorsRepository  extends JpaRepository<Actor, Long> {
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
}
