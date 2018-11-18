package com.afernandezh.pocs.designpatterns.singleton;

import com.afernandezh.pocs.designpatterns.singleton.service.TaxCalculator;
import com.afernandezh.pocs.designpatterns.singleton.service.TaxCalculatorOld;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonPatternApplicationTests {

    private void showMemory() {
        long memUsed = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        log.info("Current memory used: " + memUsed + " KB");
    }

    private void measureTime(LocalDateTime startTime) {
        LocalDateTime endTime = LocalDateTime.now();
        long diff = startTime.until(endTime, ChronoUnit.MILLIS);
        log.info("Time spent to start: " + diff + " ms");
    }

    @Test
    public void testWithSingleton() {

        LocalDateTime startTime = LocalDateTime.now();

        showMemory();
        TaxCalculator t1 = TaxCalculator.getInstance();
        showMemory();
        TaxCalculator t2 = TaxCalculator.getInstance();
        showMemory();

        assertEquals("Expected equals classes", t1, t2);

        measureTime(startTime);
    }

    @Test
    public void testWithoutSingleton() {

        LocalDateTime startTime = LocalDateTime.now();

        showMemory();
        TaxCalculatorOld t1Old = new TaxCalculatorOld();
        showMemory();
        TaxCalculatorOld t2Old = new TaxCalculatorOld();
        showMemory();

        assertNotEquals("Expected not equals classes", t1Old, t2Old);

        measureTime(startTime);
    }

}
