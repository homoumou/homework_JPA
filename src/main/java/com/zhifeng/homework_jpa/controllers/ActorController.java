package com.zhifeng.homework_jpa.controllers;

import com.zhifeng.homework_jpa.dtos.actor.ActorGetDto;
import com.zhifeng.homework_jpa.dtos.actor.ActorPostDto;
import com.zhifeng.homework_jpa.entities.Actor;
import com.zhifeng.homework_jpa.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@RestController // @Controller and @ResponseBody.
@RequestMapping("/actors")
//Annotation for mapping web requests onto methods, can be used both at the class and at the method level.
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;
//  GET for query (select)
//  Post for insert (create)
//  Put for update
//  Delete for delete
    @GetMapping("/findAll")
    // at the method level applications will prefer to use one of the HTTP method specific variants @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, or @PatchMapping.
    public ResponseEntity<List<ActorGetDto>> find() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/findById")
    public ResponseEntity<Optional<Actor>> findById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(actorService.getActorsById(id));
    }

    @GetMapping(path = "/{actorId}")
    public ResponseEntity<Optional<Actor>> findById2(@PathVariable("actorId") Long actorId) {
        return ResponseEntity.ok(actorService.getActorsById(actorId));
    }

    @GetMapping("/findByFristName")
    public ResponseEntity<List<ActorGetDto>> findByFristName(@RequestParam(value = "firstName") String firstName) {
        return ResponseEntity.ok(actorService.getActorsByFirstName(firstName));
    }

    @GetMapping("/findByFristNameAndLastName")
    public ResponseEntity<List<ActorGetDto>> findByFristNameAndLastName(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        return ResponseEntity.ok(actorService.getActorsByFirstNameAndLastName(firstName, lastName));
    }

    @PostMapping
    public ResponseEntity<ActorGetDto> addActor(@RequestBody ActorPostDto actorPostDto) {
        ActorGetDto actorGetDto = actorService.createActor(actorPostDto);
        return ResponseEntity.ok(actorGetDto);
    }

    @PostMapping("/insertActor")
    public int insertActor(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "gender") String gender, @RequestParam(value = "dateOfBirth") String dateOfBirth) {
       //String 转 localDate
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateOfBirth, fmt);
        return actorService.insertActor(firstName, lastName, gender, date);

    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity deleteActor(@PathVariable("actorId") Long id){
        actorService.deleteActor(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateActor")
    public ResponseEntity updateActor(@RequestParam(value = "id") Long id, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "gender") String gender, @RequestParam(value = "dateOfBirth") String dateOfBirth){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateOfBirth, fmt);
        actorService.updateActor(id, firstName, lastName, gender, date);
        return ResponseEntity.ok().build();
    }

}
