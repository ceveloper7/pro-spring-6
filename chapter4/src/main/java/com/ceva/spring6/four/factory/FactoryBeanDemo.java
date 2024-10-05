package com.ceva.spring6.four.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.MessageDigest;

/*
 * Clase que recupera el bean MessageDigester del BeanFactory y creamos un resumen de un mensaje simple.
 */
public class FactoryBeanDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(FactoryBeanDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("b4000$.");

        LOGGER.debug("-------------------------------------");

        /*
         * Accediendo directamente a un FactorBean
         * anteponiendo & al nombre del bean podemos acceder al FactoryBean
         * Nota: Debemos evitar acceder al FactoryBean directamente e invocar al metodo getObject() manualmente.
         */
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
