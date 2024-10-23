package com.ceva.spring6.six.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
public class JdbcTemplateConfigTest {
    @Test
    public void testSpringJdbc() {
        var ctx = new AnnotationConfigApplicationContext(TestDbCfg.class);
        var jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        assertNotNull(jdbcTemplate);

        var singerDao = ctx.getBean("singerDao", SingerDao.class);
        // Probamos que findNameById() retorne la cadena John Alexander Waymon
        assertEquals("John Alexander Waymon", singerDao.findNameById(1L));
        ctx.close();
    }
}
