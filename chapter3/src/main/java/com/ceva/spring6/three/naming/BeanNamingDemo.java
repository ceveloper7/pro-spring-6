package com.ceva.spring6.three.naming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BeanNamingDemo {
    private static Logger logger = LoggerFactory.getLogger(BeanNamingDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(BeanNamingCfg.class);
        // imprimimos por consola todos los nombres de bean dentro de contexto
        /**
         * Imprime: (spring cambia la primera letra a minuscula)
         * beanNamingCfg -> La anotacion @Configurartion incluye @Component por ello
         *                  la clase anotada con @Configurarion es un bean
         * simpleBean
         * anotherSimpleBean
         */
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(beanName -> logger.debug(beanName)); // recuperamos todo los nombres de los beans
/*
        try {
            ctx.getBean(SimpleBean.class);
        } catch (Exception e) {
            logger.debug("More beans than expected found. ", e);
        }

        logger.info(" ... All beans of type: {} ", SimpleBean.class.getSimpleName());
        var beans = ctx.getBeansOfType(SimpleBean.class);
        beans.entrySet().forEach(b -> System.out.println(b.getKey()));
*/
    }
}
