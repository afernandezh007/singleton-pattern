package com.afernandezh.pocs.designpatterns.singleton.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Example class to illustrate a complex service
 */
@Slf4j
public class TaxCalculator {


    //==================================================================================
    //-------------------------------- SINGLETON PATTERN -------------------------------
    //==================================================================================

    //static inner class. This class is not loaded until you call it
    private static class SingletonHelper{
        private static TaxCalculator instance = new TaxCalculator();
    }

    /**
     * Private constructor to avoid external instantiation
     */
    private TaxCalculator() {
        log.info(" Private constructor invoked");
    }

    /**
     * static method to build a new instance or return the existing one
     *
     * @return
     */
    public static TaxCalculator getInstance() {
        TaxCalculator instance = SingletonHelper.instance;
        log.info(" Return existing instance " + instance);
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
