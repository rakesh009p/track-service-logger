package com.stackroute.trackservice;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

@SpringBootApplication
public class TrackServiceApplication {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TrackServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrackServiceApplication.class, args);
        logger.debug("This is Debug message");
        logger.error("This is error");
        logger.info("This is for info");
        logger.trace("Trace Message");
        logger.warn("Warning in your code");
    }
}