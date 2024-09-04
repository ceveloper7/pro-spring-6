package com.ceva.spring6.three.validinject.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectSimpleParamDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var spel = context.getBean("injectSimpleSpel", InjectSimpleSpel.class);

        System.out.println(spel);
    }
}
