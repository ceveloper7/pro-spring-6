package com.ceva.spring6.ten;

import com.ceva.spring6.ten.config.DataJpaCfg;
import com.ceva.spring6.ten.entities.SingerAudit;
import com.ceva.spring6.ten.services.SingerAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class AuditServiceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceDemo.class);

    @Autowired
    SingerAuditService singerAuditService;

    void setUp(SingerAuditService service){
        var singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(LocalDate.of(1940, 8, 16));
        service.save(singer);
    }

    void testFindById(SingerAuditService service){
        var singer = service.findAll().findFirst().orElse(null);

        LOGGER.info(">> created record: {} ", singer);
    }

    void testUpdate(SingerAuditService service){
        var singer = service.findAll().findFirst().orElse(null);
        singer.setFirstName("Riley B.");
        var updated = service.save(singer);
        LOGGER.info(">> updated record: {} ", updated);
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(DataJpaCfg.class);
        var service = ctx.getBean(SingerAuditService.class);

        AuditServiceDemo demo = new AuditServiceDemo();
        demo.setUp(service);

        demo.testFindById(service);
    }
}
