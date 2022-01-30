package com.zhifeng.homework_jpa.dtos.actor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActorPostDto {
    private String firstName;
    private String lastnNme;
    private String gender;
    private LocalDate dateOfBirth;
}
