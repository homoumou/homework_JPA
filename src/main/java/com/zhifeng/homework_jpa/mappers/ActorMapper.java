package com.zhifeng.homework_jpa.mappers;

import com.zhifeng.homework_jpa.dtos.actor.ActorGetDto;
import com.zhifeng.homework_jpa.dtos.actor.ActorPostDto;
import com.zhifeng.homework_jpa.dtos.actor.ActorPutDto;
import com.zhifeng.homework_jpa.entities.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActorMapper {
    Actor toEntity(ActorPostDto actorPostDto);

    ActorGetDto fromEntity(Actor actor);

    void copy(ActorPutDto actorPutDto, @MappingTarget Actor actor);
}
