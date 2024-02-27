package com.ceva.spring6.four.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.MessageDigest;

public class FactoryBeanDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(FactoryBeanDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");

        LOGGER.debug("-------------------------------------");

        // anteponiendo & al nombre del bean podemos acceder al FctoryBean
        MessageDigestFactoryBean factoryBean =
                (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        try {
            MessageDigest shaDigest = factoryBean.getObject();
            LOGGER.info("Explicit use digest bean: {}", shaDigest.digest("Hello world".getBytes()));
        } catch (Exception ex) {
            LOGGER.error("Could not find MessageDigestFactoryBean ", ex);
        }

        ctx.close();
    }
}
