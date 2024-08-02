package com.ceva.spring6.eleven;

import com.ceva.spring6.eleven.domain.Blogger;
import com.ceva.spring6.eleven.property.editor.CustomEditorCfg;
import com.ceva.spring6.eleven.property.editor.CustomRegistrarCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoverterPropertiesTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoverterPropertiesTest.class);

    public static void main(String... args) {
        // creamos un contexto de la applicacion basados en AppConfig y CustomRegistrarCfg
        try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class, CustomRegistrarCfg.class)) {
            // recuperamos los beans springBlogger y awsBlogger
            var springBlogger = ctx.getBean("springBlogger", Blogger.class);
            LOGGER.info("SpringBlogger info: {}" , springBlogger);

            var awsBlogger  = ctx.getBean("awsBlogger", Blogger.class);
            LOGGER.info("AwsBlogger info: {}" , awsBlogger);

        }
    }
}
