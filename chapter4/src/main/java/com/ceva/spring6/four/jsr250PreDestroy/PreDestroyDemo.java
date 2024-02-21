package com.ceva.spring6.four.jsr250PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PreDestroyDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        ctx.close();
    }
}
