package com.pelican.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Created by Nightingale on 15.08.2014.
 */
public class Loggers {
//
//    static {
//        try {
//            System.setProperty("log4j.configurationFile", "conf/log/log4j2.xml");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static final Logger exceptionLogger = LogManager.getLogger("exception_logger");
    public static final Logger debugLogger = LogManager.getLogger("debug_logger");

    public static void logException(Exception e) {
        exceptionLogger.error(e.getMessage(), e);
    }



}
