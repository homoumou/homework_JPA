package com.zhifeng.homework_jpa;

import com.zhifeng.homework_jpa.entities.Dog;
import com.zhifeng.homework_jpa.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HomeworkJpaApplicationTests {

    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
