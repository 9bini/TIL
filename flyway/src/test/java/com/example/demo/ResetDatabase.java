package com.example.demo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.output.OperationResultBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResetDatabase {
    @Autowired
    private Flyway flyway;
    Logger logger = LoggerFactory.getLogger(ResetDatabase.class);

    @BeforeEach
    public void setUp(){
        logger.info("DB 초기화 실행");
        try {
            flyway.clean();
            flyway.migrate();
            logger.info("DB 초기화 성공");
        }catch (FlywayException e){
            logger.error("DB 초기화 실패");
        }
    }
}
