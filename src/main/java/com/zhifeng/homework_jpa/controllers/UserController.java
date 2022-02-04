package com.zhifeng.homework_jpa.controllers;

import com.zhifeng.homework_jpa.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //   /error默认错误请求
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping("/user")
    public User user() {
        return new User();
    }
}
