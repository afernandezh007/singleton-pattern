package com.afernandezh.pocs.designpatterns.singleton.service;

import com.afernandezh.pocs.designpatterns.singleton.Utils;
import lombok.extern.slf4j.Slf4j;

/**
 * Example class to illustrate a complex service
 */
@Slf4j
public class TaxCalculator {

    private Double[][] data = new Double[1000][1000];

    //==================================================================================
    //-------------------------------- SINGLETON PATTERN -------------------------------
    //==================================================================================
    //eager instantiation
    private static TaxCalculator instance = new TaxCalculator();

    /**
     * Private constructor to avoid external instantiation
     */
    private TaxCalculator() {
        log.info(" Private constructor invoked");
        try {
            Thread.sleep(1000);
            log.info(" Subsystem 1 init finished");
            Thread.sleep(2500);
            log.info(" Subsystem 2 init finished");
            Thread.sleep(3000);
            log.info(" Subsystem 3 init finished");
        } catch (InterruptedException e) {
            log.error("Exception :", e);
        }
    }

    /**
     * static method to get the existing instance
     *
     * @return
     */
    public static TaxCalculator getInstance() {
        log.info(" Return existing instance " + instance);
        Utils.showMemory();
        return instance;
    }
    //==================================================================================
    //------------------------------ END SINGLETON PATTERN -----------------------------
    //==================================================================================

    /**
     * Dummy method
     *
     * @param year
     * @return
     */
    public Double getAnnualTax(Integer year) {

        Double tax;

        switch (year) {
            case 2018:
                tax = 1.5d;
                break;
            case 2017:
                tax = 1.4d;
                break;
            default:
                tax = 1.0d;
        }
        return tax;
    }
}
