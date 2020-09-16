package com.infosys.taskinfomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan(basePackages = {"com.infosys"})
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.infosys.taskinfomanager.repository"})
@EntityScan("com.infosys")
@RestController
public class TaskinfomanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskinfomanagerApplication.class, args);
    }

}
