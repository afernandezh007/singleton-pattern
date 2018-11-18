package com.afernandezh.pocs.designpatterns.singleton;

import com.afernandezh.pocs.designpatterns.singleton.service.TaxCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SingletonPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingletonPatternApplication.class, args);

        TaxCalculator t1 = TaxCalculator.getInstance();
        TaxCalculator t2 = TaxCalculator.getInstance();

        if(t1.equals(t2)) {
            log.info("Both instances are the same");
        }
    }
}
