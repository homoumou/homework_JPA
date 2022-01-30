package com.zhifeng.homework_jpa;

import com.zhifeng.homework_jpa.entities.Actor;
import com.zhifeng.homework_jpa.repositories.ActorsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
@SpringBootApplication is a convenience annotation that adds all of the following:

@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
*
*/
@SpringBootApplication
public class HomeworkJpaApplication {
    private static final Logger log =
            LoggerFactory.getLogger(HomeworkJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HomeworkJpaApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(ActorsRepository repository) {
//        return (args) -> {
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Actor actor : repository.findAll()) {
//                log.info(actor.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Actor actor = repository.findById(1);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(actor.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByFirstName('Alice'):");
//            log.info("--------------------------------------------");
//            repository.findByFirstName("Alice").forEach(alice -> {
//                log.info(alice.toString());
//            });
//            log.info("");
//        };
//    }

}
