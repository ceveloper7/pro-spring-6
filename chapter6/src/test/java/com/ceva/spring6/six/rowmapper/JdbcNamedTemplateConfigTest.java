package com.ceva.spring6.six.rowmapper;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcNamedTemplateConfigTest {
    private static Logger LOGGER = LoggerFactory.getLogger(JdbcNamedTemplateConfigTest.class);

    @Test
    public void testFindAll() {
        var ctx = new AnnotationConfigApplicationContext(TestDbCfg.class);

        var singerDao = ctx.getBean("singerDao", SingerDao.class);

        var singers = singerDao.findAll();
        assertEquals(1, singers.size());
        singers.forEach(singer -> LOGGER.info(singer.toString()));

        ctx.close();
    }

    @Test
    public void testFindAllWithAlbums() {
        var ctx = new AnnotationConfigApplicationContext(TestDbCfg.class);

        var singerDao = ctx.getBean("singerDao", SingerDao.class);

        var singers = singerDao.findAllWithAlbums();
        assertEquals(1, singers.size());
        singers.forEach(singer -> LOGGER.info(singer.toString()));

        ctx.close();
    }
}
