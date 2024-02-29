package com.ceva.spring6.four.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageSourceDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(MessageSourceConfig.class);

        Locale english = Locale.ENGLISH;
        // JDK 19
        //Locale ukrainian = Locale.of("uk", "UA");
        // JDK 17
        Locale ukrainian = new Locale("uk", "UA");
        LOGGER.info(ctx.getMessage("msg", null, english));
        LOGGER.info(ctx.getMessage("msg", null, ukrainian));
        LOGGER.info(ctx.getMessage("nameMsg", new Object[]{ "Iuliana", "Cosmina" }, english));
        LOGGER.info(ctx.getMessage("nameMsg", new Object[]{ "Iuliana", "Cosmina" }, ukrainian));
        ctx.close();
    }
}
