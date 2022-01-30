package com.zhifeng.homework_jpa.services;

import com.zhifeng.homework_jpa.dtos.actor.ActorGetDto;
import com.zhifeng.homework_jpa.entities.Actor;
import com.zhifeng.homework_jpa.mappers.ActorMapper;
import com.zhifeng.homework_jpa.repositories.ActorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActorService {
    private  final ActorsRepository actorsRepository;
    private final ActorMapper actorMapper;
    public List<ActorGetDto> getAllActors(){
        return actorsRepository.findAll().stream()
                .map(actor -> actorMapper.fromEntity(actor))
                .collect(Collectors.toList());
    }

    public Optional<Actor> getActorsById(Long id){
        Optional<Actor> actor = actorsRepository.findById(id);
        return actor;
    }

    public List<ActorGetDto> getActorsByFirstName(String firstName){
        List<ActorGetDto> actorGetDto = actorsRepository.findByFirstName(firstName).stream()
                .map(actor -> actorMapper.fromEntity(actor))
                .collect(Collectors.toList());
        return actorGetDto;
    }

}