package com.ceva.spring6.four.intf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DisposableBeanDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        ctx.close();
    }
}
