package com.ceva.spring6.three.naminggenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BeanNameGerneratorDemo {
    private static Logger logger = LoggerFactory.getLogger(BeanNameGerneratorDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(BeanNamingCfg.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(beanName -> logger.debug(beanName));
        try {
            var sb = ctx.getBean("simpleBean");
        } catch (NoSuchBeanDefinitionException nsb) {
            logger.debug(" Bean '{}' could not be found.", nsb.getBeanName());
        }
    }
}
