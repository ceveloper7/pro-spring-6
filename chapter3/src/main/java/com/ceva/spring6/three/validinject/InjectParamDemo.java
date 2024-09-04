package com.ceva.spring6.three.validinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectParamDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var params = context.getBean("injectSimpleParams", InjectParam.class);
        System.out.println(params);
    }
}
