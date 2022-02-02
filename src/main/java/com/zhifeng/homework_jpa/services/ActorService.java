package com.zhifeng.homework_jpa.services;

import com.zhifeng.homework_jpa.dtos.actor.ActorGetDto;
import com.zhifeng.homework_jpa.dtos.actor.ActorPostDto;
import com.zhifeng.homework_jpa.entities.Actor;
import com.zhifeng.homework_jpa.mappers.ActorMapper;
import com.zhifeng.homework_jpa.repositories.ActorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorsRepository actorsRepository;
    private final ActorMapper actorMapper;

    public List<ActorGetDto> getAllActors() {
        return actorsRepository.findAll().stream()
                .map(actor -> actorMapper.fromEntity(actor))
                .collect(Collectors.toList());
    }

    public Optional<Actor> getActorsById(Long id) {
        Optional<Actor> actor = actorsRepository.findById(id);
        return actor;
    }

    public List<ActorGetDto> getActorsByFirstName(String firstName) {
        List<ActorGetDto> actorGetDto = actorsRepository.findByFirstName(firstName).stream()
                .map(actor -> actorMapper.fromEntity(actor))
                .collect(Collectors.toList());
        return actorGetDto;
    }

    public List<ActorGetDto> getActorsByFirstNameAndLastName(String firstName, String lastName) {
        List<ActorGetDto> actorGetDto = actorsRepository.findByLastNameAndLastName(firstName, lastName).stream()
                .map(actor -> actorMapper.fromEntity(actor))
                .collect(Collectors.toList());
        return actorGetDto;
    }

    @Transactional
    public int insertActor(String firstName, String lastName, String gender, LocalDate dateOfBirth) {
        return actorsRepository.insertActor(firstName, lastName, gender, dateOfBirth);
    }

    @Transactional
    public ActorGetDto createActor(ActorPostDto actorPostDto) {
        Actor actor = actorMapper.toEntity(actorPostDto);
        ActorGetDto actorGetDto = actorMapper.fromEntity(actorsRepository.save(actor));
        return actorGetDto;
    }

    @Transactional
    public void deleteActor(Long id) {
        actorsRepository.deleteActorById(id);
    }

    @Transactional
    public void updateActor(Long id,String firstName, String lastName, String gender, LocalDate dateOfBirth) {
        actorsRepository.updateActorById(id, firstName, lastName, gender, dateOfBirth);
    }

}
