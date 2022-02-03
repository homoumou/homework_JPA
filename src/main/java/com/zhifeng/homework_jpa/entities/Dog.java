package com.zhifeng.homework_jpa.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Dog {
    @Value("阿黄")
    private String name;
    @Value("18")
    private Integer age;
}
