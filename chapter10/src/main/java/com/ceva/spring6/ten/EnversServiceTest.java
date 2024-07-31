package com.ceva.spring6.ten;

import com.ceva.spring6.ten.config.AuditCfg;
import com.ceva.spring6.ten.config.DataJpaCfg;
import com.ceva.spring6.ten.config.EnversConfig;
import com.ceva.spring6.ten.entities.SingerAudit;
import com.ceva.spring6.ten.services.SingerAuditService;
import jakarta.annotation.PostConstruct;
import org.hibernate.cfg.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import java.time.LocalDate;
import java.util.Properties;

public class EnversServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnversServiceTest.class);

    @Autowired
    SingerAuditService auditService;

    void setUp(SingerAuditService service){
        var singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(LocalDate.of(1940, 8, 16));
        service.save(singer);
    }

    void testFindAuditByRevision(SingerAuditService service){
        var singer = service.findAll().findFirst().orElse(null);
        singer.setFirstName("Riley B.");
        service.save(singer);

        var oldSinger = service.findAuditByRevision(singer.getId(), 1);
        LOGGER.info(">> old singer: {} ", oldSinger);

        var newSinger = service.findAuditByRevision(singer.getId(), 2);
        LOGGER.info(">> updated singer: {} ", newSinger);
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(EnversConfig.class);
        var service = ctx.getBean(SingerAuditService.class);

        EnversServiceTest demo = new EnversServiceTest();
        demo.setUp(service);
        demo.testFindAuditByRevision(service);
    }
}
