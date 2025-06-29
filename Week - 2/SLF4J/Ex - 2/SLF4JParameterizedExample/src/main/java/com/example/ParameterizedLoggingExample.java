package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Alice";
        int tasks = 4;

        logger.info("User {} has logged in.", username);
        logger.warn("User {} has {} pending tasks.", username, tasks);
        logger.error("An error occurred while processing data for user {}", username);
    }
}
