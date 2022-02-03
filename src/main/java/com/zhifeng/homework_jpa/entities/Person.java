package com.zhifeng.homework_jpa.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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
@Validated
public class Person {

//    @Value("${name}")

    @NotNull
    private String name;
    @Max(value=120, message = "age should less than 120")
    private Integer age;
    private Boolean happy;
    @Email(message = "wrong email format")
    private String email;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    /**
     * 空检查
     * @Null 验证对象是否为null
     * @NotNull 验证对象是否不为null, 无法查检长度为0的字符串
     * @NotBlank 检查约束字符串是不是Null还有被Trim的长度是否大于0, 只对字符串, 且会去掉前后空格.
     * @NotEmpty 检查约束元素是否为NULL或者是EMPTY.
     *
     * Booelan检查
     * @AssertTrue 验证 Boolean 对象是否为 true
     * @AssertFalse 验证 Boolean 对象是否为 false
     *
     * 长度检查
     * @Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
     * @Length(min=, max=) string is between min and max included.
     *
     * 日期检查
     * @Past 验证 Date 和 Calendar 对象是否在当前时间之前
     * @Future 验证 Date 和 Calendar 对象是否在当前时间之后
     * @Pattern 验证 String 对象是否符合正则表达式的规则
     */


}
