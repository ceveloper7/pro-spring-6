package com.ceva.spring6.four.jsr250;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class PostConstructDemo {
    private static Logger logger = LoggerFactory.getLogger(PostConstructDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(SingerConfiguration.class);

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
