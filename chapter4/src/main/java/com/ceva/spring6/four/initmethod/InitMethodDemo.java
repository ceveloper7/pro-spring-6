package com.ceva.spring6.four.initmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitMethodDemo {
    private static Logger logger = LoggerFactory.getLogger(InitMethodDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(SingerConfiguration.class);

        // obtenemos los 3 beans de tipo Singer
        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static Singer getBean(String beanName, ApplicationContext ctx) {
        try {
            Singer bean = (Singer) ctx.getBean(beanName);
            logger.info("Found: {}", bean);
            return bean;
        } catch (BeanCreationException ex) {
            logger.error("An error occured in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
