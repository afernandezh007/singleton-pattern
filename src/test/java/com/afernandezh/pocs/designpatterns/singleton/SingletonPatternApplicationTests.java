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

import static com.afernandezh.pocs.designpatterns.singleton.Utils.showMemory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonPatternApplicationTests {

    private void measureMemory(long startMemUsed) {
        long endMemUsed = Utils.showMemory();
        log.info("Memory spent to start: " + (endMemUsed - startMemUsed) + " KB");
    }

    private void measureTime(LocalDateTime startTime) {
        LocalDateTime endTime = LocalDateTime.now();
        long diff = startTime.until(endTime, ChronoUnit.MILLIS);
        log.info("Time spent to start: " + diff + " ms");
    }

    @Test
    public void testWithSingleton() {

        LocalDateTime startTime = LocalDateTime.now();
        long startMemUsed = Utils.showMemory();

        TaxCalculator t1 = TaxCalculator.getInstance();
        TaxCalculator t2 = TaxCalculator.getInstance();

        assertEquals("Expected equals classes", t1, t2);

        measureTime(startTime);
        measureMemory(startMemUsed);
    }

    @Test
    public void testWithoutSingleton() {

        LocalDateTime startTime = LocalDateTime.now();
        long startMemUsed = Utils.showMemory();


        TaxCalculatorOld t1Old = new TaxCalculatorOld();
        Utils.showMemory();
        TaxCalculatorOld t2Old = new TaxCalculatorOld();
        Utils.showMemory();

        assertNotEquals("Expected not equals classes", t1Old, t2Old);

        measureTime(startTime);
        measureMemory(startMemUsed);
    }

}
