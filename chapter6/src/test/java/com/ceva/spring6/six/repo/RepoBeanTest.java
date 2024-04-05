package com.ceva.spring6.six.repo;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import com.ceva.spring6.six.plain.records.Album;
import com.ceva.spring6.six.plain.records.Singer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class RepoBeanTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepoBeanTest.class);

    @Test
    public void testFindAllWithMappingSqlQuery() {
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);
        assertNotNull(singerRepo);

        var singers = singerRepo.findAll();
        assertEquals(1, singers.size());
        singers.forEach(singer -> LOGGER.info(singer.toString()));

        ctx.close();
    }

    @Test
    public void testFindByNameWithMappingSqlQuery() {
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);
        assertNotNull(singerRepo);

        var singers = singerRepo.findByFirstName("John");
        assertEquals(1, singers.size());
        LOGGER.info("Result: {}", singers.get(0));

        ctx.close();
    }
}
