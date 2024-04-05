package com.ceva.spring6.six.namedparameter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JdbcNamedTemplateConfigTest {
    @Test
    public void testSpringJdbc() {
        var ctx = new AnnotationConfigApplicationContext(TestDbCfg.class);
        var namedTemplate = ctx.getBean("namedTemplate", NamedParameterJdbcTemplate.class);
        assertNotNull(namedTemplate);

        var singerDao = ctx.getBean("singerDao", SingerDao.class);

        assertEquals("John Mayer", singerDao.findNameById(1L));
        ctx.close();
    }
}
