package com.zhifeng.homework_jpa.controllers;

import com.zhifeng.homework_jpa.dtos.actor.ActorGetDto;
import com.zhifeng.homework_jpa.entities.Actor;
import com.zhifeng.homework_jpa.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // @Controller and @ResponseBody.
@RequestMapping("/actors") //Annotation for mapping web requests onto methods, can be used both at the class and at the method level.
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/findAll") // at the method level applications will prefer to use one of the HTTP method specific variants @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, or @PatchMapping.
    public ResponseEntity<List<ActorGetDto>> find() {return ResponseEntity.ok(actorService.getAllActors());}

    @GetMapping("/findById")
    public ResponseEntity<Optional<Actor>> findById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(actorService.getActorsById(id));
    }

    @GetMapping(path="/{actorId}")
    public ResponseEntity<Optional<Actor>> findById2(@PathVariable("actorId") Long actorId) {
        return ResponseEntity.ok(actorService.getActorsById(actorId));
    }

    @GetMapping("/findByFristName")
    public ResponseEntity<List<ActorGetDto>> findByFristName(@RequestParam(value = "firstName") String firstName) {
        return ResponseEntity.ok(actorService.getActorsByFirstName(firstName));
    }
}
