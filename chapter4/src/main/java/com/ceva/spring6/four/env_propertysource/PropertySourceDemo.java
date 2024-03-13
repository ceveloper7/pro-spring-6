package com.ceva.spring6.four.env_propertysource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceDemo {
    private static Logger logger = LoggerFactory.getLogger(PropertySourceDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(PropDemoConfig.class);

        var appProperty = ctx.getBean("appProperty", AppProperty.class);
        logger.info("Outcome: {}", appProperty);
    }
}
