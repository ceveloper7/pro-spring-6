package com.ceva.spring6.eight;

import com.ceva.spring6.eight.config.JpaConfig;
import com.ceva.spring6.eight.service.SingerSummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UntypedResultDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(UntypedResultDemo.class);
    public static void main(String[] args) {
        try(var ctx = new AnnotationConfigApplicationContext(JpaConfig.class)){
            var singerSummaryService = ctx.getBean(SingerSummaryService.class);

            LOGGER.info(" ---- Listing All Singers with Album as Record:");
            var singers = singerSummaryService.findAllAsRecord()
                    .peek(s -> LOGGER.info(s.toString()))
                    .toList();

            LOGGER.info(" ---- Listing All Singers with Album as POJO:");
            var cantantes = singerSummaryService.findAll()
                    .peek(s -> LOGGER.info(s.toString()))
                    .toList();
        }
    }
}
