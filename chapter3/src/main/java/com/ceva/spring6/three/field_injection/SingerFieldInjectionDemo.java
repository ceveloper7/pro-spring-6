package com.ceva.spring6.three.field_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingerFieldInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var singer = context.getBean("singer", Singer.class);
        singer.sing();
    }
}
