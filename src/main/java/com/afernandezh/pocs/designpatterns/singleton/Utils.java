package com.afernandezh.pocs.designpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    public static long showMemory() {
        long memUsed = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        log.info("Memory used: " + memUsed + " KB");
        return memUsed;
    }
}
