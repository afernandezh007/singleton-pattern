package com.afernandezh.pocs.designpatterns.singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SingletonPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingletonPatternApplication.class, args);
    }
}
