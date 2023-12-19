package com.ceva.prospring6.four.naming;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
public class BeanNamingDemo {
    private static Logger logger = LoggerFactory.getLogger(BeanNamingDemo.class);

    public static void main(String... args) {
        // creamos ApplicationContext basado en la configuracion de BeanNamingCfg
        var ctx = new AnnotationConfigApplicationContext(BeanNamingCfg.class);
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(beanName -> logger.debug(beanName));

        try {
            ctx.getBean(SimpleBean.class);
        } catch (Exception e) {
            logger.debug("More beans than expected found. ", e);
        }

        logger.info(" ... All beans of type: {} ", SimpleBean.class.getSimpleName());
        var beans = ctx.getBeansOfType(SimpleBean.class);
        beans.entrySet().forEach(b -> System.out.println(b.getKey()));
    }
}

@Configuration // cualquier clase de configuracion en esencia una definicion de bean
@ComponentScan
class BeanNamingCfg {

    @Bean
    public SimpleBean  anotherSimpleBean(){
        return new SimpleBean();
    }
}

@Component
class SimpleBean { }

