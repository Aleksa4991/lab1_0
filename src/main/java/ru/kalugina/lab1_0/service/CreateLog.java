package ru.kalugina.lab1_0.service;

import org.springframework.stereotype.Service;

@Service
public class CreateLog implements MyLogger {
    @Override
    public void createLog(org.slf4j.Logger logger) {
        logger.debug("This is Debag");
        logger.info("This is Info");
        logger.error("This is error");
        logger.trace("This is Trace");
    }
}
