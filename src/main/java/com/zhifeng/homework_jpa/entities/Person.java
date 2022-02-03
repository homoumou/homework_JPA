package com.zhifeng.homework_jpa.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Data
/**
 * @PropertySource ：**加载指定的配置文件；
 * @configurationProperties：默认从全局配置文件中获取值；
 */
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = "classpath:person.properties")
public class Person {
    @Value("${name}")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
